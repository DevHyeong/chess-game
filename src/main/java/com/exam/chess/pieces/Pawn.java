package com.exam.chess.pieces;

import com.exam.chess.action.Action;

public class Pawn extends AbstractPiece{

    private boolean isFirst;
    public Pawn(Position position){
        this.position = position;
    }

    public Pawn(Side side, Position position){
        this.side = side;
        this.expression = side.getExpression("PAWN");
        this.position = position;
        this.isFirst = true;
    }

    @Override
    public char expression() {
        return expression;
    }

    @Override
    public Action movable(Piece[][] board, Position target){
        //첫 시작은 한칸 또는 두칸 가능, 그 이후로는 한칸이동
        //피스 잡는 행동은 대각선만 가능
        int diffX = Math.abs(position.getX() - target.getX());
        int diffY = side.equals(Side.BLACK) ?
                target.getY() - position.getY() : position.getY() - target.getY();
        Piece piece = board[target.getY()][target.getX()];

        if(diffX == 1 && diffY == 1){
            if(isCatchable(piece, side)){
                return Action.CATCHABLE;
            }
        }

        if(diffX > 0){
            return Action.IMMOVABLE;
        }

        if(isFirst){
            if((diffY == 1 || diffY == 2) && piece instanceof Empty){
                isFirst = false;
                return Action.MOVABLE;
            }
        }else{
            if(diffY == 1 && piece instanceof Empty){
                return Action.MOVABLE;
            }
        }

        return Action.IMMOVABLE;
    }


    @Override
    public Position getPosition() {
        return position;
    }


}
