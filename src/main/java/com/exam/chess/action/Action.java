package com.exam.chess.action;

import com.exam.chess.exception.ImmovableException;
import com.exam.chess.pieces.AbstractPiece;
import com.exam.chess.pieces.Piece;
import com.exam.chess.pieces.Position;

public enum Action {
    MOVABLE{
        @Override
        public void action(Piece[][] board, AbstractPiece piece, Position target) {
            piece.move(board, piece.getPosition(), target);
        }
    },
    CATCHABLE{
        @Override
        public void action(Piece[][] board, AbstractPiece piece, Position target) {
            piece.setCaughtPiece(board[target.getY()][target.getX()]);
            piece.move(board, piece.getPosition(), target);
        }
    },
    IMMOVABLE{
        @Override
        public void action(Piece[][] board, AbstractPiece piece, Position target) {
            throw new ImmovableException();
        }
    };

    public abstract void action(Piece[][] board, AbstractPiece piece, Position target);

}
