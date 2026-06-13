package tictactoe.entity;

import tictactoe.service.TicTacToeRules;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game{
    List<Player> players;
    Board board;
    int currentPlayer;
    TicTacToeRules rules;
    int totalPlayers;
    boolean gameOver;

    public Game(){}
    public Game(List<Player> players, Board board, int currentPlayer, TicTacToeRules rules, int totalPlayers) {
        this.players = players;
        this.board = board;
        this.currentPlayer = currentPlayer;
        this.rules = rules;
        this.totalPlayers = totalPlayers;
        this.gameOver = false;
    }
    public void startGame(){
        // Initialize the game, set up the board and players
        Scanner sc = new Scanner(System.in);
        while(!gameOver){
            System.out.println();
            System.out.println();
            board.printBoard();
            System.out.println("It is player " + players.get(currentPlayer).getName() + " turn to mark on the board");
            System.out.println("Please enter the row and col for your symbol (e.g., 0 0):");
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);

            if(rules.isValidMove(board, players.get(currentPlayer), row, col)){
                board.setSymbol(row, col, players.get(currentPlayer).getSymbol());
                if(rules.checkWin(board, players.get(currentPlayer))){
                    System.out.println("Player " + players.get(currentPlayer).getName() + " wins!");
                    players.get(currentPlayer).incrementScore();
                    gameOver = true;
                } else if(rules.checkDraw(board, players.get(currentPlayer))){
                    System.out.println("The game is a draw!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer + 1) % totalPlayers;
                }
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }

        printPlayersScore();

        System.out.println("Do you want to play again? (yes/no) or (y/n)");
        String playAgain = sc.nextLine();
        if(playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("y")){
            board.resetBoard();
            gameOver = false;
            startGame();
        } else {
            announceWinner();
            System.out.println("Thanks for playing!");

        }
        sc.close();
    }

    public void printPlayersScore(){
        for(int i = 0; i < totalPlayers; i++){
            System.out.println(players.get(i).getName() + " score: " + players.get(i).getScore());
        }
    }

    public void announceWinner(){
        int maxScore = -1;
        List<Integer> winners = new ArrayList<>();
        for(int i = 0; i < totalPlayers; i++){
            if(players.get(i).getScore() > maxScore){
                winners = new ArrayList<>();
                maxScore = players.get(i).getScore();
                winners.add(i);
            } else if(players.get(i).getScore() == maxScore) {
                winners.add(i);
            }
        }

        System.out.println("The winner(s) is/are with scores: " + maxScore);
        for(int winner : winners){
            System.out.println(players.get(winner).getName());
        }
    }
}