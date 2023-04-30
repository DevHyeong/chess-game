package com.exam.chess.pieces;

import com.exam.chess.action.Action;
import com.exam.chess.exception.ImmovableException;

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
    public Action movable(Piece[][] board, Position target){
        int diffX = Math.abs(target.getX() - position.getX());
        int diffY = Math.abs(target.getY() - position.getY());
        if(movable(diffX, diffY)){
            Piece piece = board[target.getY()][target.getX()];
            if(piece instanceof Empty){
                return Action.MOVABLE;
            }
            if(isCatchable(piece, side)){
                return Action.CATCHABLE;
            }
        }
        return Action.IMMOVABLE;
    }
    public boolean movable(int x, int y){
        if(x == 1 && y == 1){
            return true;
        }
        if(x == 1 && y == 0){
            return true;
        }
        if(x == 0 && y == 1){
            return true;
        }
        return false;
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
