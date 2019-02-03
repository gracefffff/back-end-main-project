package it.sevenbits.lexers.sm.commands;

import it.sevenbits.lexers.sm.Lexeme;

public interface ICommand {
    void execute(Lexeme lexeme, char symbol);
}
