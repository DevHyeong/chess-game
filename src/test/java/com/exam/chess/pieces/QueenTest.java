package com.exam.chess.pieces;

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
        //Position target1 = Position.position()

    }

}