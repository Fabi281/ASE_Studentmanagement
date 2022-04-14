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

import de.dhbw.t2inf3001.pe.Formatter.FormatterManager;
import de.dhbw.t2inf3001.pe.FormatterTests.TestFormatter;
import de.dhbw.t2inf3001.pe.Menu.Menu;
import de.dhbw.t2inf3001.pe.Menu.NoLanguageSelectedMenu;
import de.dhbw.t2inf3001.pe.Menu.NoStudentSelectedMenu;

public class NoStudentMenuTest {
    @Test
    public void testTransitionToLanguageMenu() throws IOException {
        ExposedMenu.setMenu(new NoStudentSelectedMenu());
        String testInput = "7";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ExposedMenu.parseInput(br, null);
        assertTrue(ExposedMenu.getMenu() instanceof NoLanguageSelectedMenu);
    }

    @Test
    public void testInvalidStringMenuSelection() throws IOException {
        Menu.setMenu(new NoStudentSelectedMenu());
        String testInput = "ShouldBeANumber";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Menu.parseInput(br, new PrintStream(baos));
        assertEquals(Menu.INVALID_INPUT+System.lineSeparator(), new String(baos.toByteArray()));
    }

    @Test
    public void testInvalidNumberMenuSelection() throws IOException {
        Menu.setMenu(new NoStudentSelectedMenu());
        String testInput = "15";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Menu.parseInput(br, new PrintStream(baos));
        assertEquals(Menu.INVALID_INPUT+System.lineSeparator(), new String(baos.toByteArray()));
    }

    @Test
    public void testStudentSelectionStringID() throws IOException {
        Menu.setMenu(new NoStudentSelectedMenu());
        String testInput = "1\nShouldBeANumber";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Menu.parseInput(br, new PrintStream(baos));
        assertEquals("Enter ID: "+System.lineSeparator()+Menu.INVALID_INPUT+System.lineSeparator(), new String(baos.toByteArray()));
    }

    @Test
    public void testStudentSelectionNonexistentID() throws IOException {
        Menu.setMenu(new NoStudentSelectedMenu());
        String testInput = "1\n99999999";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Menu.parseInput(br, new PrintStream(baos));
        assertEquals("Enter ID: "+System.lineSeparator()+Menu.NONEXISTENT_ID+System.lineSeparator(), new String(baos.toByteArray()));
    }

    @Test
    public void testStudentSelectionCorrectID() throws IOException {
        Menu.setMenu(new NoStudentSelectedMenu());
        FormatterManager.formatter = new TestFormatter();
        String testInput = "1\n1";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Menu.parseInput(br, new PrintStream(baos));
        assertEquals("Enter ID: "+System.lineSeparator()+"Successfully selected TESTINFO"+System.lineSeparator(), new String(baos.toByteArray()));
    }
}
