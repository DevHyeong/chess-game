package com.exam.chess.util;

import com.exam.chess.Location;
import com.exam.chess.model.LocationType;

import static com.exam.chess.model.LocationType.*;
import static com.exam.chess.model.LocationType.ROOK;

public class ChessUtil {
    public static int ROW_COUNT = 8;
    public static int COL_COUNT = 8;
    public static Location[][] board = new Location[ROW_COUNT][COL_COUNT];
    public static LocationType[][] base ={
            {ROOK, NIGHT, BISHOP, KING, QUEEN, BISHOP, NIGHT, ROOK},
            {PAWN, PAWN, PAWN, PAWN, PAWN, PAWN, PAWN, PAWN},
            {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
            {PAWN, PAWN, PAWN, PAWN, PAWN, PAWN, PAWN, PAWN},
            {ROOK, NIGHT, BISHOP, KING, QUEEN, BISHOP, NIGHT, ROOK}
    };

    public static void init(){
        for(int i = 0; i < ROW_COUNT; i ++){
            for(int j = 0; j < COL_COUNT; j ++){
                board[i][j] = base[i][j].getLocation(i, j);
            }
        }
    }


}
