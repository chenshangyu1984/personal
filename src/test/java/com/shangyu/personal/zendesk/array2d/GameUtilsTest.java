package com.shangyu.personal.zendesk.array2d;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shangyu on 15/8/17.
 */
public class GameUtilsTest {
    private static final String marker = "X";

    @Test
    public void testDetermineWinnerHorizontallySize3() {
        // from last to Left
        Board board = new Board(3);
        board.setBox(3, marker);
        board.setBox(4, marker);
        board.setBox(5, marker);
        Assert.assertTrue("test horizontally from last to left fail", GameUtils.determineWinner(board, 5));

        // from last to Right
        board = new Board(3);
        board.setBox(2, marker);
        board.setBox(1, marker);
        board.setBox(0, marker);
        Assert.assertTrue("test horizontally from last to right fail", GameUtils.determineWinner(board, 0));
    }

    @Test
    public void testDetermineWinnerVerticallySize3() {
        // from last to Top
        Board board = new Board(3);
        board.setBox(1, marker);
        board.setBox(4, marker);
        board.setBox(7, marker);
        Assert.assertTrue("test vertically from last to top fail", GameUtils.determineWinner(board, 7));

        // from last to Bottom
        board = new Board(3);
        board.setBox(8, marker);
        board.setBox(5, marker);
        board.setBox(2, marker);
        Assert.assertTrue("test vertically from last to bottom fail", GameUtils.determineWinner(board, 2));
    }

    @Test
    public void testDetermineWinnerDiagonallySize3() {
        // from last to Left Top
        Board board = new Board(3);
        board.setBox(0, marker);
        board.setBox(4, marker);
        board.setBox(8, marker);
        Assert.assertTrue("test diagonally from last to left top fail", GameUtils.determineWinner(board, 8));

        // from last to Left Bottom
        board = new Board(3);
        board.setBox(6, marker);
        board.setBox(4, marker);
        board.setBox(2, marker);
        Assert.assertTrue("test diagonally from last to left bottom fail", GameUtils.determineWinner(board, 2));

        // from last to Right Top
        board = new Board(3);
        board.setBox(2, marker);
        board.setBox(4, marker);
        board.setBox(6, marker);
        Assert.assertTrue("test diagonally from last to right top fail", GameUtils.determineWinner(board, 6));

        // from last to Right Bottom
        board = new Board(3);
        board.setBox(8, marker);
        board.setBox(4, marker);
        board.setBox(0, marker);
        Assert.assertTrue("test diagonally from last to right bottom fail", GameUtils.determineWinner(board, 0));
    }

    @Test
    public void testDetermineWinnerHorizontallySize4() {
        // from last to Left
        Board board = new Board(4);
        board.setBox(5, marker);
        board.setBox(6, marker);
        board.setBox(7, marker);
        Assert.assertTrue("test horizontally from last to left fail", GameUtils.determineWinner(board, 7));

        // from last to Right
        board = new Board(4);
        board.setBox(14, marker);
        board.setBox(13, marker);
        board.setBox(12, marker);
        Assert.assertTrue("test horizontally from last to right fail", GameUtils.determineWinner(board, 12));
    }

    @Test
    public void testDetermineWinnerVerticallySize4() {
        // from last to Top
        Board board = new Board(4);
        board.setBox(5, marker);
        board.setBox(9, marker);
        board.setBox(13, marker);
        Assert.assertTrue("test vertically from last to top fail", GameUtils.determineWinner(board, 13));

        // from last to Bottom
        board = new Board(4);
        board.setBox(14, marker);
        board.setBox(10, marker);
        board.setBox(6, marker);

        Assert.assertTrue("test vertically from last to bottom fail", GameUtils.determineWinner(board, 6));
    }

    @Test
    public void testDetermineWinnerDiagonallyLeftBottomSize4() {
        // from last to Left Top
        Board board = new Board(4);
        board.setBox(5, marker);
        board.setBox(10, marker);
        board.setBox(15, marker);
        Assert.assertTrue("test diagonally from last to left top fail", GameUtils.determineWinner(board, 15));

        // from last to Left Bottom
        board = new Board(4);
        board.setBox(8, marker);
        board.setBox(5, marker);
        board.setBox(2, marker);
        Assert.assertTrue("test diagonally from last to left bottom fail", GameUtils.determineWinner(board, 2));

        // from last to Right Top
        board = new Board(4);
        board.setBox(6, marker);
        board.setBox(9, marker);
        board.setBox(12, marker);
        Assert.assertTrue("test diagonally from last to right top fail", GameUtils.determineWinner(board, 12));

        // from last to Right Bottom
        board = new Board(4);
        board.setBox(14, marker);
        board.setBox(9, marker);
        board.setBox(4, marker);
        Assert.assertTrue("test diagonally from last to right bottom fail", GameUtils.determineWinner(board, 4));
    }
}
