package com.exam.chess.util;

import com.exam.chess.pieces.Piece;
import com.exam.chess.pieces.Piece__;
import com.exam.chess.pieces.Side;

import static com.exam.chess.pieces.Piece__.*;
import static com.exam.chess.pieces.Piece__.ROOK;

public class ChessUtil {
    public static final int ROW_COUNT = 8;
    public static final int COL_COUNT = 8;
    public static Piece[][] BOARD = new Piece[ROW_COUNT][COL_COUNT];
    public static final Piece__[][] BASE ={
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
                Side side = i > 1 ? Side.WHITE : Side.BLACK;
                BOARD[i][j] = BASE[i][j].position(side, i, j);
            }
        }
    }


}
