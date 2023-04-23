package com.exam.chess.pieces;

public interface Piece {
    char expression();
    void movable(Piece[][] board);
    void move(Piece[][] board, Position target);
    Position getPosition();
    Side getSide();
    Piece getCaughtPiece();

}
