package it.sevenbits.lexers.sm;

import java.util.Objects;

public class State {
    private final String currentState;

    public State(final String currentState) {
        this.currentState = currentState;
    }
     public String toString() {
        return currentState;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(currentState, state.currentState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentState);
    }
}
