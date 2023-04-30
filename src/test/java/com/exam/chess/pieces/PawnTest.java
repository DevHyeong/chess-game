package com.exam.chess.pieces;

import com.exam.chess.exception.ImmovableException;
import com.exam.chess.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    private Piece[][] board;
    @BeforeEach
    void setUp(){
        board = Game.createBoard().getBoard();
    }
    @Test
    void testBlackSideMove(){
        Piece pawn = new Pawn(Side.BLACK, Position.position(0, 1));
        board[1][0] = pawn;
        Position target = Position.position(0, 3);
        pawn.move(board, target);

        assertEquals(pawn, board[3][0]);
        assertEquals(true, board[1][0] instanceof Empty);

        Piece night = new Night(Side.WHITE, Position.position(1, 4));
        board[4][1] = night;
        Position target1 = Position.position(1, 4);
        pawn.move(board, target1);

        assertEquals(pawn, board[4][1]);
        assertEquals(true, board[3][0] instanceof Empty);
        assertEquals(night, pawn.getCaughtPiece());

    }

    @Test
    void testWhiteSideMove(){
        Piece pawn = new Pawn(Side.WHITE, Position.position(0, 6));
        board[6][0] = pawn;
        Position target = Position.position(0, 4);
        pawn.move(board, target);

        assertEquals(pawn, board[4][0]);
        assertEquals(true, board[6][0] instanceof Empty);

        Position target1 = Position.position(0, 2);
        assertThrows(ImmovableException.class, () -> pawn.move(board, target1));

    }
}