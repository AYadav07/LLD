package tictactoe.service;

import tictactoe.entity.Board;
import tictactoe.entity.Player;

public interface TicTacToeRules {
    public boolean checkWin(Board board, Player player);
    public boolean checkDraw(Board board, Player player);
    public boolean isValidMove(Board board, Player player, int row, int col);
}
