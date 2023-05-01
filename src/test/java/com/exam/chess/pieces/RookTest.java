package com.exam.chess.pieces;

import com.exam.chess.exception.ImmovableException;
import com.exam.chess.model.Game;
import com.exam.chess.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.exam.chess.model.Game.ROW_COUNT;
import static com.exam.chess.pieces.Position.position;
import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    private Piece[][] board;
    @BeforeEach
    void setUp(){
         board = Game.createBoard().getBoard();

    }
    @Test
    void testMove() {
        Piece rook = new Rook(Side.BLACK, position(0, 0));
        Piece pawn = new Pawn(Side.WHITE, position(0, 5));
        board[0][0] = rook;
        board[5][0] = pawn;

        Position target = position(0, 5);
        Piece piece = board[0][0];
        piece.move(board, target);

        assertEquals(true, board[0][0] instanceof Empty);
        assertEquals(true, board[5][0].equals(rook));
        assertEquals(0, rook.getPosition().getX());
        assertEquals(5, rook.getPosition().getY());
        assertEquals(pawn, rook.getCaughtPiece());
    }

    @Test
    void testIllegalArgumentException(){
        Piece rook = new Rook(Side.BLACK, position(0, 0));
        Piece night = new Night(Side.BLACK, position(0, 3));
        Piece pawn = new Pawn(Side.WHITE, position(0, 5));
        board[0][0] = rook;
        board[3][0] = night;
        board[5][0] = pawn;

        assertThrows(IllegalArgumentException.class, () -> position(-1, 5));
        assertThrows(IllegalArgumentException.class, () -> position(0, ROW_COUNT));
    }

    @Test
    void testImmovableException(){
        Piece rook = new Rook(Side.BLACK, position(0, 0));
        Piece pawn = new Pawn(Side.WHITE, position(0, 5));
        Piece pawn1 = new Pawn(Side.WHITE, position(3, 0));
        board[0][0] = rook;
        board[5][0] = pawn;
        board[0][3] = pawn1;

        Position target = position(0, 6);
        Position target1 = position(5, 0);

        assertThrows(ImmovableException.class, () -> rook.move(board, target));
        assertThrows(ImmovableException.class, () -> rook.move(board, target1));
    }

}