package de.dhbw.t2inf3001.pe.FormatterTests;

import static org.junit.Assert.*;

import java.util.prefs.Preferences;

import org.junit.Test;
import de.dhbw.t2inf3001.pe.Formatter.Formatter;
import de.dhbw.t2inf3001.pe.Formatter.GermanFormatter;
import de.dhbw.t2inf3001.pe.Formatter.Formatter.NoLanguageSpecifiedException;
import de.dhbw.t2inf3001.pe.Formatter.Formatter.UnknownLanguageException;

public class FormatterTest {

  @Test
	public void testGetFormatterUnset() {
    runInSandbox(
      ()-> assertThrows(NoLanguageSpecifiedException.class, ()-> Formatter.loadFormatter()),
    null);
	}

  @Test
	public void testGetFormatterUnknown() {
    runInSandbox(
      ()-> assertThrows(UnknownLanguageException.class, () -> Formatter.loadFormatter()),
    "unknown");
	}


  @Test
	public void testGetFormatterDe() {
    runInSandbox(
      ()-> {
        Formatter.loadFormatter();
        assertTrue(Formatter.formatter instanceof GermanFormatter);
      },
    "de_DE");
	}

  private synchronized void runInSandbox(Runnable r, String lang) {
    String key = "ASE_studentmanagement_lang";
    String old = Preferences.userNodeForPackage(Formatter.class).get(key, null);
    try{
      setOrClearProperty(key, lang);
      r.run();
    }finally{
      setOrClearProperty(key, old);
    }
  }

  private void setOrClearProperty(String key, String value){
    if (value == null) {
      Preferences.userNodeForPackage(Formatter.class).remove(key);
    } else {
      Preferences.userNodeForPackage(Formatter.class).put(key, value);
    }
  }

}
