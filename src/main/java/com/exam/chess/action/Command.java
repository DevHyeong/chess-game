package com.exam.chess.action;

import com.exam.chess.model.Game;
import com.exam.chess.model.Player;
import com.exam.chess.pieces.Piece;
import com.exam.chess.pieces.Position;

import static com.exam.chess.pieces.Position.position;

public enum Command {
    PRINT_BOARD("pb"){
        @Override
        public void execute(Game game, Player player, Player theOtherPlayer, String[] split) {
            game.printBoard();
        }
    },
    PRINT_PIECES_COMMAND("list"){
        @Override
        public void execute(Game game, Player player, Player theOtherPlayer, String[] split) {
            player.printAvailablePieces();
        }
    },
    CHOICE_PIECE_COMMAND("select"){
        @Override
        public void execute(Game game, Player player, Player theOtherPlayer, String[] split) {
            Piece piece = player.choicePiece(Integer.parseInt(split[1]));
            game.setSelectedPiece(piece);
        }
    },
    MOVE_PIECE_COMMAND("move"){
        @Override
        public void execute(Game game, Player player, Player theOtherPlayer, String[] split) {
            Position target = position(split[1], split[2]);
            player.move(game.getSelectedPiece(), target);
            if(game.getSelectedPiece().isCaught()){
                theOtherPlayer.remove(game.getSelectedPiece().getCaughtPiece());
                game.getSelectedPiece().initCaughtPiece();
            }
            game.turnOver();
            game.printBoard();
            System.out.println(String.format("%s 플레이어 차례입니다.", theOtherPlayer.getSide()));
        }
    };

    private final String command;
    Command(String command){
        this.command = command;
    }

    public String getCommand(){
        return this.command;
    }

    public abstract void execute(Game game, Player player, Player theOtherPlayer, String[] split);
}
