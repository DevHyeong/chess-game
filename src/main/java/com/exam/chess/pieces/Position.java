package com.exam.chess.pieces;

public class Position {
    private int x;
    private int y;

    private Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static Position position(int x, int y){
        return new Position(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
