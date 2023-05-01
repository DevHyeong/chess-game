package com.exam.chess.pieces;

import com.exam.chess.action.Action;
public class Rook extends AbstractPiece {
    public Rook(Position position){
        this.position = position;
    }

    public Rook(Side side, Position position){
        this.side = side;
        this.expression = side.getExpression("ROOK");
        this.position = position;
    }

    @Override
    public char expression() {
        return expression;
    }

    @Override
    public Action movable(Piece[][] board, Position target){
        return movable(board, this, target);
    }

    public static Action movable(Piece[][] board, Piece source, Position target){
        Position position = source.getPosition();
        int diffX = target.getX() - position.getX();
        int diffY = target.getY() - position.getY();

        if(diffY == 0){
            return movableX(board, source, target);
        }
        else if(diffX == 0){
            return movableY(board, source, target);
        }
        return Action.IMMOVABLE;

    }

    private static Action movableX(Piece[][] board, Piece source, Position target){
        int diff = source.getPosition().getX() - target.getX();
        int x = source.getPosition().getX();
        while( x != target.getX()){
            if(diff > 0){
                x--;
            }else{
                x++;
            }

            Piece piece = board[source.getPosition().getY()][x];
            if(x == target.getX() && isCatchable(piece, source.getSide())) {
                return Action.CATCHABLE;
            }
            if(!(piece instanceof Empty)){
                return Action.IMMOVABLE;
            }
        }

        return Action.MOVABLE;
    }
    private static Action movableY(Piece[][] board, Piece source, Position target){
        int diff = source.getPosition().getY() - target.getY();
        int y = source.getPosition().getY();
        while( y != target.getY()){
            if(diff > 0){
                y--;
            }else{
                y++;
            }

            Piece piece = board[y][source.getPosition().getX()];
            if(y == target.getY() && isCatchable(piece, source.getSide())) {
                return Action.CATCHABLE;
            }

            if(!(piece instanceof Empty)){
                return Action.IMMOVABLE;
            }
        }
        return Action.MOVABLE;
    }
}
