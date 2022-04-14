package de.dhbw.t2inf3001.pe.Formatter;

import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Student;

public class FrenchFormatter extends GenericFormatter {

    //Source for Format: https://en.wikipedia.org/wiki/Telephone_numbers_in_France
    public String formatPhoneNumber (PhoneNumber unformattedPhoneNumber){
        StringBuilder builder = new StringBuilder();
        String seperator = " ";
        String FullNumber = unformattedPhoneNumber.areaCode + unformattedPhoneNumber.subscriber;
        String splitNumber = FullNumber.substring(0, 2);
        String remainingNumber = FullNumber.substring(2);
        builder.append(splitNumber); 

        while (remainingNumber.length() >= 2){
            splitNumber = remainingNumber.substring(0, 2);
            remainingNumber = remainingNumber.substring(2);
            builder.append(seperator);
            builder.append(splitNumber);
        }
        if(remainingNumber.length() > 0) {
            builder.append(seperator);
            builder.append(remainingNumber);
        }
		
		return builder.toString();

    }

    public String formatAddress(Address unformattedAddress) {
        String newline = System.getProperty("line.separator");
		StringBuilder builder = new StringBuilder();
    
        builder.append(unformattedAddress.streetNumber);
        builder.append(" ");
        builder.append(unformattedAddress.street);
		builder.append(newline);
        builder.append(unformattedAddress.zipCode);
        builder.append(" ");
        builder.append(unformattedAddress.city);
        

		return builder.toString();
    }

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