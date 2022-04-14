package de.dhbw.t2inf3001.pe.FormatterTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.dhbw.t2inf3001.pe.PhoneNumber;

public class GenericFormatterTest {
  
	@Test
	public void testInternationalPhoneNumberFormatGB() {
		PhoneNumber phone = new PhoneNumber("01234", "567890", "GB");
		TestFormatter tf = new TestFormatter();

		String expected = "+441234567890";
		assertEquals(expected, tf.formatPhoneNumberInternational(phone));
	}

  @Test
	public void testInternationalPhoneNumberFormatUS() {
		PhoneNumber phone = new PhoneNumber("123", "4567890", "US");
		TestFormatter tf = new TestFormatter();

		String expected = "+11234567890";
		assertEquals(expected, tf.formatPhoneNumberInternational(phone));
	}

  @Test
	public void testInternationalPhoneNumberFormatDE() {
		PhoneNumber phone = new PhoneNumber("08633", "4567890", "DE");
		TestFormatter tf = new TestFormatter();

		String expected = "+4986334567890";
		assertEquals(expected, tf.formatPhoneNumberInternational(phone));
	}

  @Test
	public void testInternationalPhoneNumberFormatFR() {
		PhoneNumber phone = new PhoneNumber("05", "12345678", "FR");
		TestFormatter tf = new TestFormatter();

		String expected = "+33512345678";
		assertEquals(expected, tf.formatPhoneNumberInternational(phone));
	}

}
