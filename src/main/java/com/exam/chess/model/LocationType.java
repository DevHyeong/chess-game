package com.exam.chess.model;

import com.exam.chess.Location;

public enum LocationType {
    BISHOP{
        @Override
        public Location getLocation(int x, int y) {
            return new Bishop(x, y);
        }
    },
    EMPTY {
        @Override
        public Location getLocation(int x, int y) {
            return new Empty(x, y);
        }
    },
    KING {
        @Override
        public Location getLocation(int x, int y) {
            return new King(x, y);
        }
    },
    NIGHT {
        @Override
        public Location getLocation(int x, int y) {
            return new Night(x, y);
        }
    },
    PAWN {
        @Override
        public Location getLocation(int x, int y) {
            return new Pawn(x, y);
        }
    },
    QUEEN {
        @Override
        public Location getLocation(int x, int y) {
            return new Queen(x, y);
        }
    },
    ROOK {
        @Override
        public Location getLocation(int x, int y) {
            return new Rook(x, y);
        }
    };

    LocationType(){

    }

    public abstract Location getLocation(int x, int y);

}
