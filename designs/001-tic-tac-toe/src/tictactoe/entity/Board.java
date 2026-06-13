package tictactoe.entity;

public class Board {
    private final int size;
    private final Symbol[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new Symbol[size][size];
    }

    public int getSize() {
        return size;
    }

    public Symbol getSymbol(int row, int col) {
        return grid[row][col];
    }

    public void setSymbol(int row, int col, Symbol symbol) {
        grid[row][col] = symbol;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] != null) {
                    System.out.print(grid[i][j].getValue() + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    public void resetBoard(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = null;
            }
        }
    }
}
