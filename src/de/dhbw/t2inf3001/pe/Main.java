package de.dhbw.t2inf3001.pe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to the DHBW Student Management System!");

		String id = null;
		
		Student student = null;
		
		while (true) {

			whatWillYouDo();

			String input = cin.readLine();

			int action = 0;

			try {
				action = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input!");
				continue;
			}

			if (action == 1) {
				System.out.println("Enter id: ");
				id = cin.readLine();
				student = new Student(id);
				System.out.println("Successfully selected " + student.info());
			} else if (action == 2) {
				System.out.println(student.info());
			} else if (action == 3) {
				System.out.println(student.address());
			} else if (action == 4) {
				System.out.println(student.phone());
			} else if (action == 5) {
				System.out.println(student.intlPhone());
			} else if (action == 6) {
				System.out.println(student.info());
			} else if (action == 7) {
				System.out.println(student.info());
			} else if (action == 8) {
				break;
			}

		}

		System.out.println("Thank you for using the DHBW Student Management System :-)");

		cin.close();
	}

	private static void whatWillYouDo() {
		System.out.println("What will you do?");
		System.out.println("[1] - Search for student by id");
		System.out.println("[2] - Display info");
		System.out.println("[3] - Display address");
		System.out.println("[4] - Display phone number");
		System.out.println("[5] - Display int'l phone number");
		System.out.println("[8] - Exit program");

	}
}
