package com.exam.chess.model;

import com.exam.chess.pieces.*;

import java.util.Scanner;
import java.util.stream.IntStream;

import static com.exam.chess.pieces.Position.position;

public class Game {
    public static final int START_ROW = 0;
    public static final int START_COL = 0;
    public static final int ROW_COUNT = 8;
    public static final int COL_COUNT = 8;

    private int turn;
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

        setPieces(this.player1);
        setPieces(this.player2);
    }

    private void setPieces(Player player){
        for(Piece p : player.getPieces()){
            int x = p.getPosition().getX();
            int y = p.getPosition().getY();
            board[y][x] = p;
        }
    }

    private boolean isContinue(){
        return findKing(player1) && findKing(player2);
    }

    private boolean findKing(Player player){
        return player.getPieces()
                .stream()
                .map(e-> e.expression())
                .findFirst()
                .isPresent();
    }

    public void printBoard(){
        for(int i = 0; i < ROW_COUNT; i++){
            for(int j = 0; j < COL_COUNT; j++){
                System.out.print(board[i][j].expression());
            }
            System.out.println("");
        }
    }

    public void start(){

        while(isContinue()){
            Scanner scanner = new Scanner(System.in);

            if(turn == 1){
                player1.execute(scanner, board);

            }

            if(turn == 2){
                player2.execute(scanner, board);
            }
        }
    }

    public Piece[][] getBoard() {
        return board;
    }
}
