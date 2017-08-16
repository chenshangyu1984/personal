package com.shangyu.personal.zendesk.uniqueSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shangyu on 15/8/17.
 */
public class Player {

    private String name;
    private String marker;
    private Set<Integer> boxes;

    public Player(String name, String marker) {
        this.name = name;
        this.marker = marker;
        this.boxes = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public String getMarker() {
        return marker;
    }

    public Set<Integer> getBoxes() {
        return boxes;
    }
}
