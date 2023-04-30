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
        board[4][2] = bishop;
        board[6][4] = new Night(Side.BLACK, Position.position(4, 6));
        Position p1 = position(5, 7);

        assertThrows(ImmovableException.class, () -> bishop.move(board, p1));
    }

    @Test
    void testMove1(){
        Piece bishop = new Bishop(Side.BLACK, Position.position(2, 4));
        board[4][2] = bishop;
        Position p1 = position(5, 7);
        bishop.move(board, p1);

        assertEquals(bishop, board[7][5]);
        assertEquals(true, board[4][2] instanceof Empty);

    }

}