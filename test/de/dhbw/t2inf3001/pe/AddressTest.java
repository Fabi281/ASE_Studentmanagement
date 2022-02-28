package de.dhbw.t2inf3001.pe;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddressTest {

	@Test
	public void testFormat() {
		Address address = new Address("Finkenweg", "1", "Berlin", "12345", "DE");
		String expected = "Finkenweg 1\n12345 Berlin".replaceAll("\\n|\\r\\n", System.getProperty("line.separator")); // To make test platform-independent
		assertEquals(expected, address.format());
	}

}
