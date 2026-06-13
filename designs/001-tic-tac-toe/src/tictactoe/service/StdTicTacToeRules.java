package tictactoe.service;

import tictactoe.entity.Board;
import tictactoe.entity.Player;

public class StdTicTacToeRules implements TicTacToeRules{
    public boolean checkWin(Board board, Player player) {
        // Implementation for checking win condition
        int size = board.getSize();
        // Col check
        for(int col = 0; col < size; col++){
            for(int row = 0; row < size; row++){
                if(board.getSymbol(row, col) != player.getSymbol()){
                    break;
                }
                if(row ==size-1) return true;
            }
        }
        //row check
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                if(board.getSymbol(row, col) != player.getSymbol()){
                    break;
                }
                if(col == size-1) return true;
            }
        }

        //diagonal check
        int row = 0;
        int col = 0;
        for(; row < size; row++){
            if(board.getSymbol(row, row) != player.getSymbol()){
                break;
            }
            if(row == size-1) return true;
        }
        row = 0;
        col = size-1;

        for(; col >= 0; col--){
            if(board.getSymbol(row, col) != player.getSymbol()){
                break;
            }
            row++;
        }

        return col == -1;

    }

    public boolean checkDraw(Board board, Player player) {
        // Implementation for checking draw condition
        int size = board.getSize();
        for(int row = 0; row<size; row++){
            for(int col = 0; col<size; col++){
                if(board.getSymbol(row, col) == null){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidMove(Board board, Player player, int row, int col) {
        // Implementation for validating move
        int size = board.getSize();
        if(row<0 || row>=size || col<0 || col>=size) return false;
        return board.getSymbol(row, col)==null;
    }
}
