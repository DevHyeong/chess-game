package com.exam.chess.pieces;

import com.exam.chess.model.Player;

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
}
