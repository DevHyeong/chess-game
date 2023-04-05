package com.exam.chess.util;

import com.exam.chess.Location;
import com.exam.chess.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ChessUtilTest {

    @Test
    void testInit() {
        ChessUtil.init();
        assertEquals(true, ChessUtil.board[0][0] instanceof Rook);
        assertEquals(true, ChessUtil.board[0][1] instanceof Night);
        assertEquals(true, ChessUtil.board[0][2] instanceof Bishop);
        assertEquals(true, ChessUtil.board[0][3] instanceof King);
        assertEquals(true, ChessUtil.board[0][4] instanceof Queen);
        assertEquals(true, ChessUtil.board[0][5] instanceof Bishop);
        assertEquals(true, ChessUtil.board[0][6] instanceof Night);
        assertEquals(true, ChessUtil.board[0][7] instanceof Rook);

        IntStream.range(0, 8).forEach(i -> {
            assertEquals(true, ChessUtil.board[1][i] instanceof Pawn);
        });

        IntStream.range(2, 6).forEach(i-> {
            assertEquals(true, ChessUtil.board[i][0] instanceof Empty);
            assertEquals(true, ChessUtil.board[i][1] instanceof Empty);
            assertEquals(true, ChessUtil.board[i][2] instanceof Empty);
            assertEquals(true, ChessUtil.board[i][3] instanceof Empty);
            assertEquals(true, ChessUtil.board[i][4] instanceof Empty);
            assertEquals(true, ChessUtil.board[i][5] instanceof Empty);
            assertEquals(true, ChessUtil.board[i][6] instanceof Empty);
            assertEquals(true, ChessUtil.board[i][7] instanceof Empty);
        });

        IntStream.range(0, 8).forEach(i -> {
            assertEquals(true, ChessUtil.board[6][i] instanceof Pawn);
        });

        assertEquals(true, ChessUtil.board[7][0] instanceof Rook);
        assertEquals(true, ChessUtil.board[7][1] instanceof Night);
        assertEquals(true, ChessUtil.board[7][2] instanceof Bishop);
        assertEquals(true, ChessUtil.board[7][3] instanceof King);
        assertEquals(true, ChessUtil.board[7][4] instanceof Queen);
        assertEquals(true, ChessUtil.board[7][5] instanceof Bishop);
        assertEquals(true, ChessUtil.board[7][6] instanceof Night);
        assertEquals(true, ChessUtil.board[7][7] instanceof Rook);
    }
}