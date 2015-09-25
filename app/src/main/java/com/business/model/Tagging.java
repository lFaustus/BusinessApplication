package com.business.model;

/**
 * Created by User on 25/09/2015.
 */
public class Tagging {
    String id;
    int pos;

    public Tagging(String id, int pos) {
        this.id = id;
        this.pos = pos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
