package com.exam.chess.pieces;

public class King implements Piece {

    private Side side;
    private char expression;
    private Position position;

    public King(Position position){
        this.position = position;
    }


    public King(Side side, Position position){
        this.side = side;
        this.expression = side.getExpression("KING");
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
