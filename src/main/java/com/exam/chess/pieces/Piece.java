package com.exam.chess.pieces;

public interface Piece {
    char expression();
    void movable();
    void move(int x, int y);

}
