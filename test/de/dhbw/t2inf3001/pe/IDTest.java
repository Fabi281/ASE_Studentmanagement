package de.dhbw.t2inf3001.pe;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import org.junit.Test;

public class IDTest {

	@Test
	public void testWordInput() {

		//This should be a number not a word
		String test = "IShouldBeANumber";
		System.setIn(new ByteArrayInputStream(test.getBytes()));

		String expected = "Invalid input!";
		
		assertEquals(expected, Main.processMenuSelection(1, null).response);
	}

	@Test
	public void testValidInput() throws Exception {

		//This should be a valid ID: 1, 2 or 3
		 String validId = "1";
		 System.setIn(new ByteArrayInputStream(validId.getBytes()));
		 Student expectedStudent = new Student(validId);
		 String expected = "Successfully selected " + expectedStudent.info();

		 assertEquals(expected, Main.processMenuSelection(1, null).response);

	}

	@Test
	public void testInvalidInput() throws Exception {

		//This should ne a invalid ID
		 String validId = "4";
		 System.setIn(new ByteArrayInputStream(validId.getBytes()));
		 String expected = "This ID doesn't exist!";

		 assertEquals(expected, Main.processMenuSelection(1, null).response);

	}

}
