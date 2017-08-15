package com.shangyu.personal;

import com.shangyu.personal.zendesk.GameUtils;
import com.shangyu.personal.zendesk.Player;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shangyu on 15/8/17.
 */
public class GameUtilsTest {

    @Test
    public void testDetermineWinnerHorizontallySize3() {
        Player player = new Player("tester", "X");
        player.getBoxes().add(3);
        player.getBoxes().add(4);
        player.getBoxes().add(5);

        Assert.assertTrue("test fail", GameUtils.determineWinner(player, 3));
    }

    @Test
    public void testDetermineWinnerVerticallySize3() {
        Player player = new Player("tester", "X");
        player.getBoxes().add(1);
        player.getBoxes().add(4);
        player.getBoxes().add(7);

        Assert.assertTrue("test fail", GameUtils.determineWinner(player, 3));
    }

    @Test
    public void testDetermineWinnerDiagonallySizePlus1Size3() {
        Player player = new Player("tester", "X");
        player.getBoxes().add(0);
        player.getBoxes().add(4);
        player.getBoxes().add(8);

        Assert.assertTrue("test fail", GameUtils.determineWinner(player, 3));
    }

    @Test
    public void testDetermineWinnerDiagonallySizeMinus1Size3() {
        Player player = new Player("tester", "X");
        player.getBoxes().add(2);
        player.getBoxes().add(4);
        player.getBoxes().add(6);

        Assert.assertTrue("test fail", GameUtils.determineWinner(player, 3));
    }

    @Test
    public void testDetermineWinnerHorizontallySize4() {
        Player player = new Player("tester", "X");
        player.getBoxes().add(5);
        player.getBoxes().add(6);
        player.getBoxes().add(7);

        Assert.assertTrue("test fail", GameUtils.determineWinner(player, 4));
    }

    @Test
    public void testDetermineWinnerVerticallySize4() {
        Player player = new Player("tester", "X");
        player.getBoxes().add(5);
        player.getBoxes().add(9);
        player.getBoxes().add(13);

        Assert.assertTrue("test fail", GameUtils.determineWinner(player, 4));
    }

    @Test
    public void testDetermineWinnerDiagonallySizePlus1Size4() {
        Player player = new Player("tester", "X");
        player.getBoxes().add(5);
        player.getBoxes().add(10);
        player.getBoxes().add(15);

        Assert.assertTrue("test fail", GameUtils.determineWinner(player, 4));
    }

    @Test
    public void testDetermineWinnerDiagonallySizeMinus1Size4() {
        Player player = new Player("tester", "X");
        player.getBoxes().add(6);
        player.getBoxes().add(9);
        player.getBoxes().add(12);

        Assert.assertTrue("test fail", GameUtils.determineWinner(player, 4));
    }
}
