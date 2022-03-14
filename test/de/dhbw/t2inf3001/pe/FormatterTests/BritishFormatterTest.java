package de.dhbw.t2inf3001.pe.FormatterTests;

import static org.junit.Assert.*;

import org.junit.Test;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.Student;
import de.dhbw.t2inf3001.pe.Formatter.BritishFormatter;

public class BritishFormatterTest {

	@Test
	public void testPhoneNumberFormat() {
		PhoneNumber phone = new PhoneNumber("01234", "56789", "DE");
		BritishFormatter bf = new BritishFormatter();
		String expected = "01234 56789";
		assertEquals(expected, bf.formatPhoneNumber(phone));
	}

	@Test
	public void testAddressFormat() {
		Address address = new Address("Finkenweg", "1", "Berlin", "12345", "DE");
		BritishFormatter bf = new BritishFormatter();
		String expected = "1 Finkenweg\nBerlin\n12345".replaceAll("\\n|\\r\\n", System.getProperty("line.separator")); // To make test platform-independent
		assertEquals(expected, bf.formatAddress(address));
	}

	@Test
	public void testInfoFormat() {
		Student student = new Student("1");
		BritishFormatter bf = new BritishFormatter();
		String expected = "1: Sepp Hinterhuber";
		assertEquals(expected, bf.formatInfo(student));
	}


}
