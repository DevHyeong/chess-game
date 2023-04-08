
import com.exam.chess.model.Game;
import com.exam.chess.model.Player;
import com.exam.chess.pieces.Side;

import static com.exam.chess.util.ChessUtil.*;

public class Main {

    public static void main(String args[]){

        Game game = Game.createBoard();
        Player player1 = Player.createPlayer(Side.BLACK);
        Player player2 = Player.createPlayer(Side.WHITE);

        game.play(player1, player2);


        for(int i = 0; i < ROW_COUNT; i++){
            for(int j = 0; j < COL_COUNT; j++){
                System.out.print(BOARD[i][j].expression());
            }
            System.out.println("");
        }

    }
}
