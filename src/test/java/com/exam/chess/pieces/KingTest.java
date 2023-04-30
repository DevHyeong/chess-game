package com.exam.chess.pieces;

import com.exam.chess.exception.ImmovableException;
import com.exam.chess.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    private Piece[][] board;
    @BeforeEach
    void setUp(){
        board = Game.createBoard().getBoard();
    }

    @Test
    void testMove(){
        Piece king = new King(Side.BLACK, Position.position(1,2));
        board[2][1] = king;
        Position target = Position.position(2, 3);
        king.move(board, target);

        assertEquals(true, king.equals(board[3][2]));
        assertEquals(true, board[2][1] instanceof Empty);

        Position target1 = Position.position(3,3);
        king.move(board, target1);

        assertEquals(true, king.equals(board[3][3]));
        assertEquals(true, board[3][2] instanceof Empty);

        Position target2 = Position.position(5,3);
        assertThrows(ImmovableException.class, () -> king.move(board,target2));
        assertEquals(true, king.equals(board[3][3]));
        assertEquals(true, board[3][2] instanceof Empty);
    }

}