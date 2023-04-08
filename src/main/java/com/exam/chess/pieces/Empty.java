package com.exam.chess.pieces;

public class Empty implements Piece {
    private static final String EXPRESSION = " ";

    private int x;
    private int y;

    public Empty(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String expression() {
        return EXPRESSION;
    }

    @Override
    public void movable() {

    }

    @Override
    public void move(int x, int y) {

    }
}
