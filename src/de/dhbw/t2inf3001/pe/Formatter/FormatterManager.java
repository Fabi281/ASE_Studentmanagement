package de.dhbw.t2inf3001.pe.Formatter;

import java.util.prefs.Preferences;

public class FormatterManager {

  private static Preferences prefs = Preferences.userNodeForPackage(FormatterManager.class);
  private static final String LANGUAGE_KEY = "ASE_studentmanagement_lang";
  
  public static GenericFormatter getFormatter(){
    String language = prefs.get(LANGUAGE_KEY, null);
    if (language == null) {
      throw new NoLanguageSpecifiedException();
    }

    switch (language) {
      case "en_US":
        return new USFormatter();
      case "de_DE":
        return new GermanFormatter();
      case "fr_FR":
        return new FrenchFormatter();
      case "en_GB":
        return new BritishFormatter();
      default:
        throw new UnknownLanguageException();
    }
  }

  public static void setCountry(String country) {
    prefs.put(LANGUAGE_KEY, country);
  }

  public static void deleteCountry(){
    System.clearProperty("ASE_studentmanagement_lang");
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

}
