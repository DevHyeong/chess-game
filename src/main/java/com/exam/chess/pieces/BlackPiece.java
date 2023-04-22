package com.exam.chess.pieces;

public enum BlackPiece {
    BISHOP('♝'),
    KING('♛'),
    NIGHT('♞'),
    PAWN('♟'),
    QUEEN('♚'),
    ROOK('♜');

    private final char pattern;

    BlackPiece(char pattern){
        this.pattern = pattern;
    }

    public char getPattern() {
        return pattern;
    }
}
