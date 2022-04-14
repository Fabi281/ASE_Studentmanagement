package de.dhbw.t2inf3001.pe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

import de.dhbw.t2inf3001.pe.Formatter.FormatterManager;
import de.dhbw.t2inf3001.pe.Formatter.GenericFormatter;
import de.dhbw.t2inf3001.pe.Formatter.FormatterManager.NoLanguageSpecifiedException;
import de.dhbw.t2inf3001.pe.Formatter.FormatterManager.UnknownLanguageException;
public class Main {

	private static final String INVALID_INPUT = "Invalid input!";
	private static final String NO_STUDENT_SELECTED = "No Student has been selected!";
	private static final String NONEXISTENT_ID = "This ID doesn't exist!";

	static class MenuResult {
		String response = null;
		Student newStudent = null;
		boolean finished = false;
	}

	private static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

	public static GenericFormatter formatter;
	
	public static void main(String[] args) throws Exception {
		/*
		Main Function that Displays Country Selection and Menu
		*/
		System.out.println("Welcome to the DHBW Student Management System!");

		setCountry(true);		
		
		Student student = null;
		int action;
		MenuResult result;
		while (true) {
			
			printMenu();
			try{
				action = readIntInput(cin);
			} catch (IOException | NumberFormatException e) {
				System.out.println(INVALID_INPUT);
				continue;
			}

			result = processMenuSelection(action, student, cin, System.out);
			if (result.response != null)
				System.out.println(result.response);
			if (result.finished)
				break;
			if (result.newStudent != null)
				student = result.newStudent;

		}

		System.out.println("Thank you for using the DHBW Student Management System :-)");

		cin.close();
	}

	static private void setCountry(boolean firstRender) throws IOException{
		/*
		Function to set the current Country
		Used to define the Country specific formatting
		*/
		try{
			formatter = FormatterManager.getFormatter();
		}catch(UnknownLanguageException | NoLanguageSpecifiedException e ){
			if(!firstRender){
				System.out.println(INVALID_INPUT);
			}
			System.out.println("Please choose the Country you are from (en_US, de_DE, fr_FR, en_GB): ");
			String selectedCountry = cin.readLine();
			FormatterManager.setCountry(selectedCountry);
			setCountry(false);
		}
	}

	static int readIntInput(BufferedReader br) throws IOException, NumberFormatException{
		/*
		Parses Input into an Integer, to prevent false variable errors
		*/
		String input = br.readLine();
		return Integer.parseInt(input);
	}

	static MenuResult processMenuSelection(int action, Student selectedStudent, BufferedReader br, PrintStream ps) throws IOException {
		/*
		Process the Menu Selection and executes the coresponding Function.
		Otherwise prints an error message
		*/
		MenuResult result = new MenuResult();
		if(selectedStudent == null && Arrays.asList(2,3,4,5).contains(action)){
			result.response = NO_STUDENT_SELECTED;
			return result;
		}
		switch (action) {
			case 1: // ID Selection and return a Student
				ps.println("Enter id: ");
				int id;
				try {
					id = readIntInput(br);
				} catch (NumberFormatException | IOException e) {
					result.response = INVALID_INPUT;
					break;
				}
				Student newStudent = null;
				try {
					newStudent = new Student(String.valueOf(id));
				} catch (NullPointerException | IndexOutOfBoundsException e) {
					result.response = NONEXISTENT_ID;
					break;
				}
				result.newStudent = newStudent;
				result.response = "Successfully selected " + formatter.formatInfo(newStudent);
				break;
			case 2: // Printing out Student Info
				result.response = formatter.formatInfo(selectedStudent);
				break;
			case 3: // Printing out Student Address
				result.response = formatter.formatAddress(selectedStudent.address());
				break;
			case 4: // Printing out Student Phonenumber
				result.response = formatter.formatPhoneNumber(selectedStudent.phone());
				break;
			case 5: // Printing out International Phonenumber
				result.response = formatter.formatPhoneNumberInternational(selectedStudent.phone());
				break;
			case 7: // Return to Country Selection
				FormatterManager.deleteCountry();
				setCountry(true);
				break;
			case 8: // Closes Programm
				System.exit(0);
				break;
			default:
				result.response= INVALID_INPUT;
				break;
		}

		return result;
	}

	private static void printMenu() {
		/*
		Displaying all Programm Functionalities
		*/
		System.out.println("What will you do?");
		System.out.println("[1] - Search for student by id");
		System.out.println("[2] - Display info");
		System.out.println("[3] - Display address");
		System.out.println("[4] - Display phone number");
		System.out.println("[5] - Display int'l phone number");
		System.out.println("[7] - Change Language");
		System.out.println("[8] - Exit program");

	}
}
