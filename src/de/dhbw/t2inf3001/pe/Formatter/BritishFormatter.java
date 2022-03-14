package de.dhbw.t2inf3001.pe.Formatter;

import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Student;

public class BritishFormatter implements IFormatter{

    @Override
    public String formatPhoneNumber(PhoneNumber unformattedPhoneNumber) {
        StringBuilder builder = new StringBuilder();
        String seperator = " ";
        /*
            If we want to add CountryCode (Afterwards the tests need to be changed)
            builder.append(unformattedPhoneNumber.countrycode);
            builder.append(seperator);
        */
		builder.append(unformattedPhoneNumber.areaCode);
		builder.append(seperator);
		builder.append(unformattedPhoneNumber.subscriber);
		return builder.toString();
    }

    @Override
    public String formatAddress(Address unformattedAddress) {
        String newline = System.getProperty("line.separator");
		StringBuilder builder = new StringBuilder();
        builder.append(unformattedAddress.streetNumber);
		builder.append(" ");
        builder.append(unformattedAddress.street);
		builder.append(newline);
        builder.append(unformattedAddress.city);
        builder.append(newline);
        builder.append(unformattedAddress.zipCode);
        /*
            If we want to add Destination (Afterwards the tests need to be changed)
            builder.append(newline);
            builder.append(unformattedAddress.country);
        */
		return builder.toString();
    }

    @Override
    public String formatInfo(Student unformattedInfo) {
        StringBuilder builder = new StringBuilder();
		builder.append(unformattedInfo.id);
		builder.append(": ");
		builder.append(unformattedInfo.firstName);
        builder.append(" ");
        builder.append(unformattedInfo.lastName);
        return builder.toString();
    }
    
}
