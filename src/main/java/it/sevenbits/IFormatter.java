package it.sevenbits;

import it.sevenbits.readers.IReader;
import it.sevenbits.writers.IWriter;

public interface IFormatter {
    void format(IReader reader, IWriter writer);
}
