package com.exam.chess.model;

import com.exam.chess.pieces.Piece;
import com.exam.chess.pieces.Side;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Side side;
    private List<Piece> pieces = new ArrayList<>();

    private Player(Side side){
        if(side == null)
            throw new IllegalArgumentException();

        this.side = side;
    }

    public static Player createPlayer(Side side){
        return new Player(side);
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }
}
