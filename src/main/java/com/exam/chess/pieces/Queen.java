package com.exam.chess.pieces;

public class Queen implements Piece {

    private Side side;
    private char expression;
    private Position position;

    public Queen(Position position){
        this.position = position;
    }

    public Queen(Side side, Position position){
        this.side = side;
        this.expression = side.getExpression("QUEEN");
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
