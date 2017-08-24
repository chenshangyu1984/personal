package com.shangyu.personal.zendesk;

import java.util.Scanner;

/**
 * Created by shangyu on 15/8/17.
 */
public class MainWithMap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // size of game
        int sizeOfGame = GameUtils.getSizeOfGame(scanner, "Enter size of game (at least " + GameUtils.WINNER_LEN + "): ");
        Board board = new BoardWithMap(sizeOfGame);

        GameUtils.playGame(scanner, board);
    }
}
