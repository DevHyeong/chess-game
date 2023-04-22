package com.exam.chess.pieces;

public class Empty implements Piece {
    private static final char EXPRESSION = 0;

    private Position position;

    public Empty(Position position){
        this.position = position;
    }

    @Override
    public char expression() {
        return EXPRESSION;
    }

    @Override
    public void movable() {

    }

    @Override
    public void move(int x, int y) {

    }
}
