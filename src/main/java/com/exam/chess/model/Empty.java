package com.exam.chess.model;

import com.exam.chess.Location;

public class Empty implements Location {
    private int x;
    private int y;

    public Empty(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void movable() {

    }

    @Override
    public void move(int x, int y) {

    }
}
