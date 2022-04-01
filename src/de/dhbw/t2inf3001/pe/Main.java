package de.dhbw.t2inf3001.pe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import de.dhbw.t2inf3001.pe.Formatter.Formatter;
import de.dhbw.t2inf3001.pe.Formatter.Formatter.NoLanguageSpecifiedException;
import de.dhbw.t2inf3001.pe.Formatter.Formatter.UnknownLanguageException;
import de.dhbw.t2inf3001.pe.Menu.Menu;
import de.dhbw.t2inf3001.pe.Menu.NoLanguageSelectedMenu;
import de.dhbw.t2inf3001.pe.Menu.NoStudentSelectedMenu;
public class Main {

	private static final String ERROR_MESSAGE = "An unexpected error occured!";

	private static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to the DHBW Student Management System!");

		Runtime.getRuntime().addShutdownHook(new Thread(() ->{
			System.out.println("Thank you for using the DHBW Student Management System :-)");
			try {
				cin.close();
			} catch (IOException ignored) {}
		}));

		try{
			Formatter.loadFormatter();
			Menu.setMenu(new NoStudentSelectedMenu());
		}catch(UnknownLanguageException | NoLanguageSpecifiedException e ){
			Menu.setMenu(new NoLanguageSelectedMenu());
		}

		while (true) {
			
			System.out.println(Menu.getMenuString());
			try {
				Menu.parseInput(cin, System.out);
			} catch (IOException e) {
				System.err.println(ERROR_MESSAGE);
			}

		}
	}

}
