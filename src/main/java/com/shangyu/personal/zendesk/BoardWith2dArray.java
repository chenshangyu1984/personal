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
        return getBox(index / getSize(), index % getSize());
    }

    @Override
    public String getBox(int rowIndex, int columnIndex) {
        return boxes[rowIndex][columnIndex];
    }

    @Override
    public boolean isValidIndex(int index) {
        if (!super.isValidIndex(index)) {
            return false;
        }

        // not in use before
        return getBox(index) == null;
    }
}
