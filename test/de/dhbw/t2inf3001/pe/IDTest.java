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

}
