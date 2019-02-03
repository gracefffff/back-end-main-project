package it.sevenbits.lexers.sm;

import it.sevenbits.exceptions.LexerException;
import it.sevenbits.exceptions.ReaderException;
import it.sevenbits.intefaces.ILexer;
import it.sevenbits.intefaces.IReader;
import it.sevenbits.intefaces.IToken;
import it.sevenbits.lexers.sm.commands.CommandMap;
import it.sevenbits.lexers.sm.commands.ICommand;
import it.sevenbits.tokens.Token;

import java.util.HashMap;
import java.util.Map;

public class LexerStateMachine implements ILexer {
    private IReader reader;
    private Map<String, String> hashMap;
    private char currentSymbol = (int) 0;
    private State currentState = new State("DEFAULT");
    private StateTransition stateTransition = new StateTransition();
    private Lexeme lexeme = new Lexeme();
    public LexerStateMachine(IReader reader) {
        hashMap = new HashMap<>();
        hashMap.put(" ", "SPACE");
        hashMap.put("{", "OPENBRACE");
        hashMap.put("}", "CLOSEBRACE");
        hashMap.put(";", "SEMICOLON");
        hashMap.put("\n", "NEWLINE");

     //   hashMap.put("DEFAULT", "TABULATION");
        this.reader = reader;
    }

    @Override
    public boolean hasMoreTokens() {
        return reader.hasNext() || lexeme.isConstructed();
    }
    private String getValue(final String key) {
        return hashMap.getOrDefault(key, "DEFAULT");
    }

    @Override
    public IToken readToken() throws LexerException {

        CommandMap commandMap = new CommandMap();
        lexeme.clear();




        try {

            ICommand command = commandMap.getCommand(currentState, currentSymbol);
            command.execute(lexeme, currentSymbol);
            currentState  = stateTransition.nextState(currentState, currentSymbol);
            while (reader.hasNext() && !lexeme.isConstructed()) {

                 currentSymbol = reader.read();
                 command = commandMap.getCommand(currentState, currentSymbol);
                // TODO: как передать контекст? TokenBuilder? Аргумент в execute?
               command.execute(lexeme, currentSymbol);
                currentState = stateTransition.nextState(currentState, currentSymbol);
            }
        } catch (ReaderException ex) {
            throw new LexerException(ex.getMessage());
        }

        // TODO: обработать последний символ?
        return new Token(getValue(lexeme.toString()), lexeme.toString());

    }
}
