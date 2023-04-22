package com.exam.chess.pieces;

public class Night implements Piece {

    private Side side;
    private char expression;
    private Position position;

    public Night(Position position){
        this.position = position;
    }

    public Night(Side side, Position position){
        this.side = side;
        this.expression = side.getExpression("NIGHT");
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
