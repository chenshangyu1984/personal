package com.shangyu.personal.zendesk;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Scanner;

/**
 * Created by shangyu on 24/8/17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(GameUtils.class)
public class GameTest {
    private Board board = null;

    public Board init2dArray(int size) {
        return new BoardWith2dArray(size);
    }

    public Board initMap(int size) {
        return new BoardWithMap(size);
    }

    @Test
     public void testPlayGame2dArraySize3() throws Exception{
        // prepare
        board = init2dArray(3);
        testPlayGameSize3(board);
    }

    @Test
    public void testPlayGameMapSize3() throws Exception{
        // prepare
        board = initMap(3);
        testPlayGameSize3(board);
    }

    private void testPlayGameSize3(Board board) {
        Scanner scanner = PowerMockito.mock(Scanner.class);
        PowerMockito.when(scanner.nextLine())
                .thenReturn("player 1")
                .thenReturn("player 2")
                .thenReturn("1")
                .thenReturn("2")
                .thenReturn("4")
                .thenReturn("5")
                .thenReturn("7")
                .thenReturn("8");

        // action
        Result result = GameUtils.playGame(scanner, board);

        // verify
        Assert.assertNotEquals("result null", result, null);
        Assert.assertNotEquals("result tied", result.getWinner(), null);
        Assert.assertEquals("result wrong", result.getWinner().getName(), "player 1");
    }
}
