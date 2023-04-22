package com.exam.chess.pieces;

public class Rook implements Piece {

    private Side side;
    private char expression;
    private Position position;

    public Rook(Position position){
        this.position = position;
    }

    public Rook(Side side, Position position){
        this.side = side;
        this.expression = side.getExpression("ROOK");
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
