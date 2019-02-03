package it.sevenbits.lexers.sm;

public class Lexeme {
    private StringBuilder lexeme;
    private boolean constructed;

    public Lexeme() {
        lexeme = new StringBuilder();
        constructed = false;
    }

    @Override
    public String toString() {
        return lexeme.toString();
    }

    public boolean isConstructed() {
        return constructed;
    }

    public void setConstructed(final boolean constructed) {
        this.constructed = constructed;
    }

    public void add(final char symbol) {
        lexeme.append(symbol);
    }

    public void clear() {
        lexeme.setLength(0);
    }
}
