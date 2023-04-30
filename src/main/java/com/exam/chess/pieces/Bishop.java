package com.exam.chess.pieces;

import com.exam.chess.action.Action;

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
    public Position getPosition() {
        return position;
    }
    @Override
    public Action movable(Piece[][] board, Position target){
        return movable(board, this, target);
    }

    public static Action movable(Piece[][] board, Piece source, Position target){
        int diffX = Math.abs(target.getX() - source.getPosition().getX());
        int diffY = Math.abs(target.getY() - source.getPosition().getY());

        if(diffX == diffY){
            int i = 0;
            int x = source.getPosition().getX();
            int y = source.getPosition().getY();
            int a = diffX < 0 ? -1 : 1;

            while(i < diffX){
                x += a;
                y += a;

                if(diffX - 1 == i){
                    Piece piece = board[y][x];
                    if(piece instanceof Empty){
                        return Action.MOVABLE;
                    }
                    if(isCatchable(piece, source.getSide())){
                        return Action.CATCHABLE;
                    }
                }else if( !(board[y][x] instanceof Empty)){
                    return Action.IMMOVABLE;
                }
                i++;
            }
        }
        return Action.IMMOVABLE;
    }


}
