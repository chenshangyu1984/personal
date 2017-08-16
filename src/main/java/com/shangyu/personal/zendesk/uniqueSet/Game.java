package com.shangyu.personal.zendesk.uniqueSet;

import java.util.Scanner;

/**
 * Created by shangyu on 15/8/17.
 */
public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // size of game
        int sizeOfGame = GameUtils.getSizeOfGame(scanner, "Enter size of game (at least " + Board.WINNER_LEN + "): ");
        Board board = new Board(sizeOfGame);

        // name of player 1
        String player1Name = GameUtils.getNameOfPlayer(scanner, "Enter name for Player 1: ");
        Player player1 = new Player(player1Name, Board.MARKER_X);

        // name of player 2
        String player2Name = GameUtils.getNameOfPlayer(scanner, "Enter name for Player 2: ");
        Player player2 = new Player(player2Name, Board.MARKER_O);

        // print initial game
        GameUtils.printGame(board, player1, player2);

        // play game
        GameUtils.playGame(scanner, board, player1, player2);
    }
}
