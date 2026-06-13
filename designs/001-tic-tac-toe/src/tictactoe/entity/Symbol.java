package tictactoe.entity;

public class Symbol {
    private final char mark;
    public Symbol(char mark) {
        this.mark = mark;
    }
    public char getValue() {
        return mark;
    }
}