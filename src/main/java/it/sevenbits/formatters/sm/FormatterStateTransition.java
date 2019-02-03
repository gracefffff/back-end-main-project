package it.sevenbits.formatters.sm;

import it.sevenbits.lexers.sm.State;


public class FormatterStateTransition {
    private final FormatterStateMap stateMap;

    public FormatterStateTransition() {
        this.stateMap = new FormatterStateMap();
    }

    public State nextState(final State state, final String token) {
        return stateMap.getNextState(state, token);
    }
}
