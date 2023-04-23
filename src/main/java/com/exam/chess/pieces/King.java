package com.exam.chess.pieces;

public class King extends AbstractPiece{

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
