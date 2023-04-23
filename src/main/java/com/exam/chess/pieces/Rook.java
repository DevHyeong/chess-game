package com.exam.chess.pieces;

import com.exam.chess.model.Game;

import static com.exam.chess.pieces.Position.position;

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
    public void movable(Piece[][] board) {
        int x = position.getX();
        int y = position.getY();

        while(true){
            x = position.getX() + 1;

        }

        //Game.ROW_COUNT;
        //Game.COL_COUNT;

    }

    @Override
    public void move(Piece[][] board, Position target) {
        if(position.equals(target)){
            throw new IllegalArgumentException("동일한 위치입니다.");
        }

        if(movable(board, target)){
            move(board, position, target);
            return;
        }
        throw new IllegalArgumentException("올바르지 못한 값을 입력하였습니다.");
    }

    private boolean movable(Piece[][] board, Position target){
        if(target.getY() - position.getY() == 0){
            return target.getX() > position.getX() ? movableX(board, position, target)
                    : movableX(board, target, position);

        }
        else if(target.getX() - position.getX() == 0){
            return target.getY() > position.getY() ? movableY(board, position, target)
                    : movableY(board, target, position);
        }
        return false;
    }


    private boolean movableX(Piece[][] board, Position source, Position target){
        for(int i = source.getX() + 1; i <= target.getX(); i++){
            Piece piece = board[target.getY()][i];
            // 상대편 말을 잡았을 경우
            if(i == target.getX() && piece.expression() != Character.MIN_VALUE) {
                catchPiece(piece);
            }
            else if(piece.expression() != Character.MIN_VALUE){
                return false;
            }
        }
        return true;
    }
    private boolean movableY(Piece[][] board, Position source, Position target){
        for(int i = source.getY() + 1; i <= target.getY(); i++){
            Piece piece = board[i][target.getX()];
            // 상대편 말을 잡았을 경우
            if(i == target.getY() && piece.expression() != Character.MIN_VALUE) {
                catchPiece(piece);
            }
            else if(piece.expression() != Character.MIN_VALUE){
                return false;
            }
        }
        return true;
    }
    private void catchPiece(Piece piece){
        if(!piece.getSide().equals(side)){
            caughtPiece = piece;
        }
    }

}
