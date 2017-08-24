package com.shangyu.personal.zendesk;

/**
 * Created by shangyu on 16/8/17.
 */
public class BoardWith2dArray extends Board {
    private String[][] boxes;

    public BoardWith2dArray(int size) {
        super(size);
        this.boxes = new String[size][size];
    }

    @Override
    public void setBox(int index, String marker) {
        boxes[index / getSize()][index % getSize()] = marker;
        increaseFilled();
    }

    @Override
    public String getBox(int index) {
        return boxes[index / getSize()][index % getSize()];
    }

    @Override
    public boolean isValidIndex(int index) {
        if (!isIndexInRange(index)) {
            return false;
        }

        // not in use before
        return getBox(index) == null;
    }
}
