import tictactoe.config.GameFactory;
import tictactoe.entity.Game;

public class TicTacToe{

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");
        GameFactory.createGame(tictactoe.entity.GAMETYPE.TWO_PLAYER).startGame();
    }

}