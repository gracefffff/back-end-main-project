package it.sevenbits.lexers.sm.commands;

import it.sevenbits.lexers.sm.Lexeme;

public class CommandAppend implements ICommand {
    @Override
    public void execute(final Lexeme lexeme, final char symbol) {
        lexeme.add(symbol);
        lexeme.setConstructed(false);
    }
}
