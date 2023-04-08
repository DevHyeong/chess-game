package com.exam.chess.util;

import com.exam.chess.pieces.*;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ChessUtilTest {

    @Test
    void testInit() {
        ChessUtil.init();
        assertEquals(true, ChessUtil.BOARD[0][0] instanceof Rook);
        assertEquals(true, ChessUtil.BOARD[0][1] instanceof Night);
        assertEquals(true, ChessUtil.BOARD[0][2] instanceof Bishop);
        assertEquals(true, ChessUtil.BOARD[0][3] instanceof King);
        assertEquals(true, ChessUtil.BOARD[0][4] instanceof Queen);
        assertEquals(true, ChessUtil.BOARD[0][5] instanceof Bishop);
        assertEquals(true, ChessUtil.BOARD[0][6] instanceof Night);
        assertEquals(true, ChessUtil.BOARD[0][7] instanceof Rook);

        IntStream.range(0, 8).forEach(i -> {
            assertEquals(true, ChessUtil.BOARD[1][i] instanceof Pawn);
        });

        IntStream.range(2, 6).forEach(i-> {
            assertEquals(true, ChessUtil.BOARD[i][0] instanceof Empty);
            assertEquals(true, ChessUtil.BOARD[i][1] instanceof Empty);
            assertEquals(true, ChessUtil.BOARD[i][2] instanceof Empty);
            assertEquals(true, ChessUtil.BOARD[i][3] instanceof Empty);
            assertEquals(true, ChessUtil.BOARD[i][4] instanceof Empty);
            assertEquals(true, ChessUtil.BOARD[i][5] instanceof Empty);
            assertEquals(true, ChessUtil.BOARD[i][6] instanceof Empty);
            assertEquals(true, ChessUtil.BOARD[i][7] instanceof Empty);
        });

        IntStream.range(0, 8).forEach(i -> {
            assertEquals(true, ChessUtil.BOARD[6][i] instanceof Pawn);
        });

        assertEquals(true, ChessUtil.BOARD[7][0] instanceof Rook);
        assertEquals(true, ChessUtil.BOARD[7][1] instanceof Night);
        assertEquals(true, ChessUtil.BOARD[7][2] instanceof Bishop);
        assertEquals(true, ChessUtil.BOARD[7][3] instanceof King);
        assertEquals(true, ChessUtil.BOARD[7][4] instanceof Queen);
        assertEquals(true, ChessUtil.BOARD[7][5] instanceof Bishop);
        assertEquals(true, ChessUtil.BOARD[7][6] instanceof Night);
        assertEquals(true, ChessUtil.BOARD[7][7] instanceof Rook);
    }
}