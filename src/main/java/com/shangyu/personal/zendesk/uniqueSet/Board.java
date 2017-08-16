package com.shangyu.personal.zendesk.uniqueSet;

/**
 * Created by shangyu on 15/8/17.
 */
public class Board {
    public static final Integer WINNER_LEN = 3;
    public static final String MARKER_X = "X";
    public static final String MARKER_O = "O";

    private int size;

    public Board(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public boolean isValidIndex(int index) {
        return index >= 0 && index < size * size;
    }
}
