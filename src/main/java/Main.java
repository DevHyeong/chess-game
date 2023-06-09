
import com.exam.chess.model.Game;
import com.exam.chess.model.Player;
import com.exam.chess.pieces.Side;

import java.util.Scanner;

import static com.exam.chess.model.Game.COL_COUNT;
import static com.exam.chess.model.Game.ROW_COUNT;

public class Main {

    public static void main(String args[]){

        Game game = Game.createBoard();
        Player player1 = Player.createPlayer(Side.BLACK, game.getBoard());
        Player player2 = Player.createPlayer(Side.WHITE, game.getBoard());

        game.play(player1, player2);
        game.start();
        //game.printBoard();


    }
}
