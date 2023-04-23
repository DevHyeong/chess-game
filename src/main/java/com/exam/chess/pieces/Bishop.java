package com.exam.chess.pieces;

public class Bishop extends AbstractPiece {

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
    public void movable(Piece[][] board) {

    }
    @Override
    public void move(Piece[][] board, Position position) {
        Position current = getPosition();


    }

    @Override
    public Position getPosition() {
        return position;
    }
}
