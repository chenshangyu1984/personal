package com.shangyu.personal.zendesk;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shangyu on 15/8/17.
 */
public class GameUtilsTest {
    private Board board = null;

    public Board init(int size) {
        return new BoardWith2dArray(size);
    }

    public void setBox(Board board, int... index) {
        for (int i : index) {
            board.setBox(i, "X");
        }
    }

    @Test
    public void testDetermineWinnerHorizontallySize3() {
        // from last to Left
        board = init(3);
        setBox(board, 3, 4, 5);
        Assert.assertTrue("test horizontally from last to left fail", GameUtils.determineWinner(board, 5));

        // from last to Right
        board = init(3);
        setBox(board, 2, 1, 0);
        Assert.assertTrue("test horizontally from last to right fail", GameUtils.determineWinner(board, 0));
    }

    @Test
    public void testDetermineWinnerVerticallySize3() {
        // from last to Top
        board = init(3);
        setBox(board, 1, 4, 7);
        Assert.assertTrue("test vertically from last to top fail", GameUtils.determineWinner(board, 7));

        // from last to Bottom
        board = init(3);
        setBox(board, 8, 5, 2);
        Assert.assertTrue("test vertically from last to bottom fail", GameUtils.determineWinner(board, 2));
    }

    @Test
    public void testDetermineWinnerDiagonallySize3() {
        // from last to Left Top
        board = init(3);
        setBox(board, 0, 4, 8);
        Assert.assertTrue("test diagonally from last to left top fail", GameUtils.determineWinner(board, 8));

        // from last to Left Bottom
        board = init(3);
        setBox(board, 6, 2, 2);
        Assert.assertTrue("test diagonally from last to left bottom fail", GameUtils.determineWinner(board, 2));

        // from last to Right Top
        board = init(3);
        setBox(board, 2, 4, 6);
        Assert.assertTrue("test diagonally from last to right top fail", GameUtils.determineWinner(board, 6));

        // from last to Right Bottom
        board = init(3);
        setBox(board, 8, 4, 0);
        Assert.assertTrue("test diagonally from last to right bottom fail", GameUtils.determineWinner(board, 0));
    }

    @Test
    public void testDetermineWinnerHorizontallySize4() {
        // from last to Left
        board = init(4);
        setBox(board, 5, 6, 7);
        Assert.assertTrue("test horizontally from last to left fail", GameUtils.determineWinner(board, 7));

        // from last to Right
        board = init(4);
        setBox(board, 14, 13, 12);
        Assert.assertTrue("test horizontally from last to right fail", GameUtils.determineWinner(board, 12));
    }

    @Test
    public void testDetermineWinnerVerticallySize4() {
        // from last to Top
        board = init(4);
        setBox(board, 5, 9, 13);
        Assert.assertTrue("test vertically from last to top fail", GameUtils.determineWinner(board, 13));

        // from last to Bottom
        board = init(4);
        setBox(board, 14, 10, 6);
        Assert.assertTrue("test vertically from last to bottom fail", GameUtils.determineWinner(board, 6));
    }

    @Test
    public void testDetermineWinnerDiagonallyLeftBottomSize4() {
        // from last to Left Top
        board = init(4);
        setBox(board, 5, 10, 15);
        Assert.assertTrue("test diagonally from last to left top fail", GameUtils.determineWinner(board, 15));

        // from last to Left Bottom
        board = init(4);
        setBox(board, 8, 5, 2);
        Assert.assertTrue("test diagonally from last to left bottom fail", GameUtils.determineWinner(board, 2));

        // from last to Right Top
        board = init(4);
        setBox(board, 6, 9, 12);
        Assert.assertTrue("test diagonally from last to right top fail", GameUtils.determineWinner(board, 12));

        // from last to Right Bottom
        board = init(4);
        setBox(board, 14, 9, 4);
        Assert.assertTrue("test diagonally from last to right bottom fail", GameUtils.determineWinner(board, 4));
    }
}
