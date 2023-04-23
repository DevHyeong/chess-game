package com.exam.chess.pieces;

import com.exam.chess.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.exam.chess.pieces.Position.position;
import static org.junit.jupiter.api.Assertions.*;

class NightTest {
    private Piece[][] board;
    @BeforeEach
    void setUp(){
        board = Game.createBoard().getBoard();
    }
    @Test
    void testMove(){
        Piece night = new Night(Side.BLACK, position(3, 5));
        board[5][3] = night;
        Position p1 = position(1, 4);
        Position p2 = position(1, 6);
        Position p3 = position(2, 7);
        Position p4 = position(4, 7);
        Position p5 = position(5, 6);
        Position p6 = position(5, 4);
        Position p7 = position(2, 3);
        Position p8 = position(4, 3);

        board[5][3].move(board, p1);
        assertEquals(true, board[4][1].equals(night));
    }
}