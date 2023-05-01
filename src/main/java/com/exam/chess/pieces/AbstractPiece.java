package com.exam.chess.pieces;

import com.exam.chess.action.Action;
import com.exam.chess.model.Player;

import static com.exam.chess.pieces.Position.position;

public abstract class AbstractPiece implements Piece{
    Side side;
    char expression;
    Position position;
    Piece caughtPiece;
    @Override
    public Side getSide() {
        return side;
    }
    @Override
    public Position getPosition() {
        return position;
    }
    @Override
    public Piece getCaughtPiece() {
        return caughtPiece;
    }

    public void setCaughtPiece(Piece caughtPiece) {
        this.caughtPiece = caughtPiece;
        System.out.println(caughtPiece + "를 잡았습니다.");
    }


    public void move(Piece[][] board, Position source, Position target){
        board[position.getY()][position.getX()] = new Empty(position);
        position = position(target.getX(), target.getY());
        board[target.getY()][target.getX()] = this;
    }

    @Override
    public void move(Piece[][] board, Position target) {
        Action action = movable(board, target);
        action.action(board, this, target);
    }

    public static boolean isCatchable(Piece piece, Side side){
        return !(piece instanceof Empty) && !piece.getSide().equals(side);
    }

    @Override
    public void initCaughtPiece(){
        caughtPiece = null;
    }

    @Override
    public boolean isCaught(){
        return caughtPiece instanceof Piece;
    }

    @Override
    public String toString() {
        return String.format("piece: %s position: x: %s, y: %s", expression, position.getX(), position.getY());
    }
}
