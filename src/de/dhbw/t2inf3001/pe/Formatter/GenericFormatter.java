package de.dhbw.t2inf3001.pe.Formatter;

import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Student;

public abstract class GenericFormatter {

    public abstract String formatPhoneNumber(PhoneNumber unformattedPhoneNumber);

    public abstract String formatAddress(Address unformattedAddress);

    public abstract String formatInfo(Student unformattedInfo);

    public String formatInternational(PhoneNumber unformattedPhoneNumber) {
        StringBuilder builder = new StringBuilder();
        builder.append("+");
        builder.append(unformattedPhoneNumber.country);
        builder.append(unformattedPhoneNumber.areaCode);
        return builder.toString();
    }
}
