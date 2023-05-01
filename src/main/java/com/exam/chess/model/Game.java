package com.exam.chess.model;

import com.exam.chess.exception.ImmovableException;
import com.exam.chess.pieces.*;

import java.util.Scanner;
import java.util.stream.IntStream;

import static com.exam.chess.pieces.Position.position;
import static com.exam.chess.pieces.Side.BLACK;
import static com.exam.chess.pieces.Side.WHITE;

public class Game {
    public static final String PRINT_BOARD = "pb";
    public static final String PRINT_PIECES_COMMAND = "list";
    public static final String CHOICE_PIECE_COMMAND = "select";
    public static final String MOVE_PIECE_COMMAND = "move";
    public static final String CANCEL_COMMAND = "b";

    public static final int START_ROW = 0;
    public static final int START_COL = 0;
    public static final int ROW_COUNT = 8;
    public static final int COL_COUNT = 8;

    private Side turn;
    private Piece[][] board = new Piece[ROW_COUNT][COL_COUNT];
    private Player player1;
    private Player player2;

    private Piece selectedPiece;
    private Game(){
        turn = BLACK;

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
                .filter(e-> e instanceof King)
                .findFirst()
                .isPresent();
    }

    public void printBoard(){
        System.out.print(" ");
        System.out.print(" ");
        for(int i = 0; i < ROW_COUNT; i++) {
            System.out.print(i + " ");
        }
        System.out.println("");
        for(int i = 0; i < ROW_COUNT; i++){
            System.out.print(i + " ");
            for(int j = 0; j < COL_COUNT; j++){
                System.out.print(board[i][j].expression() + " ");
            }
            System.out.println("");
        }
    }

    public void start(){

        while(isContinue()){
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            try{
                if(turn.equals(BLACK)){
                    execute(command, player1, player2);
                }else{
                    execute(command, player2, player1);
                }
            }catch(ImmovableException e){
                System.err.println("해당 위치로 움직일수가 없습니다.");
            }catch (ArrayIndexOutOfBoundsException e){
                System.err.println("체스판 범위를 벗어났습니다.");
            }
        }

        boolean isPlayer1Win = findKing(player1);
        Player winner = isPlayer1Win ? player1 : player2;

        System.out.println(String.format("%s 플레이어가 승리했습니다.", winner.getSide()));
        System.out.println("게임이 종료되었습니다.");

    }
    /**
     *
     *  말을 선택해야 말을 움직일 수 있다.
     *  말을 움직이게 되면 다음 플레이어로 턴이 돌아가야 한다.
     *
     * */
    public void execute(String command, Player player, Player theOtherPlayer){
        System.out.println(String.format("%s 플레이어 차례입니다.", player.getSide()));
        String[] split = command.split(" ");
        if(split[0].equals(PRINT_PIECES_COMMAND))
            player.printAvailablePieces();
        if(split[0].equals(CHOICE_PIECE_COMMAND))
            selectedPiece = player.choicePiece(Integer.parseInt(split[1]));
        if(split[0].equals(MOVE_PIECE_COMMAND)){
            Position target = position(split[1], split[2]);
            player.move(selectedPiece, target);
            if(selectedPiece.isCaught()){
                theOtherPlayer.remove(selectedPiece.getCaughtPiece());
                selectedPiece.initCaughtPiece();
            }
            turnOver();
        }
        if(split[0].equals(CANCEL_COMMAND)){

        }
        if(split[0].equals(PRINT_BOARD)){
            printBoard();
        }

    }

    public void turnOver(){
        turn = turn.equals(BLACK) ? WHITE : BLACK;
    }

    public Piece[][] getBoard() {
        return board;
    }
}
