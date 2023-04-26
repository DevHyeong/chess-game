package com.exam.chess.pieces;

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
    public void move(Piece[][] board, Position target) {
        if(position.equals(target))
            throw new IllegalArgumentException("동일한 위치입니다.");

        int diffX = target.getX() - position.getX();
        int diffY = target.getY() - position.getY();

        if(movable(diffX, diffY)){
            Piece piece = board[target.getY()][target.getX()];
            if(piece instanceof Empty){
                move(board, position, target);
            }else if(!piece.getSide().equals(side)){
                caughtPiece = piece;
                move(board, position, target);
            }else{
                throw new IllegalStateException("해당 위치에 " + piece.toString());
            }
        }

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
