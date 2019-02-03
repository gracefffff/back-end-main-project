package it.sevenbits.lexers.sm.commands;

import it.sevenbits.lexers.sm.Pair;
import it.sevenbits.lexers.sm.State;

import java.util.HashMap;
import java.util.Map;

public class CommandMap {
    private final Map<Pair<State, Character>, ICommand> commands;

    public CommandMap() {
        this.commands = new HashMap<>();
        commands.put(new Pair<>(new State("CONSTRUCT"), ' '), new CommandStop());
        commands.put(new Pair<>(new State("CONSTRUCT"), ';'), new CommandStop());
        commands.put(new Pair<>(new State("CONSTRUCT"), '}'), new CommandStop());
        commands.put(new Pair<>(new State("CONSTRUCT"), '{'), new CommandStop());
        commands.put(new Pair<>(new State("CONSTRUCT"), null), new CommandAppend());


        commands.put(new Pair<>(new State("DEFAULT"), '\0'), new Skip());
        commands.put(new Pair<>(new State("DEFAULT"), null), new CommandAppend());


        commands.put(new Pair<>(new State("DEFAULT"), ' '), new CommandAppend());
        commands.put(new Pair<>(new State("DEFAULT"), ';'), new CommandAppend());
        commands.put(new Pair<>(new State("DEFAULT"), '}'), new CommandAppend());
        commands.put(new Pair<>(new State("DEFAULT"), '{'), new CommandAppend());


        commands.put(new Pair<>(new State("LAST_SYMBOL"), null), new CommandStop());


    }

    public ICommand getCommand(final State state, final char symbol) {
        if (commands.containsKey(new Pair<>(state, symbol))) {
            return commands.get(new Pair<>(state, symbol));
        } else {
            return commands.get(new Pair<>(state, (Character) null));
        }
    }
}
       // return commands.getOrDefault(new Pair<>(state, signal), new CommandAppend());
//


