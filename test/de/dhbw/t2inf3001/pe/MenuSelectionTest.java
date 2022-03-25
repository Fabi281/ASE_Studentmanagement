package de.dhbw.t2inf3001.pe;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class MenuSelectionTest {

	@Test
	public void testWordInput() throws Exception {

		//This should be a number not a word
		String test = "IShouldBeANumber";
		BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(test.getBytes())));

		assertThrows(NumberFormatException.class, () -> Main.readIntInput(br));
	}

	@Test
	public void testValidInput() throws Exception {

		String test = "2";
		BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(test.getBytes())));

		assertEquals(2,Main.readIntInput(br));
	}

	@Test
	public void testInvalidNumber() throws Exception {

		String expected = "Invalid input!";

		assertEquals(expected, Main.processMenuSelection(69420, null, null, null).response);
	}

	@Test
	public void testNoSelectedStudent() throws Exception {

		String expected = "No Student has been selected!";

		assertEquals(expected, Main.processMenuSelection(2, null, null, null).response);
	}

}
