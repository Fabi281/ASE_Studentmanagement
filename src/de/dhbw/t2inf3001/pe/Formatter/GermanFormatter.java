package de.dhbw.t2inf3001.pe.Formatter;

import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Student;

public class GermanFormatter extends GenericFormatter {

    public String formatPhoneNumber (PhoneNumber unformattedPhoneNumber){
        if(!unformattedPhoneNumber.country.equals("DE")){
            return unformattedPhoneNumber.formatInternational();
        }

        StringBuilder builder = new StringBuilder();
        String seperator = " ";
        String firstNumberHalf;
        String secondNumberHalf;

        switch(unformattedPhoneNumber.areaCode.length()){
            case 3:
                firstNumberHalf = unformattedPhoneNumber.subscriber.substring(0, 4);
                secondNumberHalf = unformattedPhoneNumber.subscriber.substring(4);
                builder.append("(" + unformattedPhoneNumber.areaCode + ")");
		        builder.append(seperator);
                builder.append(firstNumberHalf);
                builder.append("-");
                builder.append(secondNumberHalf);
            
            case 4:
                firstNumberHalf = unformattedPhoneNumber.subscriber.substring(0, 4);
                secondNumberHalf = unformattedPhoneNumber.subscriber.substring(4);
                builder.append("(" + unformattedPhoneNumber.areaCode + ")");
		        builder.append(seperator);
                builder.append(firstNumberHalf);
                builder.append("-");
                builder.append(secondNumberHalf);
            
            case 5:
                firstNumberHalf = unformattedPhoneNumber.subscriber.substring(0, 3);
                secondNumberHalf = unformattedPhoneNumber.subscriber.substring(3);
                builder.append("(" + unformattedPhoneNumber.areaCode + ")");
		        builder.append(seperator);
                builder.append(firstNumberHalf);
                builder.append("-");
                builder.append(secondNumberHalf);
            
            case 6:
                firstNumberHalf = unformattedPhoneNumber.subscriber.substring(0, 2);
                secondNumberHalf = unformattedPhoneNumber.subscriber.substring(2);
                builder.append("(" + unformattedPhoneNumber.areaCode + ")");
		        builder.append(seperator);
                builder.append(firstNumberHalf);
                builder.append("-");
                builder.append(secondNumberHalf);

            default:
                firstNumberHalf = unformattedPhoneNumber.subscriber.substring(0, 4);
                secondNumberHalf = unformattedPhoneNumber.subscriber.substring(4);
                builder.append("(" + unformattedPhoneNumber.areaCode + ")");
                builder.append(seperator);
                builder.append(firstNumberHalf);
                builder.append("-");
                builder.append(secondNumberHalf);

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