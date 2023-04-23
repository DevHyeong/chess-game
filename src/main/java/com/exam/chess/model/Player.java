package com.exam.chess.model;

import com.exam.chess.factory.SimplePieceFactory;
import com.exam.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static com.exam.chess.pieces.Position.position;

public class Player {

    private Side side;
    private List<Piece> pieces = new ArrayList<>();

    private Player(Side side){
        if(side == null)
            throw new IllegalArgumentException();

        int x = Game.START_COL;
        int y = side.equals(Side.BLACK) ? Game.START_ROW : Game.START_ROW + Game.ROW_COUNT - 1;
        Position p = position(x, y);

        this.side = side;
        this.pieces = SimplePieceFactory.createPieces(side, p);
    }

    public static Player createPlayer(Side side){
        return new Player(side);
    }

    public void addPiece(Piece piece) {
        this.pieces.add(piece);
    }

    public List<Piece> getPieces(){
        return this.pieces;
    }

    public void remove(Piece piece){
        this.pieces.remove(piece);
    }

    public void execute(Scanner scanner, Piece[][] board){
        System.out.println("플레이어는 움직일 말을 선택하세요");

        String[] split = scanner.nextLine().split("");
        Position position = position(split[0], split[1]);
        Piece piece = board[position.getY()][position.getX()];

        //piece가 빈값이면

        System.out.println("이동할 위치를 입력하세요. 예시: ");
        String[] move = scanner.nextLine().split("");
        Position target = position(move[0], move[1]);
        piece.move(board, target);

        if(piece.getCaughtPiece() != null){

        }

    }

    public Side getSide() {
        return side;
    }
}
