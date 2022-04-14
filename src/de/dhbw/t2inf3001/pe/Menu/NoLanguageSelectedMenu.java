package de.dhbw.t2inf3001.pe.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import de.dhbw.t2inf3001.pe.Formatter.Formatter;
import de.dhbw.t2inf3001.pe.Formatter.Formatter.NoLanguageSpecifiedException;
import de.dhbw.t2inf3001.pe.Formatter.Formatter.UnknownLanguageException;

public class NoLanguageSelectedMenu implements IMenu{

  //Menu if no language has been selected

  @Override
  public String getMenuString() {
    //Displays the different languages that can be selected
    return "Please choose your preferred language (en_US, de_DE, fr_FR, en_GB) or enter E to exit: ";
  }

  @Override
  public void parseInput(BufferedReader br, PrintStream ps) throws IOException {
    try{
      String input = br.readLine();
      if (input.equals("E")){
        Menu.exit();
        return;
      }
			Formatter.setCountry(input);
      Menu.setMenu(new NoStudentSelectedMenu());
		}catch(UnknownLanguageException | NoLanguageSpecifiedException e ){
			ps.println(Menu.INVALID_INPUT);
		}
  }
  
}
