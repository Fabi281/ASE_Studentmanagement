package de.dhbw.t2inf3001.pe.Formatter;

import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Student;

public interface IFormatter {

    public String formatPhoneNumber(PhoneNumber unformattedPhoneNumber);

    public String formatAddress(Address unformattedAddress);

    public String formatInfo(Student unformattedInfo);
}
