package de.dhbw.t2inf3001.pe.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import de.dhbw.t2inf3001.pe.Formatter.Formatter;
import de.dhbw.t2inf3001.pe.Formatter.Formatter.NoLanguageSpecifiedException;
import de.dhbw.t2inf3001.pe.Formatter.Formatter.UnknownLanguageException;

public class NoLanguageSelectedMenu implements IMenu{

  @Override
  public String getMenuString() {
    return "Please choose your preferred language (en_US, de_DE, fr_FR, en_GB): ";
  }

  @Override
  public void parseInput(BufferedReader br, PrintStream ps) throws IOException {
    try{
			Formatter.setCountry(br.readLine());
      Menu.setMenu(new NoStudentSelectedMenu());
		}catch(UnknownLanguageException | NoLanguageSpecifiedException e ){
			ps.println(Menu.INVALID_INPUT);
		}
  }
  
}
