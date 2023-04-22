package com.exam.chess.model;

import com.exam.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.exam.chess.pieces.Position.position;

public class Player {

    private Side side;
    private List<Piece> pieces = new ArrayList<>();

    private Player(Side side){
        if(side == null)
            throw new IllegalArgumentException();

        this.side = side;
        addPiece(new Rook(side, position(0, 0)));
        addPiece(new Night(side, position(1, 0)));
        addPiece(new Bishop(side, position(2, 0)));
        addPiece(new Queen(side, position(3, 0)));
        addPiece(new King(side, position(4, 0)));
        addPiece(new Bishop(side, position(5, 0)));
        addPiece(new Night(side, position(6, 0)));
        addPiece(new Rook(side, position(7, 0)));

        IntStream.range(0, 7)
                .forEach(i-> addPiece(new Pawn(side, position(i, 1))));

    }

    public static Player createPlayer(Side side){
        return new Player(side);
    }

    public void addPiece(Piece piece) {
        this.pieces.add(piece);
    }

    public List<Piece> getPieces(){
        return this.pieces;
    }

    public void remove(Piece piece){
        this.pieces.remove(piece);
    }
}
