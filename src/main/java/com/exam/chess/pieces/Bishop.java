package com.exam.chess.pieces;

public class Bishop implements Piece {

    private Side side;
    private char expression;
    private Position position;

    public Bishop(Position position){
        this.position = position;
    }

    public Bishop(Side side, Position position){
        this.side = side;
        this.expression = side.getExpression("BISHOP");
        this.position = position;
    }

    @Override
    public char expression() {
        return expression;
    }

    @Override
    public void movable() {

    }

    @Override
    public void move(int x, int y) {

    }
}
