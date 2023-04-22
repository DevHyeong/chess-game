package com.exam.chess.model;

import com.exam.chess.pieces.*;

import java.util.stream.IntStream;

import static com.exam.chess.pieces.Position.position;

public class Game {
    public static final int START_ROW = 0;
    public static final int ROW_COUNT = 8;
    public static final int COL_COUNT = 8;

    private Piece[][] board = new Piece[ROW_COUNT][COL_COUNT];
    private Player player1;
    private Player player2;

    private Game(){
        for(int i = 0; i < ROW_COUNT; i++){
            for(int j = 0; j < COL_COUNT; j++){
                board[i][j] = new Empty(position(i, j));
            }
        }
    }

    public static Game createBoard(){
        return new Game();
    }

    public void play(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;



        player2.addPiece(new Rook(position(0, 7)));
        player2.addPiece(new Night(position(1, 7)));
        player2.addPiece(new Bishop(position(2, 7)));
        player2.addPiece(new Queen(position(3, 7)));
        player2.addPiece(new King(position(4, 7)));
        player2.addPiece(new Bishop(position(5, 7)));
        player2.addPiece(new Night(position(6, 7)));
        player2.addPiece(new Rook(position(7, 7)));

        IntStream.range(0, 7)
                .forEach(i->  player2.addPiece(new Pawn(position(i, 6))));

    }

    public void start(){




    }


}
