package com.exam.chess.pieces;

public class Bishop extends AbstractPiece {

    public Bishop(Position position){
        this.position = position;
    }

    public Bishop(Side side, Position position){
        this.side = side;
        this.expression = side.getExpression("BISHOP");
        this.position = position;
    }

    @Override
    public char expression() {
        return expression;
    }

    @Override
    public void move(Piece[][] board, Position target) {
        if(position.equals(target))
            throw new IllegalArgumentException("");

        if(movable(board, target)){

        }

    }

    @Override
    public Position getPosition() {
        return position;
    }

    private boolean movable(Piece[][] board, Position target){
        int diffX = target.getX() - position.getX();
        int diffY = target.getY() - position.getY();

        if(Math.abs(diffX) == Math.abs(diffY)){
            int i = 0;
            int x = position.getX();
            int y = position.getY();
            int a = diffX < 0 ? -1 : 1;

            while(i < Math.abs(diffX)){
                x += a;
                y += a;

                if(Math.abs(diffX) - 1 == i){
                    Piece piece = board[y][x];
                    if(piece instanceof Empty){
                        move(board, position, target);
                    }else if(!piece.getSide().equals(side)){
                        caughtPiece = piece;
                        move(board, position, target);
                    }else{
                        throw new IllegalStateException("해당 위치에 " + piece.toString());
                    }
                }else if( !(board[y][x] instanceof Empty)){
                    throw new IllegalStateException();
                }
                i++;
            }






        }
        return false;
    }


}
