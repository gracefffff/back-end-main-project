package it.sevenbits.formatters.sm;

import it.sevenbits.exceptions.LexerException;
import it.sevenbits.exceptions.WriterException;
import it.sevenbits.formatters.sm.command.FormatterCommandMap;
import it.sevenbits.formatters.sm.command.IFormatterCommand;
import it.sevenbits.intefaces.IFormatter;
import it.sevenbits.intefaces.ILexer;
import it.sevenbits.intefaces.IToken;
import it.sevenbits.intefaces.IWriter;
import it.sevenbits.lexers.sm.State;
import it.sevenbits.lexers.sm.commands.ICommand;
import it.sevenbits.tokens.Token;

public class FormatterStateMachine implements IFormatter {
    private State currentState = new State("DEFAULT");
    private FormatterStateTransition formatterStateTransition = new FormatterStateTransition();

    @Override
    public void format(final ILexer lexer, final IWriter writer) throws WriterException, LexerException {
        FormatterCommandMap formatterCommandMap = new FormatterCommandMap();
        while (lexer.hasMoreTokens()) {
             IToken currentToken = lexer.readToken();
            IFormatterCommand command = formatterCommandMap.getCommand(currentState, currentToken.getName());
            command.execute(writer, currentToken.getLexeme());
            currentState = formatterStateTransition.nextState(currentState, currentToken.getName());
        }
    }
}
