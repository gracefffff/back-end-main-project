package it.sevenbits.lexers.sm.commands;

import it.sevenbits.lexers.sm.Lexeme;

public class Skip implements ICommand {
    @Override
    public void execute(Lexeme lexeme, final char symbol) {
       // lexeme.setConstructed(false);
    }
}
