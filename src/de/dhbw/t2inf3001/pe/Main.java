package de.dhbw.t2inf3001.pe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static final String INVALID_INPUT = "Invalid input!";
	private static final String NONEXISTENT_ID = "This ID doesn't exist!";

	static class MenuResult {
		String response = null;
		Student newStudent = null;
		boolean finished = false;
	}

	private static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to the DHBW Student Management System!");

		Student student = null;
		int action;
		MenuResult result;
		while (true) {

			printMenu();
			try{
				action = readIntInput();
			} catch (IOException | NumberFormatException e) {
				System.out.println(INVALID_INPUT);
				continue;
			}
			result = processMenuSelection(action, student);
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

	static int readIntInput() throws IOException, NumberFormatException{
		String input = cin.readLine();
		return Integer.parseInt(input);
	}

	static MenuResult processMenuSelection(int action, Student selectedStudent) {
		MenuResult result = new MenuResult();
		switch (action) {
			case 1:
				System.out.println("Enter id: ");
				int id;
				try {
					id = readIntInput();
				} catch (NumberFormatException | IOException e) {
					result.response = INVALID_INPUT;
					break;
				}
				Student newStudent = null;
				try {
					newStudent = new Student(String.valueOf(id));
				} catch (NullPointerException e) {
					result.response = NONEXISTENT_ID;
				}
				result.newStudent = newStudent;
				result.response = "Successfully selected " + newStudent.info();
				break;
			case 2:
				result.response = selectedStudent.info();
				break;
			case 3:
				result.response = selectedStudent.address();
				break;
			case 4:
				result.response = selectedStudent.phone();
				break;
			case 5:
				result.response = selectedStudent.intlPhone();
				break;
			case 8:
				System.exit(0);
				break;
			default:
				System.out.println(INVALID_INPUT);
				break;
		}

		return result;
	}

	private static void printMenu() {
		System.out.println("What will you do?");
		System.out.println("[1] - Search for student by id");
		System.out.println("[2] - Display info");
		System.out.println("[3] - Display address");
		System.out.println("[4] - Display phone number");
		System.out.println("[5] - Display int'l phone number");
		System.out.println("[8] - Exit program");

	}
}
