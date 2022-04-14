package de.dhbw.t2inf3001.pe.MenuTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import de.dhbw.t2inf3001.pe.Menu.IMenu;

/**
 * TestMenu for testing Menu independently of specific Menu-State
 */
public class TestMenu implements IMenu{

  @Override
  public String getMenuString() {
    return "TESTMENU";
  }

  @Override
  public void parseInput(BufferedReader br, PrintStream ps) throws IOException {

  }
  
}
