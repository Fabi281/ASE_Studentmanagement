package de.dhbw.t2inf3001.pe.FormatterTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Student;
import de.dhbw.t2inf3001.pe.Formatter.GenericFormatter;

public class GenericFormatterTest {
  
	@Test
	public void testInternationalPhoneNumberFormatGB() {
		PhoneNumber phone = new PhoneNumber("01234", "567890", "GB");
		GenericFormatter gf = new GenericFormatter(){
      public String formatPhoneNumber(PhoneNumber unformattedPhoneNumber){return null;}
      public String formatAddress(Address unformattedAddress){return null;}
      public String formatInfo(Student unformattedInfo){return null;}
    };
		String expected = "+441234567890";
		assertEquals(expected, gf.formatPhoneNumberInternational(phone));
	}

  @Test
	public void testInternationalPhoneNumberFormatUS() {
		PhoneNumber phone = new PhoneNumber("123", "4567890", "US");
		GenericFormatter gf = new GenericFormatter(){
      public String formatPhoneNumber(PhoneNumber unformattedPhoneNumber){return null;}
      public String formatAddress(Address unformattedAddress){return null;}
      public String formatInfo(Student unformattedInfo){return null;}
    };
		String expected = "+11234567890";
		assertEquals(expected, gf.formatPhoneNumberInternational(phone));
	}

  @Test
	public void testInternationalPhoneNumberFormatDE() {
		PhoneNumber phone = new PhoneNumber("08633", "4567890", "DE");
		GenericFormatter gf = new GenericFormatter(){
      public String formatPhoneNumber(PhoneNumber unformattedPhoneNumber){return null;}
      public String formatAddress(Address unformattedAddress){return null;}
      public String formatInfo(Student unformattedInfo){return null;}
    };
		String expected = "+4986334567890";
		assertEquals(expected, gf.formatPhoneNumberInternational(phone));
	}

  @Test
	public void testInternationalPhoneNumberFormatFR() {
		PhoneNumber phone = new PhoneNumber("05", "12345678", "FR");
		GenericFormatter gf = new GenericFormatter(){
      public String formatPhoneNumber(PhoneNumber unformattedPhoneNumber){return null;}
      public String formatAddress(Address unformattedAddress){return null;}
      public String formatInfo(Student unformattedInfo){return null;}
    };
		String expected = "+33512345678";
		assertEquals(expected, gf.formatPhoneNumberInternational(phone));
	}

}
