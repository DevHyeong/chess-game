package com.exam.chess.pieces;

public enum Side {
    WHITE{
        @Override
        public char getExpression(String name) {
            return WhitePiece.valueOf(name).getPattern();
        }
    },
    BLACK{
        @Override
        public char getExpression(String name) {
            return BlackPiece.valueOf(name).getPattern();
        }
    };

    public abstract char getExpression(String name);
}
