package com.exam.chess.model;

import com.exam.chess.exception.ImmovableException;
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

    private Piece[][] board;

    private Player(Side side, Piece[][] board){
        if(side == null)
            throw new IllegalArgumentException();

        int x = Game.START_COL;
        int y = side.equals(Side.BLACK) ? Game.START_ROW : Game.START_ROW + Game.ROW_COUNT - 1;
        Position p = position(x, y);

        this.side = side;
        this.pieces = SimplePieceFactory.createPieces(side, p);
        this.board = board;
    }

    public static Player createPlayer(Side side, Piece[][] board){
        return new Player(side, board);
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


    public void printAvailablePieces(){
        int i = 0;
        for(Piece p : pieces){
            System.out.println(i + "번: " + p);
            i++;
        }
    }

    public Piece choicePiece(int index){
        if(index < 0 || index > this.pieces.size() - 1)
            throw new ArrayIndexOutOfBoundsException("");

        Piece piece = this.pieces.get(index);
        System.out.println(String.format("x: %s y: %s 위치의 %s가 선택되었습니다.", piece.getPosition().getX(), piece.getPosition().getY(), piece.expression()));
        return piece;
    }

    public void move(Piece piece, Position target){
        System.out.println(String.format("%s를 x:%s y:%s으로 움직이겠습니다.", piece.expression(), target.getX(), target.getY()));
        piece.move(board, target);
    }

    public Side getSide() {
        return side;
    }
}
