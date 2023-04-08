package com.exam.chess.pieces;

public class Pawn implements Piece {

    private Side side;
    private String expression;
    private int x;
    private int y;

    public Pawn(Side side, int x, int y){
        this.side = side;
        this.expression = side.equals(Side.WHITE) ? "♙" : "♟";
        this.x = x;
        this.y = y;
    }

    @Override
    public String expression() {
        return expression;
    }

    @Override
    public void movable() {
        //흑 또는 백인 것에 따라 방향이 달라짐. +1 이거나 -1
        int s = side.equals(Side.WHITE) ? -1 : 1;

        if(this.y + 1 < 10){

        }

        //case 1
        move(this.x - 1, this.y + 1);

        //case 2
        move(this.x + 1, this.y + 1);

        //case 3
        move(this.x , this.y + 2);

        //case 4
        move(this.x ,this.y + 1);


    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }


}
