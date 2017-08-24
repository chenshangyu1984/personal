package com.shangyu.personal.zendesk;

import org.springframework.util.StringUtils;

import java.util.Scanner;

/**
 * Created by shangyu on 16/8/17.
 */
public class GameUtils {
    public static final Integer WINNER_LEN = 3;
    public static final String MARKER_X = "X";
    public static final String MARKER_O = "O";

    public static int getSizeOfGame(Scanner scanner, String text) {
        int size = 0;
        while (true) {
            System.out.print(text);
            try {
                String line = scanner.nextLine();
                size = Integer.parseInt(line);
            } catch (Exception e) {
                continue;
            }

            if (size < WINNER_LEN) {
                continue;
            }

            break;
        }

        return size;
    }

    public static String getNameOfPlayer(Scanner scanner, String text) {
        String name = null;
        while (true) {
            System.out.print(text);
            name = scanner.nextLine();
            if (StringUtils.isEmpty(name)) {
                continue;
            }

            break;
        }

        return name;
    }

    public static int getBoxIndex(Scanner scanner, String text, Board board, Player player) {
        int boxIndex = 0;
        String _text = String.format(text, player.getName(), player.getMarker());

        while (true) {
            System.out.print(_text);

            try {
                String line = scanner.nextLine();
                boxIndex = Integer.parseInt(line) - 1;
            } catch (Exception e) {
                continue;
            }

            // validate index
            if (!board.isValidIndex(boxIndex)) {
                continue;
            }

            // check index has been placed
            if (board.getBox(boxIndex) != null) {
                continue;
            }

            break;
        }

        return boxIndex;
    }

    public static void printGame(Board board) {
        System.out.println();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                String text = board.getBox(i * board.getSize() + j);
                if (text == null) {
                    text = "" + (i * board.getSize() + j + 1);
                }
                System.out.print(padding(text));

                if (j < board.getSize() - 1) {
                    System.out.print("|");
                }
            }

            System.out.println();
            // print dashed line
            if (i < board.getSize() - 1) {
                for (int j = 0; j < board.getSize(); j++) {
                    System.out.print("---");

                    if (j < board.getSize() - 1) {
                        System.out.print("-");
                    }
                }
            }
            System.out.println();
        }
    }

    public static Result playGame(Scanner scanner, Board board) {
        // name of player 1
        String player1Name = GameUtils.getNameOfPlayer(scanner, "Enter name for Player 1: ");
        Player player1 = new Player(player1Name, GameUtils.MARKER_X);

        // name of player 2
        String player2Name = GameUtils.getNameOfPlayer(scanner, "Enter name for Player 2: ");
        Player player2 = new Player(player2Name, GameUtils.MARKER_O);

        // print initial game
        GameUtils.printGame(board);

        // play game
        String text = "%s, choose a box to place an '%s' into: ";
        Player player = player1;
        while (true) {
            int index = GameUtils.getBoxIndex(scanner, text, board, player);

            Result result = GameUtils.playGame(board, player, index);
            if (result != null) {
                if (result.getWinner() != null) {
                    System.out.println("Congratulations " + result.getWinner().getName() + "! You have won.");
                } else {
                    System.out.println("Game is tied.");
                }

                return result;
            }

            player = player == player1 ? player2 : player1;
        }
    }

    public static Result playGame(Board board, Player player, int boxIndex) {
        // set board's box
        board.setBox(boxIndex, player.getMarker());

        // print game
        printGame(board);

        // check winner
        if (board.getFilled() >= WINNER_LEN * 2 - 1) {
            // determine winner if any
            if (determineWinner(board, boxIndex)) {
                return new Result(player);
            }

            // tie
            if (board.getFilled() == board.getSize() * board.getSize()) {
                return new Result();
            }
        }

        return null;
    }

    public static boolean determineWinner(Board board, int index) {
        String marker = board.getBox(index);
        int rowIndex = index / board.getSize();
        int columnIndex = index % board.getSize();

        // horizontally
        // from current to left (columnIndex decreased by 1)
        if (toColumnLeftOrRowTop(columnIndex) &&
                checkWinner(board, marker, rowIndex, 0, columnIndex, -1)) {
            return true;
        }
        // from current to right (columnIndex increased by 1)
        if (toColumnRightOrRowBottom(board.getSize(), columnIndex) &&
                checkWinner(board, marker, rowIndex, 0, columnIndex, 1)) {
            return true;
        }

        // vertically
        // from current to bottom (rowIndex increased by 1)
        if (toColumnRightOrRowBottom(board.getSize(), rowIndex) &&
                checkWinner(board, marker, rowIndex, 1, columnIndex, 0)) {
            return true;
        }
        // from current to top (rowIndex decreased by 1)
        if (toColumnLeftOrRowTop(rowIndex) &&
                checkWinner(board, marker, rowIndex, -1, columnIndex, 0)) {
            return true;
        }

        // diagonally
        // from current to left bottom (rowIndex increased by 1, columnIndex decreased by 1)
        if (toColumnRightOrRowBottom(board.getSize(), rowIndex) &&
                toColumnLeftOrRowTop(columnIndex) &&
                checkWinner(board, marker, rowIndex, 1, columnIndex, -1)) {
            return true;
        }
        // from current to left top (rowIndex decreased by 1, columnIndex decreased by 1)
        if (toColumnLeftOrRowTop(rowIndex) &&
                toColumnLeftOrRowTop(columnIndex) &&
                checkWinner(board, marker, rowIndex, -1, columnIndex, -1)) {
            return true;
        }
        // from current to right bottom (rowIndex increased by 1, columnIndex increased by 1)
        if (toColumnRightOrRowBottom(board.getSize(), rowIndex) &&
                toColumnRightOrRowBottom(board.getSize(), columnIndex)  &&
                checkWinner(board, marker, rowIndex, 1, columnIndex, 1)) {
            return true;
        }
        // from current to right top (rowIndex decreased by 1, columnIndex increased by 1)
        if (toColumnLeftOrRowTop(rowIndex)&&
                toColumnRightOrRowBottom(board.getSize(), columnIndex) &&
                checkWinner(board, marker, rowIndex, -1, columnIndex, 1)) {
            return true;
        }

        return false;
    }

    private static boolean checkWinner(Board board, String marker, int firstIndex, int firstInterval, int
            secondIndex, int secondInterval) {
        for (int i = 1 ; i < WINNER_LEN; i++) {
            if (!marker.equals(board.getBox((firstIndex + firstInterval * i) * board.getSize() +
                    secondIndex + secondInterval * i))) {
                return false;
            }
        }

        return true;
    }

    private static boolean toColumnRightOrRowBottom(int size, int index) {
        return size - index >= WINNER_LEN;
    }

    private static boolean toColumnLeftOrRowTop(int index) {
        return index + 1 >= WINNER_LEN;
    }

    private static String padding(String text) {
        if (text.length() == 1) {
            return " " + text + " ";
        }

        if (text.length() == 2) {
            return text + " ";
        }

        return text;
    }
}
