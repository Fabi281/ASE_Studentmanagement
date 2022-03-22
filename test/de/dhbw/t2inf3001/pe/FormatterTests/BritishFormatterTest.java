package de.dhbw.t2inf3001.pe.FormatterTests;

import static org.junit.Assert.*;

import org.junit.Test;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.Student;
import de.dhbw.t2inf3001.pe.Formatter.BritishFormatter;

public class BritishFormatterTest {

	@Test
	public void testPhoneNumberFormat4Digit6() {
		PhoneNumber phone = new PhoneNumber("01234", "567890", "GB");
		BritishFormatter bf = new BritishFormatter();
		String expected = "01234 567 890";
		assertEquals(expected, bf.formatPhoneNumber(phone));
	}

	@Test
	public void testPhoneNumberFormat4Digit5() {
		PhoneNumber phone = new PhoneNumber("01234", "56789", "GB");
		BritishFormatter bf = new BritishFormatter();
		String expected = "01234 56 789";
		assertEquals(expected, bf.formatPhoneNumber(phone));
	}

	@Test
	public void testPhoneNumberFormat3Digit7() {
		PhoneNumber phone = new PhoneNumber("0123", "5678901", "GB");
		BritishFormatter bf = new BritishFormatter();
		String expected = "0123 567 8901";
		assertEquals(expected, bf.formatPhoneNumber(phone));
	}

	@Test
	public void testPhoneNumberFormat2Digit8() {
		PhoneNumber phone = new PhoneNumber("012", "56789012", "GB");
		BritishFormatter bf = new BritishFormatter();
		String expected = "012 5678 9012";
		assertEquals(expected, bf.formatPhoneNumber(phone));
	}

	@Test
	public void testPhoneNumberFormat5Digit5() {
		PhoneNumber phone = new PhoneNumber("012345", "67890", "GB");
		BritishFormatter bf = new BritishFormatter();
		String expected = "0123 45 67 890";
		assertEquals(expected, bf.formatPhoneNumber(phone));
	}

	@Test
	public void testPhoneNumberFormat5Digit4() {
		PhoneNumber phone = new PhoneNumber("012345", "6789", "GB");
		BritishFormatter bf = new BritishFormatter();
		String expected = "0123 45 6789";
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
