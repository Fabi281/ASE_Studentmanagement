package de.dhbw.t2inf3001.pe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import de.dhbw.t2inf3001.pe.Formatter.FormatterManager;
import de.dhbw.t2inf3001.pe.Formatter.FormatterManager.NoLanguageSpecifiedException;
import de.dhbw.t2inf3001.pe.Formatter.FormatterManager.UnknownLanguageException;
import de.dhbw.t2inf3001.pe.Menu.Menu;
import de.dhbw.t2inf3001.pe.Menu.NoLanguageSelectedMenu;
import de.dhbw.t2inf3001.pe.Menu.NoStudentSelectedMenu;

public class Main {

	private static final String ERROR_MESSAGE = "An unexpected error occured!";

	/** 
	 * Main Function that Displays Country Selection and Menu
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to the DHBW Student Management System!");

		Runtime.getRuntime().addShutdownHook(new Thread(() ->{
			System.out.println("Thank you for using the DHBW Student Management System :-)");
		}));

		try {
			FormatterManager.loadFormatter();
			Menu.setMenu(new NoStudentSelectedMenu());
		} catch (UnknownLanguageException | NoLanguageSpecifiedException e) {
			Menu.setMenu(new NoLanguageSelectedMenu());
		}

		/* 
		Initialize BufferedReader and automatically closes it afterwards
		*/
		try (BufferedReader cin = new BufferedReader(new InputStreamReader(System.in))) {

			while (Menu.shouldExit() == false) {
				System.out.println(Menu.getMenuString());
				try {
					Menu.parseInput(cin, System.out);
				} catch (IOException e) {
					System.err.println(ERROR_MESSAGE);
				}
			}

		}
	
	}
}
