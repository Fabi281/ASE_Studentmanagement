package de.dhbw.t2inf3001.pe.Formatter;

public class FormatterManager {
  
  public static GenericFormatter getFormatter(){
    String language = System.getProperty("ASE_studentmanagement_lang");
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
    System.setProperty("ASE_studentmanagement_lang", country);
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
