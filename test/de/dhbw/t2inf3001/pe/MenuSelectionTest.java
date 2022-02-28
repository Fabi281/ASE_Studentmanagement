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
	public void testInvalidNumber() throws Exception {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

		Main.processMenuSelection(69420, null);

		
		String actual = out.toString();
		String expected = "Invalid input!";

		boolean test = actual.contains(expected);
		assertTrue(test);
	}
}
