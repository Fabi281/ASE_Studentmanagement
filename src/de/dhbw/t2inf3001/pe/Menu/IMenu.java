package de.dhbw.t2inf3001.pe.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public interface IMenu {
    public String getMenuString();
    public void parseInput(BufferedReader br, PrintStream ps) throws IOException;
}
