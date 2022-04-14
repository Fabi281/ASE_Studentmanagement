package de.dhbw.t2inf3001.pe.Formatter;

import java.util.prefs.Preferences;

import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Student;

public class FormatterManager{

  private static Preferences prefs = Preferences.userNodeForPackage(FormatterManager.class);
  private static final String LANGUAGE_KEY = "ASE_studentmanagement_lang";
  public static GenericFormatter formatter;
  
  public static void loadFormatter(){
    String language = prefs.get(LANGUAGE_KEY, null);
    if (language == null) {
      throw new NoLanguageSpecifiedException();
    }
    
    switch (language) {
      case "en_US":
        formatter = new USFormatter();
        break;
      case "de_DE":
        formatter = new GermanFormatter();
        break;
      case "fr_FR":
        formatter = new FrenchFormatter();
        break;
      case "en_GB":
        formatter = new BritishFormatter();
        break;
      default:
        throw new UnknownLanguageException();
    }
  }

  public static void setCountry(String country) {
    prefs.put(LANGUAGE_KEY, country);
    loadFormatter();
  }

  public static class NoLanguageSpecifiedException extends RuntimeException {
    public NoLanguageSpecifiedException() {
      super("No language specified");
    }
  }

  public static class UnknownLanguageException extends RuntimeException {
    public UnknownLanguageException() {
      super("Language not supported");
    }
  }

  public static String formatPhoneNumber(PhoneNumber unformattedPhoneNumber) {
    return formatter.formatPhoneNumber(unformattedPhoneNumber);
  }

  public static String formatAddress(Address unformattedAddress) {
    return formatter.formatAddress(unformattedAddress);
  }

  public static String formatInfo(Student unformattedInfo) {
    return formatter.formatInfo(unformattedInfo);
  }

  public static String formatPhoneNumberInternational(PhoneNumber unformattedPhoneNumber) {
    return formatter.formatPhoneNumberInternational(unformattedPhoneNumber);
  }

}
