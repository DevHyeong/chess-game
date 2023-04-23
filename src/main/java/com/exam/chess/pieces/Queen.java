package com.exam.chess.pieces;

public class Queen extends AbstractPiece{

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
    public void movable(Piece[][] board) {

    }

    @Override
    public void move(Piece[][] board, Position position) {

    }

    @Override
    public Position getPosition() {
        return position;
    }
}
