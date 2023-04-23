package com.exam.chess.pieces;

public interface Piece {
    char expression();
    void movable(Piece[][] board);
    void move(Piece[][] board, Position position);
    Position getPosition();
    Side getSide();
    Piece getCaughtPiece();

}
