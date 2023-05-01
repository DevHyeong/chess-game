package com.exam.chess.pieces;

import com.exam.chess.exception.ImmovableException;
import com.exam.chess.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.exam.chess.pieces.Position.position;
import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    private Piece[][] board;
    @BeforeEach
    void setUp(){
        board = Game.createBoard().getBoard();
    }

    @Test
    void testMove(){
        Piece bishop = new Bishop(Side.BLACK, Position.position(2, 4));
        Piece whiteBishop = new Bishop(Side.WHITE, position(2, 7));
        board[4][2] = bishop;
        board[7][2] = whiteBishop;
        Position target = position(5, 7);
        Position target1 = position(4, 5);
        bishop.move(board, target);
        whiteBishop.move(board, target1);

        assertEquals(bishop, board[7][5]);
        assertEquals(true, board[4][2] instanceof Empty);
        assertEquals(whiteBishop, board[5][4]);

    }
    @Test
    void testImmovableException(){
        Piece bishop = new Bishop(Side.BLACK, Position.position(2, 4));
        board[4][2] = bishop;
        board[6][4] = new Night(Side.BLACK, Position.position(4, 6));
        Position p1 = position(5, 7);

        assertThrows(ImmovableException.class, () -> bishop.move(board, p1));
    }

}