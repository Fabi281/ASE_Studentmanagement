package de.dhbw.t2inf3001.pe;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest {

	@Test
	public void testFormat() {
		Student student = new Student("1");
		String expected = "1: Sepp Hinterhuber";
		assertEquals(expected, student.info());
	}
}
