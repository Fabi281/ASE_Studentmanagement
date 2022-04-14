package de.dhbw.t2inf3001.pe.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {
  public static final String INVALID_INPUT = "Invalid input!";
	static final String NO_STUDENT_SELECTED = "No Student has been selected!";
	public static final String NONEXISTENT_ID = "This ID doesn't exist!";

  protected static IMenu currentMenu;

  public static void setMenu(IMenu menu) {
    currentMenu = menu;
  }

  public static void parseInput(BufferedReader br, PrintStream ps) throws IOException {
    currentMenu.parseInput(br, ps);
  }

  public static String getMenuString() {
    return currentMenu.getMenuString();
  }
}
