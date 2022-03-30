package de.dhbw.t2inf3001.pe.FormatterTests;

import static org.junit.Assert.*;

import org.junit.Test;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.Student;
import de.dhbw.t2inf3001.pe.Formatter.GermanFormatter;

public class GermanFormatterTest {

    @Test
	public void testPhoneNumberFormat3Digit5Subscriber() {
		PhoneNumber phone = new PhoneNumber("012", "12345", "DE");
		GermanFormatter gf = new GermanFormatter();
		String expected = "(012) 1234-5";
		assertEquals(expected, gf.formatPhoneNumber(phone));
    }

    @Test
    public void testPhoneNumberFormat3Digit6Subscriber() {
		PhoneNumber phone = new PhoneNumber("012", "123456", "DE");
		GermanFormatter gf = new GermanFormatter();
		String expected = "(012) 1234-56";
		assertEquals(expected, gf.formatPhoneNumber(phone));
    }

    @Test
    public void testPhoneNumberFormat3Digit7Subscriber() {
		PhoneNumber phone = new PhoneNumber("012", "1234567", "DE");
		GermanFormatter gf = new GermanFormatter();
		String expected = "(012) 1234-567";
		assertEquals(expected, gf.formatPhoneNumber(phone));
    }

    @Test
	public void testPhoneNumberFormat4Digit5Subscriber() {
		PhoneNumber phone = new PhoneNumber("0123", "12345", "DE");
		GermanFormatter gf = new GermanFormatter();
		String expected = "(0123) 1234-5";
		assertEquals(expected, gf.formatPhoneNumber(phone));
    }

    @Test
    public void testPhoneNumberFormat4Digit6Subscriber() {
		PhoneNumber phone = new PhoneNumber("0123", "123456", "DE");
		GermanFormatter gf = new GermanFormatter();
		String expected = "(0123) 1234-56";
		assertEquals(expected, gf.formatPhoneNumber(phone));
    }

    @Test
    public void testPhoneNumberFormat4Digit7Subscriber() {
		PhoneNumber phone = new PhoneNumber("0123", "1234567", "DE");
		GermanFormatter gf = new GermanFormatter();
		String expected = "(0123) 1234-567";
		assertEquals(expected, gf.formatPhoneNumber(phone));
    }

    @Test
	public void testPhoneNumberFormat5Digit5Subscriber() {
		PhoneNumber phone = new PhoneNumber("01234", "12345", "DE");
		GermanFormatter gf = new GermanFormatter();
		String expected = "(01234) 123-45";
		assertEquals(expected, gf.formatPhoneNumber(phone));
    }

    @Test
    public void testPhoneNumberFormat5Digit6Subscriber() {
		PhoneNumber phone = new PhoneNumber("01234", "123456", "DE");
		GermanFormatter gf = new GermanFormatter();
		String expected = "(01234) 123-456";
		assertEquals(expected, gf.formatPhoneNumber(phone));
    }

    @Test
    public void testPhoneNumberFormat5Digit7Subscriber() {
		PhoneNumber phone = new PhoneNumber("01234", "1234567", "DE");
		GermanFormatter gf = new GermanFormatter();
		String expected = "(01234) 123-4567";
		assertEquals(expected, gf.formatPhoneNumber(phone));
    }

    @Test
	public void testPhoneNumberFormat6Digit5Subscriber() {
		PhoneNumber phone = new PhoneNumber("012345", "12345", "DE");
		GermanFormatter gf = new GermanFormatter();
		String expected = "(012345) 12-345";
		assertEquals(expected, gf.formatPhoneNumber(phone));
    }

    @Test
    public void testPhoneNumberFormat6Digit6Subscriber() {
		PhoneNumber phone = new PhoneNumber("012345", "123456", "DE");
		GermanFormatter gf = new GermanFormatter();
		String expected = "(012345) 12-3456";
		assertEquals(expected, gf.formatPhoneNumber(phone));
    }

    @Test
    public void testPhoneNumberFormat6Digit7Subscriber() {
		PhoneNumber phone = new PhoneNumber("012345", "1234567", "DE");
		GermanFormatter gf = new GermanFormatter();
		String expected = "(012345) 12-34567";
		assertEquals(expected, gf.formatPhoneNumber(phone));
    }

	@Test
	public void testAddressFormat() {
		Address address = new Address("Finkenweg", "1", "Berlin", "12345", "DE");
		GermanFormatter bf = new GermanFormatter();
		String expected = "Finkenweg 1\n12345 Berlin".replaceAll("\\n|\\r\\n", System.getProperty("line.separator")); // To make test platform-independent
		assertEquals(expected, bf.formatAddress(address));
	}

	@Test
	public void testInfoFormat() {
		Student student = new Student("1");
		GermanFormatter bf = new GermanFormatter();
		String expected = "1: Sepp Hinterhuber";
		assertEquals(expected, bf.formatInfo(student));
	}
    
}
