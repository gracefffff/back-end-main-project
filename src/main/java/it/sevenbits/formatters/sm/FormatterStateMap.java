package it.sevenbits.formatters.sm;

import it.sevenbits.intefaces.IToken;
import it.sevenbits.lexers.sm.Pair;
import it.sevenbits.lexers.sm.State;

import java.util.HashMap;
import java.util.Map;

public class FormatterStateMap {  private final State defaultState = new State("DEFAULT");
    private final Map<Pair<State, String>, State> states;
    private final  State  constructState = new State("CONSTRUCT");


    public FormatterStateMap() {


        states = new HashMap<>();
        State constructLine = new State("constructLine");


       // State singleTokenState = new State("LAST_SYMBOL");
        states.put(new Pair<>(defaultState, null), defaultState);
        states.put(new Pair<>(defaultState, "CLOSEBRACE"), defaultState);
        states.put(new Pair<>(defaultState, "OPENBRACE"), defaultState);
        states.put(new Pair<>(defaultState, "SEMICOLON"), defaultState);
        states.put(new Pair<>(defaultState, "NEWLINE"), defaultState);

        states.put(new Pair<>(constructLine, "NEWLINE"), defaultState);



        states.put(new Pair<>(defaultState, "DEFAULT"), constructLine);
        states.put(new Pair<>(defaultState, "SPACE"), constructLine);









    }



    public State getNextState(final State state, final String token) {
        if (states.containsKey(new Pair<>(state, token))) {
            return states.get(new Pair<>(state, token));
        } else {
            return states.getOrDefault(new Pair<>(state, (String) null), defaultState);
        }
    }
}



