package com.exam.chess.pieces;

public interface Piece {
    String expression();
    void movable();
    void move(int x, int y);

}
