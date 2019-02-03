package it.sevenbits.lexers.sm.commands;

import it.sevenbits.lexers.sm.Lexeme;

public class CommandStop implements ICommand {
    @Override
    public void execute(final Lexeme lexeme, final char symbol) {
        lexeme.setConstructed(true);

    }
}
