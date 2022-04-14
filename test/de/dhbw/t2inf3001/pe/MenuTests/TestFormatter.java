package de.dhbw.t2inf3001.pe.MenuTests;

import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Student;
import de.dhbw.t2inf3001.pe.Formatter.GenericFormatter;
/**
 * TestFormatter for testing Menu independently from Student-Data
 */
public class TestFormatter extends GenericFormatter {
        @Override
        public String formatPhoneNumber(PhoneNumber unformattedPhoneNumber) {
            return "TESTPHONE";
        }
        @Override
        public String formatAddress(Address unformattedAddress) {
            return "TESTADDRESS";
        }
        @Override
        public String formatInfo(Student unformattedInfo) {
            return "TESTINFO";
        }
}
