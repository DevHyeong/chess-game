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
    /**
     *  x = -1, y = 1
     *  x = -1, y = -1
     *  x = 1, y = -1
     *  x = 1, y = 1
     *
     * */
    public static Action movable(Piece[][] board, Piece source, Position target){
        int diffX = target.getX() - source.getPosition().getX();
        int diffY = target.getY() - source.getPosition().getY();

        if(Math.abs(diffX) == Math.abs(diffY)){
            int i = 0;
            int x = source.getPosition().getX();
            int y = source.getPosition().getY();
            int dx = diffX < 0 ? -1 : 1;
            int dy = diffY < 0 ? -1 : 1;

            while(i < Math.abs(diffX)){
                x += dx;
                y += dy;

                if(Math.abs(diffX) - 1 == i){
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
