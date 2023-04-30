package com.exam.chess.pieces;

import com.exam.chess.action.Action;

import static com.exam.chess.pieces.Position.position;

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
    public Action movable(Piece[][] board, Position target){
        int diffX = target.getX() - position.getX();
        int diffY = target.getY() - position.getY();
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

    private boolean movable(int diffX, int diffY){

        if(diffX == -2 && diffY == -1){
            return true;
        }
        if(diffX == -2 && diffY == 1){
            return true;
        }
        if(diffX == -1 && diffY == 2){
            return true;
        }
        if(diffX == 1 && diffY == 2){
            return true;
        }
        if(diffX == 2 && diffY == 1){
            return true;
        }
        if(diffX == 2 && diffY == -1){
            return true;
        }
        if(diffX == -1 && diffY == -2){
            return true;
        }
        if(diffX == 1 && diffY == -2){
            return true;
        }
        return false;
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
