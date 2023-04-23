package com.exam.chess.pieces;

public class Empty implements Piece {
    private static final char EXPRESSION = Character.MIN_VALUE;

    private Position position;

    public Empty(Position position){
        this.position = position;
    }

    @Override
    public char expression() {
        return EXPRESSION;
    }

    @Override
    public void movable(Piece[][] board) {

    }
    @Override
    public void move(Piece[][] board, Position position) {

    }
    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Side getSide() {
        return null;
    }

    @Override
    public Piece getCaughtPiece() {
        return null;
    }
}
