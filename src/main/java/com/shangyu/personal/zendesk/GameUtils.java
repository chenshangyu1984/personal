package com.shangyu.personal.zendesk;

import org.springframework.util.StringUtils;

import java.util.Scanner;
import java.util.Set;

/**
 * Created by shangyu on 15/8/17.
 */
public class GameUtils {

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

            if (size < Board.WINNER_LEN) {
                continue;
            }

            break;
        }

        return size;
    }

    public static String getNameOfPlayer(Scanner scanner, String
            text) {
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

    private static int inputBoxIndex(Scanner scanner, Player player, Board board, Player player1, Player player2) {
        int boxIndex = 0;

        while (true) {
            System.out.print(player.getName() + ", choose a box to place an '" + player.getMarker() + "' into: ");

            try {
                String line = scanner.nextLine();
                boxIndex = Integer.parseInt(line);
            } catch (Exception e) {
                continue;
            }

            // validate index
            if (!board.isValidIndex(boxIndex)) {
                continue;
            }

            // check index has been placed
            if (player1.getBoxes().contains(boxIndex - 1) ||
                    player2.getBoxes().contains(boxIndex - 1)) {
                continue;
            }

            break;
        }

        return boxIndex;
    }

    public static void printGame(Board board, Player player1, Player player2) {
        System.out.println();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                int index = i * board.getSize() + j;
                String text = "" + (index + 1);

                if (player1.getBoxes().contains(index)) {
                    text = player1.getMarker();
                } else if (player2.getBoxes().contains(index)) {
                    text = player2.getMarker();
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

    public static void playGame(Scanner scanner, Board board, Player player1, Player player2) {
        Player player = player1;
        while (true) {
            // get valid index
            int boxIndex = inputBoxIndex(scanner, player,
                    board, player1, player2);

            // add to player's boxes
            player.getBoxes().add(boxIndex - 1);

            // print game
            printGame(board, player1, player2);

            // determine winner if any
            boolean win = determineWinner(player, board.getSize());
            if (win) {
                System.out.println("Congratulations " + player.getName() + "! You have won.");
                return;
            }

            // tie
            if (player1.getBoxes().size() + player2.getBoxes().size() == board.getSize() * board.getSize()) {
                System.out.println("Game is tied.");
                return;
            }

            player = player.equals(player1) ? player2 : player1;
        }
    }

    // check all the elements in the set, we only check the smaller elements
    public static boolean determineWinner(Player player, int size) {
        // horizontally (from left to right only, so increased by 1)
        boolean win = player.getBoxes().stream().filter(
                // at least WINNER_LEN number of elements (including itself) to the right of the row
                box -> box % size + Board.WINNER_LEN <= size
        ).anyMatch(
                box -> checkWinner(player.getBoxes(), box, 1)
        );
        if (win) {
            return true;
        }

        // vertically (from top to bottom only, so increased by size)
        win = player.getBoxes().stream().filter(
                // at least WINNER_LEN number of elements (including itself) to the bottom of the column
                box -> box / size + Board.WINNER_LEN <= size
        ).anyMatch(
                box -> checkWinner(player.getBoxes(), box, size)
        );
        if (win) {
            return true;
        }

        // diagonally (from top to bottom only)
        // from left to right, so increased by size + 1
        win = player.getBoxes().stream().filter(
                // at least WINNER_LEN number of elements (including itself) to the right of the row
                // at least WINNER_LEN number of elements (including itself) to the bottom of the column
                box -> box % size + Board.WINNER_LEN <= size &&
                        box / size + Board.WINNER_LEN <= size
        ).anyMatch(
                box -> checkWinner(player.getBoxes(), box, size + 1)
        );
        if (win) {
            return true;
        }
        // from right to left, so increased by size - 1
        win = player.getBoxes().stream().filter(
                // at least WINNER_LEN number of elements (including itself) to the left of the row
                // at least WINNER_LEN number of elements (including itself) to the bottom of the column
                box -> box % size + 1 >= Board.WINNER_LEN &&
                        box / size + Board.WINNER_LEN <= size
        ).anyMatch(
                box -> checkWinner(player.getBoxes(), box, size - 1)
        );
        if (win) {
            return true;
        }

        return false;
    }

    private static boolean checkWinner(Set<Integer> boxes, int index, int interval) {
        for (int i = 1 ; i < Board.WINNER_LEN; i++) {
            if (!boxes.contains(index + interval * i)) {
                return false;
            }
        }

        return true;
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
