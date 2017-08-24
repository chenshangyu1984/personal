package com.shangyu.personal.zendesk;

/**
 * Created by shangyu on 16/8/17.
 */
public abstract class Board {
    private int size;
    private int filled;

    public Board(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int getFilled() {
        return filled;
    }

    protected void increaseFilled() {
        filled++;
    }

    public abstract void setBox(int index, String marker);

    public abstract String getBox(int index);

    public abstract boolean isValidIndex(int index);

    /** index starts from 0 **/
    protected boolean isIndexInRange(int index) {
        return index >= 0 && index < size * size;
    }
}
