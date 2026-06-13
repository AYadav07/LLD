package tictactoe.entity;

public class Player {
    private final String name;
    private int score;
    private final Symbol symbol;
    public Player(String name, int score, Symbol symbol) {
        this.name = name;
        this.score = score;
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Symbol getSymbol() {
        return symbol;
    }
    public void incrementScore() {
        score++;
    }
}