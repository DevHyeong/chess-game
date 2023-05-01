package com.exam.chess.pieces;

import com.exam.chess.action.Action;

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
    public void move(Piece[][] board, Position position) {

    }

    @Override
    public Action movable(Piece[][] board, Position target) {
        return null;
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

    @Override
    public void initCaughtPiece() {

    }
    @Override
    public boolean isCaught() {
        return false;
    }

}
