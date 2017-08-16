package com.shangyu.personal.zendesk.array2d;

/**
 * Created by shangyu on 16/8/17.
 */
public class Board {
    public static final Integer WINNER_LEN = 3;
    public static final String MARKER_X = "X";
    public static final String MARKER_O = "O";

    private int size;
    private String[][] boxes;
    private int filled;

    public Board(int size) {
        this.size = size;
        this.boxes = new String[size][size];
    }

    public int getSize() {
        return size;
    }

    /** index starts from 0 **/
    public boolean isValidIndex(int index) {
        return index >= 0 && index < size * size;
    }

    public void setBox(int index, String marker) {
        boxes[index / size][index % size] = marker;
        filled++;
    }

    public String getBox(int index) {
        return boxes[index / size][index % size];
    }

    public String getBox(int fristIndex, int secondIndex) {
        return boxes[fristIndex][secondIndex];
    }

    public boolean isFull() {
        return filled == size * size;
    }
}
