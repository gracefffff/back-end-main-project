package it.sevenbits.formatters.sm.command;

import it.sevenbits.intefaces.IWriter;

import java.io.Writer;

public interface IFormatterCommand {
    void execute(IWriter writer, String token);
}
