package com.shangyu.personal.zendesk;

/**
 * Created by shangyu on 15/8/17.
 */
public class Board {
    public static final Integer WINNER_LEN = 3;
    public static final String MARKER_X = "X";
    public static final String MARKER_O = "O";

    private int size;
    private String[] boxes;

    public Board(int size) {
        this.size = size;
        boxes = new String[size * size];
    }

    public int getSize() {
        return size;
    }

    public String[] getBoxes() {
        return boxes;
    }

    public boolean isValidIndex(int index) {
        return index >= 1 && index <= size * size;
    }
}
