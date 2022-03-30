package de.dhbw.t2inf3001.pe.FormatterTests;

import static org.junit.Assert.*;

import org.junit.Test;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.Student;
import de.dhbw.t2inf3001.pe.Formatter.FrenchFormatter;

public class FrenchFormatterTest {

    @Test
	public void testPhoneNumberFormat3Digit5Subscriber() {
		PhoneNumber phone = new PhoneNumber("012", "12345", "FR");
		FrenchFormatter ff = new FrenchFormatter();
		String expected = "01 21 23 45";
		assertEquals(expected, ff.formatPhoneNumber(phone));
    }

    @Test
    public void testPhoneNumberFormat3Digit6Subscriber() {
		PhoneNumber phone = new PhoneNumber("012", "123456", "FR");
		FrenchFormatter ff = new FrenchFormatter();
		String expected = "01 21 23 45 6";
		assertEquals(expected, ff.formatPhoneNumber(phone));
    }

    @Test
    public void testPhoneNumberFormat3Digit7Subscriber() {
		PhoneNumber phone = new PhoneNumber("012", "1234567", "FR");
		FrenchFormatter ff = new FrenchFormatter();
		String expected = "01 21 23 45 67";
		assertEquals(expected, ff.formatPhoneNumber(phone));
    }

    @Test
	public void testPhoneNumberFormat4Digit5Subscriber() {
		PhoneNumber phone = new PhoneNumber("0123", "12345", "FR");
		FrenchFormatter ff = new FrenchFormatter();
		String expected = "01 23 12 34 5";
		assertEquals(expected, ff.formatPhoneNumber(phone));
    }

    @Test
    public void testPhoneNumberFormat4Digit6Subscriber() {
		PhoneNumber phone = new PhoneNumber("0123", "123456", "FR");
		FrenchFormatter ff = new FrenchFormatter();
		String expected = "01 23 12 34 56";
		assertEquals(expected, ff.formatPhoneNumber(phone));
    }

    @Test
    public void testPhoneNumberFormat4Digit7Subscriber() {
		PhoneNumber phone = new PhoneNumber("0123", "1234567", "FR");
		FrenchFormatter ff = new FrenchFormatter();
		String expected = "01 23 12 34 56 7";
		assertEquals(expected, ff.formatPhoneNumber(phone));
    }

    @Test
	public void testPhoneNumberFormat5Digit5Subscriber() {
		PhoneNumber phone = new PhoneNumber("01234", "12345", "FR");
		FrenchFormatter ff = new FrenchFormatter();
		String expected = "01 23 41 23 45";
		assertEquals(expected, ff.formatPhoneNumber(phone));
    }

    @Test
    public void testPhoneNumberFormat5Digit6Subscriber() {
		PhoneNumber phone = new PhoneNumber("01234", "123456", "FR");
		FrenchFormatter ff = new FrenchFormatter();
		String expected = "01 23 41 23 45 6";
		assertEquals(expected, ff.formatPhoneNumber(phone));
    }

    @Test
    public void testPhoneNumberFormat5Digit7Subscriber() {
		PhoneNumber phone = new PhoneNumber("01234", "1234567", "FR");
		FrenchFormatter ff = new FrenchFormatter();
		String expected = "01 23 41 23 45 67";
		assertEquals(expected, ff.formatPhoneNumber(phone));
    }

    @Test
	public void testPhoneNumberFormat6Digit5Subscriber() {
		PhoneNumber phone = new PhoneNumber("012345", "12345", "FR");
		FrenchFormatter ff = new FrenchFormatter();
		String expected = "01 23 45 12 34 5";
		assertEquals(expected, ff.formatPhoneNumber(phone));
    }

    @Test
    public void testPhoneNumberFormat6Digit6Subscriber() {
		PhoneNumber phone = new PhoneNumber("012345", "123456", "FR");
		FrenchFormatter ff = new FrenchFormatter();
		String expected = "01 23 45 12 34 56";
		assertEquals(expected, ff.formatPhoneNumber(phone));
    }

    @Test
    public void testPhoneNumberFormat6Digit7Subscriber() {
		PhoneNumber phone = new PhoneNumber("012345", "1234567", "FR");
		FrenchFormatter ff = new FrenchFormatter();
		String expected = "01 23 45 12 34 56 7";
		assertEquals(expected, ff.formatPhoneNumber(phone));
    }

	@Test
	public void testAddressFormat() {
		Address address = new Address("Finkenweg", "1", "Berlin", "12345", "DE");
		FrenchFormatter bf = new FrenchFormatter();
		String expected = "1 Finkenweg\n12345 Berlin".replaceAll("\\n|\\r\\n", System.getProperty("line.separator")); // To make test platform-independent
		assertEquals(expected, bf.formatAddress(address));
	}

	@Test
	public void testInfoFormat() {
		Student student = new Student("1");
		FrenchFormatter bf = new FrenchFormatter();
		String expected = "1: Sepp Hinterhuber";
		assertEquals(expected, bf.formatInfo(student));
	}
    
}
