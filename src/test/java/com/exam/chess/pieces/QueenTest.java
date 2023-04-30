package com.exam.chess.pieces;

import com.exam.chess.exception.ImmovableException;
import com.exam.chess.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    private Piece[][] board;
    @BeforeEach
    void setUp(){
        board = Game.createBoard().getBoard();
    }

    @Test
    void testMove(){
        Piece queen = new Queen(Side.BLACK, Position.position(2, 5));
        board[5][2] = queen;
        Position target = Position.position(4,7);

        queen.move(board, target);
        assertEquals(queen, board[7][4]);
        assertEquals(true, board[5][2] instanceof Empty);

        Position target1 = Position.position(6, 7);
        queen.move(board, target1);
        assertEquals(queen, board[7][6]);
        assertEquals(true, board[7][4] instanceof Empty);

        Position target2 = Position.position(6, 2);
        board[2][6] = new Pawn(Side.WHITE, Position.position(6, 2));
        queen.move(board, target2);
        assertEquals(queen, board[2][6]);
        assertEquals(true, queen.getCaughtPiece() instanceof Pawn);
    }

    @Test
    void testMoveException(){
        Piece queen = new Queen(Side.BLACK, Position.position(1,2));
        board[2][1] = queen;
        Position target = Position.position(3,3);
        assertThrows(ImmovableException.class, () -> queen.move(board,target));

        board[4][3] = new Bishop(Side.BLACK, Position.position(3,4));
        Position target1 = Position.position(4, 5);
        assertThrows(ImmovableException.class, () -> queen.move(board, target1));

        Position target2 = Position.position(5, 2);
        board[2][5] = new Pawn(Side.BLACK, target2);
        assertThrows(ImmovableException.class, () -> queen.move(board, target2));
    }

}