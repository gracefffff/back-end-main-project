package it.sevenbits.lexers.sm;

import java.util.HashMap;
import java.util.Map;

public class StateMap {
    private final State defaultState = new State("DEFAULT");
    private final Map<Pair<State,Character >, State> states;
    private final  State  constructState = new State("CONSTRUCT");


    public StateMap() {


        states = new HashMap<>();
          State stopState = new State("STOP");
          State singleTokenState = new State("LAST_SYMBOL");
         // State endState  = new State("END");
      //  states.put(new Pair<>(startState, ), constructState);

        states.put(new Pair<>(constructState, ' '), defaultState);
        states.put(new Pair<>(constructState, ';'), defaultState);
        states.put(new Pair<>(constructState, '{'), defaultState);
        states.put(new Pair<>(constructState, '}'), defaultState);
        states.put(new Pair<>(constructState, null), constructState);

       // states.put(new Pair<>(startState, '\0'), startState);


      //  states.put(new Pair<>(defaultState, null), singleTokenState);
        states.put(new Pair<>(defaultState, '}'), singleTokenState);
        states.put(new Pair<>(defaultState, ';'), singleTokenState);
        states.put(new Pair<>(defaultState, ' '), singleTokenState);
        states.put(new Pair<>(defaultState, '{'), singleTokenState);


        states.put(new Pair<>(defaultState, '\0'), defaultState);
        states.put(new Pair<>(defaultState, null), constructState);


     //   states.put(new Pair<>(singleTokenState, null), stopState);




    //    states.put(new Pair<>(constructState, '"'), stopState);
      //  states.put(new Pair<>(constructState, '\n'), stopState);

       // states.put(new Pair<>(constructState, "CONSTRUCT"), constructState);


    }

    //public State getStartState() {
   //     return startState;
    //}

    public State getNextState(final State state, final char symbol) {
        if (states.containsKey(new Pair<>(state, symbol))) {
            return states.get(new Pair<>(state, symbol));
        } else {
            return states.getOrDefault(new Pair<>(state, (Character) null), defaultState);
        }
    }
    }
     //   return states.getOrDefault(new Pair<>(state, signal), defaultState);
   // }


