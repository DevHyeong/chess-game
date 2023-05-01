package com.exam.chess.pieces;

import static com.exam.chess.model.Game.ROW_COUNT;
import static java.lang.Integer.parseInt;

public class Position {
    private int x;
    private int y;

    private Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static Position position(int x, int y){
        if(x < 0 || y > ROW_COUNT - 1)
            throw new ArrayIndexOutOfBoundsException("범위를 벗어났습니다.");
        return new Position(x, y);
    }

    public static Position position(String x, String y){
        if(x == null || y == null)
            throw new ArrayIndexOutOfBoundsException();
        return position(parseInt(x), parseInt(y));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Position){
            Position position = (Position) obj;
            return this.x == position.getX() && this.y == position.getY();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
