package com.shangyu.personal.zendesk.uniqueSet;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shangyu on 15/8/17.
 */
public class GameUtilsTest {

    @Test
    public void testDetermineWinnerHorizontallySize3() {
        int size = 3;

        // from left to right
        Player player = new Player("tester", "X");
        player.getBoxes().add(8);
        player.getBoxes().add(7);
        player.getBoxes().add(6);
        Assert.assertTrue("test horizontally from left to right fail", GameUtils.determineWinner(player, size, 6));

        // from right to left
        player = new Player("tester", "X");
        player.getBoxes().add(3);
        player.getBoxes().add(4);
        player.getBoxes().add(5);
        Assert.assertTrue("test horizontally from right to left fail", GameUtils.determineWinner(player, size, 5));
    }

    @Test
    public void testDetermineWinnerVerticallySize3() {
        int size = 3;

        // from bottom to top
        Player player = new Player("tester", "X");
        player.getBoxes().add(1);
        player.getBoxes().add(4);
        player.getBoxes().add(7);
        Assert.assertTrue("test vertically from bottom to top fail", GameUtils.determineWinner(player, size, 7));

        // from top to bottom
        player = new Player("tester", "X");
        player.getBoxes().add(8);
        player.getBoxes().add(5);
        player.getBoxes().add(2);
        Assert.assertTrue("test vertically from top to bottom fail", GameUtils.determineWinner(player, size, 2));
    }

    @Test
    public void testDetermineWinnerDiagonallySize3() {
        int size = 3;

        // from last to right bottom
        Player player = new Player("tester", "X");
        player.getBoxes().add(8);
        player.getBoxes().add(4);
        player.getBoxes().add(0);
        Assert.assertTrue("test diagonally to right bottom fail", GameUtils.determineWinner(player, size, 0));

        // from last to left top
        player = new Player("tester", "X");
        player.getBoxes().add(0);
        player.getBoxes().add(4);
        player.getBoxes().add(8);
        Assert.assertTrue("test diagonally to left top fail", GameUtils.determineWinner(player, size, 8));

        // from last to left bottom
        player = new Player("tester", "X");
        player.getBoxes().add(6);
        player.getBoxes().add(4);
        player.getBoxes().add(2);
        Assert.assertTrue("test diagonally to left bottom fail", GameUtils.determineWinner(player, size, 2));

        // from last to right top
        player = new Player("tester", "X");
        player.getBoxes().add(2);
        player.getBoxes().add(4);
        player.getBoxes().add(6);
        Assert.assertTrue("test diagonally to right top fail", GameUtils.determineWinner(player, size, 6));
    }

    @Test
    public void testDetermineWinnerHorizontallySize4() {
        int size = 4;

        // from last to right
        Player player = new Player("tester", "X");
        player.getBoxes().add(3);
        player.getBoxes().add(2);
        player.getBoxes().add(1);
        Assert.assertTrue("test fail", GameUtils.determineWinner(player, size, 1));

        // from last to left
        player = new Player("tester", "X");
        player.getBoxes().add(5);
        player.getBoxes().add(6);
        player.getBoxes().add(7);
        Assert.assertTrue("test fail", GameUtils.determineWinner(player, size, 7));
    }

    @Test
    public void testDetermineWinnerVerticallySize4() {
        int size = 4;

        // from last to bottom
        Player player = new Player("tester", "X");
        player.getBoxes().add(10);
        player.getBoxes().add(6);
        player.getBoxes().add(2);
        Assert.assertTrue("test fail", GameUtils.determineWinner(player, size, 2));

        // from last to top
        player = new Player("tester", "X");
        player.getBoxes().add(5);
        player.getBoxes().add(9);
        player.getBoxes().add(13);
        Assert.assertTrue("test fail", GameUtils.determineWinner(player, size, 13));
    }

    @Test
    public void testDetermineWinnerDiagonallySize4() {
        int size = 4;

        // from last to right bottom
        Player player = new Player("tester", "X");
        player.getBoxes().add(10);
        player.getBoxes().add(5);
        player.getBoxes().add(0);
        Assert.assertTrue("test diagonally to right bottom fail", GameUtils.determineWinner(player, size, 0));

        // from last to left top
        player = new Player("tester", "X");
        player.getBoxes().add(1);
        player.getBoxes().add(6);
        player.getBoxes().add(11);
        Assert.assertTrue("test diagonally to left top fail", GameUtils.determineWinner(player, size, 11));

        // from last to left bottom
        player = new Player("tester", "X");
        player.getBoxes().add(8);
        player.getBoxes().add(5);
        player.getBoxes().add(2);
        Assert.assertTrue("test diagonally to left bottom fail", GameUtils.determineWinner(player, size, 2));

        // from last to right top
        player = new Player("tester", "X");
        player.getBoxes().add(7);
        player.getBoxes().add(10);
        player.getBoxes().add(13);
        Assert.assertTrue("test diagonally to right top fail", GameUtils.determineWinner(player, size, 13));
    }
}
