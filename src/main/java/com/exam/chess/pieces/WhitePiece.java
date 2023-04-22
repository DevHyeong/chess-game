package com.exam.chess.pieces;

public enum WhitePiece {
    BISHOP('♗'),
    KING('♕'),
    NIGHT('♘'),
    PAWN('♙'),
    QUEEN('♔'),
    ROOK('♖');

    private final char pattern;

    WhitePiece(char pattern){
        this.pattern = pattern;
    }

    public char getPattern() {
        return pattern;
    }
}
