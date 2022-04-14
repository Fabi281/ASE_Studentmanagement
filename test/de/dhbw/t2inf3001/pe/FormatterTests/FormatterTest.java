package de.dhbw.t2inf3001.pe.FormatterTests;

import static org.junit.Assert.*;

import java.util.prefs.Preferences;

import org.junit.Test;
import de.dhbw.t2inf3001.pe.Formatter.FormatterManager;
import de.dhbw.t2inf3001.pe.Formatter.GermanFormatter;
import de.dhbw.t2inf3001.pe.Formatter.FormatterManager.NoLanguageSpecifiedException;
import de.dhbw.t2inf3001.pe.Formatter.FormatterManager.UnknownLanguageException;

public class FormatterTest {

  @Test
	public void testGetFormatterUnset() {
    runInSandbox(
      ()-> assertThrows(NoLanguageSpecifiedException.class, ()-> FormatterManager.loadFormatter()),
    null);
	}

  @Test
	public void testGetFormatterUnknown() {
    runInSandbox(
      ()-> assertThrows(UnknownLanguageException.class, () -> FormatterManager.loadFormatter()),
    "unknown");
	}


  @Test
	public void testGetFormatterDe() {
    runInSandbox(
      ()-> {
        FormatterManager.loadFormatter();
        assertTrue(FormatterManager.formatter instanceof GermanFormatter);
      },
    "de_DE");
	}

  private synchronized void runInSandbox(Runnable r, String lang) {
    String key = "ASE_studentmanagement_lang";
    String old = Preferences.userNodeForPackage(FormatterManager.class).get(key, null);
    try{
      setOrClearProperty(key, lang);
      r.run();
    }finally{
      setOrClearProperty(key, old);
    }
  }

  private void setOrClearProperty(String key, String value){
    if (value == null) {
      Preferences.userNodeForPackage(FormatterManager.class).remove(key);
    } else {
      Preferences.userNodeForPackage(FormatterManager.class).put(key, value);
    }
  }

}
