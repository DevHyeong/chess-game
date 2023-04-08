package com.exam.chess.pieces;

public class Night implements Piece {

    private Side side;
    private String expression;
    private int x;
    private int y;

    public Night(Side side, int x, int y){
        this.side = side;
        this.expression = side.equals(Side.WHITE) ? "♘" : "♞";
        this.x = x;
        this.y = y;
    }

    @Override
    public String expression() {
        return expression;
    }

    @Override
    public void movable() {

    }

    @Override
    public void move(int x, int y) {

    }
}
