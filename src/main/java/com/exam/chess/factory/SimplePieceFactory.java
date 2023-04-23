package com.exam.chess.factory;

import com.exam.chess.model.Game;
import com.exam.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.exam.chess.pieces.Position.position;

public class SimplePieceFactory {

    public static List<Piece> createPieces(Side side, Position p){
        List<Piece> pieces = new ArrayList<>();
        int x = p.getX();
        int y = p.getY();
        int col = side.equals(Side.BLACK) ? 1 : -1;

        IntStream.range(Game.START_COL, Game.COL_COUNT)
                .forEach(i->  pieces.add(new Pawn(side, position(i, y + col))));
        pieces.add(new Rook(side, position(x++, y)));
        pieces.add(new Night(side, position(x++, y)));
        pieces.add(new Bishop(side, position(x++, y)));
        pieces.add(new Queen(side, position(x++, y)));
        pieces.add(new King(side, position(x++, y)));
        pieces.add(new Bishop(side, position(x++, y)));
        pieces.add(new Night(side, position(x++, y)));
        pieces.add(new Rook(side, position(x++, y)));

        return pieces;
    }
}
