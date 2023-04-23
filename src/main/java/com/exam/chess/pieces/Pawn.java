package com.exam.chess.pieces;

public class Pawn extends AbstractPiece{

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
    public void movable(Piece[][] board) {
        if(position.getY() - 2 < 0 || position.getY() + 2 > 7){

        }




    }

    @Override
    public void move(Piece[][] board, Position position) {

    }

    @Override
    public Position getPosition() {
        return position;
    }


}
