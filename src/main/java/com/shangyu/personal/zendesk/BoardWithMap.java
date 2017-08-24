package com.shangyu.personal.zendesk;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shangyu on 16/8/17.
 */
public class BoardWithMap extends Board {
    private Map<Integer, String> boxes;

    public BoardWithMap(int size) {
        super(size);
        this.boxes = new HashMap<>(size * size);
    }

    @Override
    public void setBox(int index, String marker) {
        boxes.put(index, marker);
        increaseFilled();
    }

    @Override
    public String getBox(int index) {
        return boxes.get(index);
    }

    @Override
    public boolean isValidIndex(int index) {
        if (!isIndexInRange(index)) {
            return false;
        }

        // not in use before
        return !boxes.containsKey(index);
    }
}
