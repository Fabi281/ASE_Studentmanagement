package de.dhbw.t2inf3001.pe.Formatter;

import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Student;

public class FrenchFormatter extends GenericFormatter {

    public String formatPhoneNumber (PhoneNumber unformattedPhoneNumber){
        if(!unformattedPhoneNumber.country.equals("FR")){
            return unformattedPhoneNumber.formatInternational();
        }

        StringBuilder builder = new StringBuilder();
        String seperator = " ";
        String FullNumber = unformattedPhoneNumber.areaCode + unformattedPhoneNumber.subscriber;
        String splitNumber = FullNumber.substring(0, 2);
        String remainingNumber = FullNumber.substring(2);
        builder.append(splitNumber); 

        while (remainingNumber.length() > 2){
            splitNumber = remainingNumber.substring(0, 2);
            remainingNumber = remainingNumber.substring(2);
            builder.append(seperator);
            builder.append(splitNumber);

        }
		
		return builder.toString();

    }

    public String formatAddress(Address unformattedAddress) {
        String newline = System.getProperty("line.separator");
		StringBuilder builder = new StringBuilder();
    
        builder.append(unformattedAddress.street);
        builder.append(" ");
        builder.append(unformattedAddress.streetNumber);
		builder.append(newline);
        builder.append(unformattedAddress.city);
        builder.append(newline);
        builder.append(unformattedAddress.zipCode);

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