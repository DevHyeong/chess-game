package com.exam.chess.pieces;

public interface Piece {
    char expression();
    void move(Piece[][] board, Position target);
    Position getPosition();
    Side getSide();
    Piece getCaughtPiece();
}
