package com.shangyu.personal.zendesk.array2d;

import org.springframework.util.StringUtils;

import java.util.Scanner;
import java.util.Set;

/**
 * Created by shangyu on 16/8/17.
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

    private static int inputBoxIndex(Scanner scanner, Player player, Board board) {
        int boxIndex = 0;

        while (true) {
            System.out.print(player.getName() + ", choose a box to place an '" + player.getMarker() + "' into: ");

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
                String text = board.getBox(i, j);
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

    public static void playGame(Scanner scanner, Board board, Player player1, Player player2) {
        Player player = player1;
        while (true) {
            // get valid index (already minus 1)
            int boxIndex = inputBoxIndex(scanner, player, board);

            // set board's box
            board.setBox(boxIndex, player.getMarker());

            // print game
            printGame(board);

            // determine winner if any
            boolean win = determineWinner(board, boxIndex);
            if (win) {
                System.out.println("Congratulations " + player.getName() + "! You have won.");
                return;
            }

            // tie
            if (board.isFull()) {
                System.out.println("Game is tied.");
                return;
            }

            player = player.equals(player1) ? player2 : player1;
        }
    }

    public static boolean determineWinner(Board board, int index) {
        String marker = board.getBox(index);
        int firstIndex = index / board.getSize();
        int secondIndex = index % board.getSize();

        // horizontally
        // from index to left (secondIndex - 1)
        if (secondIndex - 2 >= 0 && marker.equals(board.getBox(firstIndex, secondIndex - 1))
                && marker.equals(board.getBox(firstIndex, secondIndex - 2))) {
            return true;
        }
        // from index to right (secondIndex + 1)
        if (secondIndex + 2 < board.getSize()
                && marker.equals(board.getBox(firstIndex, secondIndex + 1))
                && marker.equals(board.getBox(firstIndex, secondIndex + 2))) {
            return true;
        }

        // vertically
        // from index to bottom (firstIndex + 1)
        if (firstIndex + 2 < board.getSize()
                && marker.equals(board.getBox(firstIndex + 1, secondIndex))
                && marker.equals(board.getBox(firstIndex + 2, secondIndex))) {
            return true;
        }
        // from index to top (firstIndex - 1)
        if (firstIndex - 2 >= 0
                && marker.equals(board.getBox(firstIndex - 1, secondIndex))
                && marker.equals(board.getBox(firstIndex - 2, secondIndex))) {
            return true;
        }

        // diagonally
        // from index to left bottom (first index + 1, second index - 1)
        if (firstIndex + 2 < board.getSize() && secondIndex - 2 >= 0
                && marker.equals(board.getBox(firstIndex + 1, secondIndex - 1))
                && marker.equals(board.getBox(firstIndex + 2, secondIndex - 2))) {
            return true;
        }
        // from index to left top (first index - 1, second index - 1)
        if (firstIndex - 2 >= 0 && secondIndex - 2 >= 0
                && marker.equals(board.getBox(firstIndex - 1, secondIndex - 1))
                && marker.equals(board.getBox(firstIndex - 2, secondIndex - 2))) {
            return true;
        }
        // from index to right bottom (first index + 1, second index + 1)
        if (firstIndex + 2 < board.getSize() && secondIndex + 2 < board.getSize()
                && marker.equals(board.getBox(firstIndex + 1, secondIndex + 1))
                && marker.equals(board.getBox(firstIndex + 2, secondIndex + 2))) {
            return true;
        }
        // from index to right top (first index - 1, second index + 1)
        if (firstIndex - 2 >= 0 && secondIndex + 2 < board.getSize()
                && marker.equals(board.getBox(firstIndex - 1, secondIndex + 1))
                && marker.equals(board.getBox(firstIndex - 2, secondIndex + 2))) {
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
