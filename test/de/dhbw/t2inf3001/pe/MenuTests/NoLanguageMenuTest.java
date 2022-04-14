package de.dhbw.t2inf3001.pe.MenuTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.junit.Test;

import de.dhbw.t2inf3001.pe.Menu.Menu;
import de.dhbw.t2inf3001.pe.Menu.NoLanguageSelectedMenu;
import de.dhbw.t2inf3001.pe.Menu.NoStudentSelectedMenu;

public class NoLanguageMenuTest {
    @Test
    public void testValidInput() throws IOException {
        ExposedMenu.setMenu(new NoLanguageSelectedMenu());
        String testInput = "de_DE";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ExposedMenu.parseInput(br, null);
        assertTrue(ExposedMenu.getMenu() instanceof NoStudentSelectedMenu);
    }
    @Test
    public void testInvalidInput() throws IOException {
        Menu.setMenu(new NoLanguageSelectedMenu());
        String testInput = "IShouldBeAValidCountryCode";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Menu.parseInput(br, new PrintStream(baos));
        assertEquals(Menu.INVALID_INPUT+System.lineSeparator(), new String(baos.toByteArray()));
    }
}
