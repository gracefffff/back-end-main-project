package it.sevenbits;

/**
 * this is  Token which Lexer created
 */
public class Token implements IToken {
    private String name;
    private String lexeme;

    /**
     *
     * @param name this is name of Token
     * @param lexeme this is characters(lexeme) that this token contains
     */
     Token(final String name, final String lexeme) {
        this.name = name;
        this.lexeme = lexeme;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLexeme() {
        return lexeme;
    }
}
