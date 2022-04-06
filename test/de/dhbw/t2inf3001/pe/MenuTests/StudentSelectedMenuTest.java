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

import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Student;
import de.dhbw.t2inf3001.pe.Formatter.Formatter;
import de.dhbw.t2inf3001.pe.FormatterTests.TestFormatter;
import de.dhbw.t2inf3001.pe.Menu.Menu;
import de.dhbw.t2inf3001.pe.Menu.NoLanguageSelectedMenu;
import de.dhbw.t2inf3001.pe.Menu.StudentSelectedMenu;

public class StudentSelectedMenuTest {
    @Test
    public void testTransitionToLanguageMenu() throws IOException {
        ExposedMenu.setMenu(new StudentSelectedMenu(new Student("1")));
        String testInput = "7";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ExposedMenu.parseInput(br, null);
        assertTrue(ExposedMenu.getMenu() instanceof NoLanguageSelectedMenu);
    }

    @Test
    public void testInvalidStringMenuSelection() throws IOException {
        Menu.setMenu(new StudentSelectedMenu(new Student("1")));
        String testInput = "ShouldBeANumber";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Menu.parseInput(br, new PrintStream(baos));
        assertEquals(Menu.INVALID_INPUT+System.lineSeparator(), new String(baos.toByteArray()));
    }

    @Test
    public void testInvalidNumberMenuSelection() throws IOException {
        Menu.setMenu(new StudentSelectedMenu(new Student("1")));
        String testInput = "15";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Menu.parseInput(br, new PrintStream(baos));
        assertEquals(Menu.INVALID_INPUT+System.lineSeparator(), new String(baos.toByteArray()));
    }

    @Test
    public void testStudentSelectionStringID() throws IOException {
        Menu.setMenu(new StudentSelectedMenu(new Student("1")));
        String testInput = "1\nShouldBeANumber";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Menu.parseInput(br, new PrintStream(baos));
        assertEquals("Enter ID: "+System.lineSeparator()+Menu.INVALID_INPUT+System.lineSeparator(), new String(baos.toByteArray()));
    }

    @Test
    public void testStudentSelectionNonexistentID() throws IOException {
        Menu.setMenu(new StudentSelectedMenu(new Student("1")));
        String testInput = "1\n99999999";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Menu.parseInput(br, new PrintStream(baos));
        assertEquals("Enter ID: "+System.lineSeparator()+Menu.NONEXISTENT_ID+System.lineSeparator(), new String(baos.toByteArray()));
    }

    @Test
    public void testStudentSelectionCorrectID() throws IOException {
        Menu.setMenu(new StudentSelectedMenu(new Student("1")));
        Formatter.formatter = new TestFormatter();
        String testInput = "1\n1";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Menu.parseInput(br, new PrintStream(baos));
        assertEquals("Enter ID: "+System.lineSeparator()+"Successfully selected TESTINFO"+System.lineSeparator(), new String(baos.toByteArray()));
    }

    @Test
    public void testFormatInfo() throws IOException {
        Menu.setMenu(new StudentSelectedMenu(new Student("1")));
        Formatter.formatter = new TestFormatter();
        String testInput = "2";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Menu.parseInput(br, new PrintStream(baos));
        assertEquals("TESTINFO"+System.lineSeparator(), new String(baos.toByteArray()));
    }

    @Test
    public void testFormatAddress() throws IOException {
        Menu.setMenu(new StudentSelectedMenu(new Student("1")));
        Formatter.formatter = new TestFormatter();
        String testInput = "3";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Menu.parseInput(br, new PrintStream(baos));
        assertEquals("TESTADDRESS"+System.lineSeparator(), new String(baos.toByteArray()));
    }

    @Test
    public void testFormatPhone() throws IOException {
        Menu.setMenu(new StudentSelectedMenu(new Student("1")));
        Formatter.formatter = new TestFormatter();
        String testInput = "4";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Menu.parseInput(br, new PrintStream(baos));
        assertEquals("TESTPHONE"+System.lineSeparator(), new String(baos.toByteArray()));
    }

    @Test
    public void testFormatPhoneIntl() throws IOException {
        Menu.setMenu(new StudentSelectedMenu(new Student("1")));
        Formatter.formatter = new TestFormatter(){
            @Override
            public String formatPhoneNumberInternational(PhoneNumber unformattedPhoneNumber) {
                return "TESTPHONEINT";
            }
        };
        String testInput = "5";
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testInput.getBytes())));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Menu.parseInput(br, new PrintStream(baos));
        assertEquals("TESTPHONEINT"+System.lineSeparator(), new String(baos.toByteArray()));
    }
}
