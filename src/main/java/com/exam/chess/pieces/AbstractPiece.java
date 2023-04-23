package com.exam.chess.pieces;

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
    }

    public void move(Piece[][] board, Position source, Position target){
        board[position.getY()][position.getX()] = new Empty(position);
        position = position(target.getX(), target.getY());
        board[target.getY()][target.getX()] = this;
    }

}
