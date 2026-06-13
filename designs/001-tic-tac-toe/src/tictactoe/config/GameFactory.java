package tictactoe.config;

import tictactoe.entity.*;
import tictactoe.service.StdTicTacToeRules;

import java.util.ArrayList;
import java.util.List;

public class GameFactory {

    public static Game createGame(GAMETYPE gameType) {
        switch (gameType) {
            case TWO_PLAYER:
                return createGameForTwoPlayer();
            case MULTI_PLAYER:
                return new Game(); // Assuming multi-player supports up to 4 players
            default:
                throw new IllegalArgumentException("Invalid game type");
        }
    }

    private static Game createGameForTwoPlayer() {
        Board board = new Board(3);
        List<Player> players = new ArrayList<>();
        addPlayersToGame(2, players);
        return new Game(players, board, 0, new StdTicTacToeRules(), 2);
    }

    private static void addPlayersToGame(int playerCount, List<Player> list) {
        for(int i = 0; i < playerCount; i++) {
            System.out.println("Enter name for Player " + (i + 1) + ":");
            String name = new java.util.Scanner(System.in).nextLine();
            System.out.println("Enter symbol for " + name + ":");
            String symbolStr = new java.util.Scanner(System.in).nextLine();
            char symbolChar = symbolStr.charAt(0);
            Symbol symbol = new Symbol(symbolChar);
            list.add(new Player(name, 0, symbol));
        }
    }
}
