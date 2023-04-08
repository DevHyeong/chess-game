package com.exam.chess.model;

import com.exam.chess.pieces.Empty;
import com.exam.chess.pieces.Piece;

public class Game {
    public static final int ROW_COUNT = 8;
    public static final int COL_COUNT = 8;

    private Piece[][] board = new Piece[ROW_COUNT][COL_COUNT];
    private Player player1;
    private Player player2;

    private Game(){
        for(int i = 0; i < ROW_COUNT; i++){
            for(int j = 0; j < COL_COUNT; j++){
                board[i][j] = new Empty(i, j);
            }
        }
    }

    public static Game createBoard(){
        return new Game();
    }

    public void play(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;




    }

    public void start(){




    }


}
