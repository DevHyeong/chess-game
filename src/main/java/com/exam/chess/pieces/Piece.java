package com.exam.chess.pieces;

import com.exam.chess.action.Action;

public interface Piece {
    char expression();
    void move(Piece[][] board, Position target);
    Action movable(Piece[][] board, Position target);
    Position getPosition();
    Side getSide();
    Piece getCaughtPiece();
    void initCaughtPiece();
    boolean isCaught();

}
