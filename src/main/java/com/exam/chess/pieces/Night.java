package com.exam.chess.pieces;

public class Night extends AbstractPiece {

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
