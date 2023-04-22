package com.exam.chess.pieces;

public class Pawn implements Piece {

    private Side side;
    private char expression;
    private Position position;

    public Pawn(Position position){
        this.position = position;
    }

    public Pawn(Side side, Position position){
        this.side = side;
        this.expression = side.getExpression("PAWN");
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
