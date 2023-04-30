package com.exam.chess.pieces;

import com.exam.chess.action.Action;

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
    public Action movable(Piece[][] board, Position target){
        int diffX = Math.abs(target.getX() - position.getX());
        int diffY = Math.abs(target.getY() - position.getY());
        if(diffX == diffY){
            return Bishop.movable(board, this, target);
        }

        if((diffX == 0 && diffY > 0) || (diffY == 0 && diffX > 0)){
            return Rook.movable(board, this, target);
        }

        return Action.IMMOVABLE;
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
