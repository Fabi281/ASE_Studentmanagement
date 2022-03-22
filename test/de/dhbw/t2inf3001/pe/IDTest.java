package de.dhbw.t2inf3001.pe;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import org.junit.Test;

import de.dhbw.t2inf3001.pe.Formatter.TestFormatter;

public class IDTest {

	@Test
	public void testWordInput() {

			//This should be a number not a word
			String test = "IShouldBeANumber\n";
			BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(test.getBytes())));

			String expected = "Invalid input!";
			
			assertEquals(expected, Main.processMenuSelection(1, null, br, System.out).response);

	}
	@Test
	public void testInvalidInput() throws Exception {

			//This should ne a invalid ID
			String validId = "4\n";
			BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(validId.getBytes())));

			String expected = "This ID doesn't exist!";
	
			assertEquals(expected, Main.processMenuSelection(1, null, br, System.out).response);
	}

	@Test
	public void testValidInput() throws Exception {
				//This should be a valid ID: 1, 2 or 3
				String validId = "1\n";
				BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(validId.getBytes())));
				String expected = "Successfully selected ";
	
				Main.formatter = new TestFormatter();
	
				assertTrue(Main.processMenuSelection(1, null, br, System.out).response.contains(expected));

	}
}
