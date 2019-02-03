package it.sevenbits.lexers.sm;

public class StateTransition {

    private final StateMap stateMap;

    public StateTransition() {
        this.stateMap = new StateMap();
    }

    public State nextState(final State state, final char symbol) {
        return stateMap.getNextState(state, symbol);
    }

   // public State getStartState() {
     //   return this.stateMap.getStartState();
   // }
}


