package com.exam.chess.pieces;

public enum Piece__ {
    BISHOP{
        @Override
        public Piece position(Side side, int x, int y) {
            return new Bishop(side, x, y);
        }
    },
    EMPTY {
        @Override
        public Piece position(Side side, int x, int y) {
            return new Empty(x, y);
        }
    },
    KING {
        @Override
        public Piece position(Side side, int x, int y) {
            return new King(side, x, y);
        }
    },
    NIGHT {
        @Override
        public Piece position(Side side, int x, int y) {
            return new Night(side, x, y);
        }
    },
    PAWN {
        @Override
        public Piece position(Side side, int x, int y) {
            return new Pawn(side, x, y);
        }
    },
    QUEEN {
        @Override
        public Piece position(Side side, int x, int y) {
            return new Queen(side, x, y);
        }
    },
    ROOK {
        @Override
        public Piece position(Side side, int x, int y) {
            return new Rook(side, x, y);
        }
    };

    Piece__(){

    }

    public abstract Piece position(Side side, int x, int y);

}
