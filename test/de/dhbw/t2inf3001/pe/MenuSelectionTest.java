package de.dhbw.t2inf3001.pe;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class MenuSelectionTest {

	@Test
	public void testWordInput() throws Exception {

		//This should be a number not a word
		String test = "IShouldBeANumber";
		System.setIn(new ByteArrayInputStream(test.getBytes()));

		assertThrows(NumberFormatException.class, () -> Main.readIntInput());
	}

	@Test
	public void testValidNumber() throws Exception {
		String validId = "1";
		Student student = new Student(validId);

		Main.processMenuSelection(2, student);
		String expected = student.info();
		System.out.println(expected);

		assertEquals(expected, Main.processMenuSelection(2, student).response);
	}

	@Test
	public void testInvalidNumber() throws Exception {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

		Main.processMenuSelection(69420, null);

		
		String actual = out.toString().replaceAll("\\n|\\r\\n", "");
		String expected = "Invalid input!";

		assertEquals(expected, actual);
	}

}
