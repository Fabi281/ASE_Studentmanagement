package de.dhbw.t2inf3001.pe;

import static org.junit.Assert.*;

import org.junit.Test;

import de.dhbw.t2inf3001.pe.PhoneNumber;

public class PhoneNumberTest {

	@Test
	public void testFormat() {
		PhoneNumber phone = new PhoneNumber("01234", "56789", "DE");
		String expected = "01234-56789";
		assertEquals(expected, phone.format());
	}

	@Test
	public void testFormatInternational() {
		PhoneNumber phone = new PhoneNumber("01234", "56789", "DE");
		String expected = "+49-1234-56789";
		assertEquals(expected, phone.formatInternational());
	}

}
