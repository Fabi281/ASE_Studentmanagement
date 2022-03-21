package de.dhbw.t2inf3001.pe.FormatterTests;

import static org.junit.Assert.*;

import org.junit.Test;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.Student;
import de.dhbw.t2inf3001.pe.Formatter.USFormatter;

public class USFormatterTest {

	@Test
	public void testPhoneNumberFormat() {
		PhoneNumber phone = new PhoneNumber("123", "4567890", "US");
		USFormatter uf = new USFormatter();
		String expected = "(123) 456-7890";
		assertEquals(expected, uf.formatPhoneNumber(phone));
	}

	@Test
	public void testAddressFormat() {
		Address address = new Address("Larkspur Dr.", "455", "Baviera", "92908", "US");
		USFormatter uf = new USFormatter();
		String expected = "455 Larkspur Dr.\nBaviera, 92908".replaceAll("\\n|\\r\\n", System.getProperty("line.separator")); // To make test platform-independent
		assertEquals(expected, uf.formatAddress(address));
	}

	@Test
	public void testInfoFormat() {
		Student student = new Student("1");
		USFormatter uf = new USFormatter();
		String expected = "1: Sepp Hinterhuber";
		assertEquals(expected, uf.formatInfo(student));
	}


}
