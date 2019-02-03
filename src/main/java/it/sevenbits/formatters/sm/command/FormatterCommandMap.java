package it.sevenbits.formatters.sm.command;

import it.sevenbits.formatters.Formatter;
import it.sevenbits.intefaces.IFormatter;
import it.sevenbits.lexers.sm.Pair;
import it.sevenbits.lexers.sm.State;

import java.util.HashMap;
import java.util.Map;

public class FormatterCommandMap {
    private final Map<Pair<State, String>, IFormatterCommand> commands;

    public FormatterCommandMap() {
        this.commands = new HashMap<>();
        commands.put(new Pair<>(new State("DEFAULT"), "OPENBRACE"),  ;



    }

    public IFormatterCommand getCommand(final State state, final String token) {
        if (commands.containsKey(new Pair<>(state, token))) {
            return commands.get(new Pair<>(state,  token));
        } else {
            return commands.get(new Pair<>(state, (String) null));
        }
    }
}

