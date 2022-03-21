package de.dhbw.t2inf3001.pe.FormatterTests;

import static org.junit.Assert.*;

import org.junit.Test;
import de.dhbw.t2inf3001.pe.Formatter.FormatterManager;
import de.dhbw.t2inf3001.pe.Formatter.GenericFormatter;
import de.dhbw.t2inf3001.pe.Formatter.GermanFormatter;
import de.dhbw.t2inf3001.pe.Formatter.FormatterManager.NoLanguageSpecifiedException;
import de.dhbw.t2inf3001.pe.Formatter.FormatterManager.UnknownLanguageException;

public class FormatterManagerTest {

  @Test
	public void testGetFormatterUnset() {
    runInSandbox(
      ()-> assertThrows(NoLanguageSpecifiedException.class, ()-> FormatterManager.getFormatter()),
    null);
	}

  @Test
	public void testGetFormatterUnknown() {
    runInSandbox(
      ()-> assertThrows(UnknownLanguageException.class, () -> FormatterManager.getFormatter()),
    "unknown");
	}


  @Test
	public void testGetFormatterDe() {
    runInSandbox(
      ()-> {
        GenericFormatter gf = FormatterManager.getFormatter();
        assertTrue(gf instanceof GermanFormatter);
      },
    "de_DE");
	}

  private synchronized void runInSandbox(Runnable r, String lang) {
    String key = "ASE_studentmanagement_lang";
    String old = System.getProperty(key);
    try{
      setOrClearProperty(key, lang);
      r.run();
    }finally{
      setOrClearProperty(key, old);
    }
  }

  private void setOrClearProperty(String key, String value){
    if (value == null) {
      System.clearProperty(key);
    } else {
      System.setProperty(key, value);
    }
  }

}
