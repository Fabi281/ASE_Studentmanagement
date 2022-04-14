package de.dhbw.t2inf3001.pe.Formatter;

import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Student;

public class GermanFormatter extends GenericFormatter {

    public String formatPhoneNumber (PhoneNumber unformattedPhoneNumber){
        StringBuilder builder = new StringBuilder();
        String seperator = " ";
        String firstNumberHalf;
        String secondNumberHalf;

        builder.append("(" + unformattedPhoneNumber.areaCode + ")");

        //Source for these Formats: https://de.wikipedia.org/wiki/Rufnummer
        switch(unformattedPhoneNumber.areaCode.length()){
            case 3:
                firstNumberHalf = unformattedPhoneNumber.subscriber.substring(0, 4);
                secondNumberHalf = unformattedPhoneNumber.subscriber.substring(4);
		        builder.append(seperator);
                builder.append(firstNumberHalf);
                builder.append("-");
                builder.append(secondNumberHalf);
                break;
            
            case 4:
                firstNumberHalf = unformattedPhoneNumber.subscriber.substring(0, 4);
                secondNumberHalf = unformattedPhoneNumber.subscriber.substring(4);
		        builder.append(seperator);
                builder.append(firstNumberHalf);
                builder.append("-");
                builder.append(secondNumberHalf);
                break;
            
            case 5:
                firstNumberHalf = unformattedPhoneNumber.subscriber.substring(0, 3);
                secondNumberHalf = unformattedPhoneNumber.subscriber.substring(3);
		        builder.append(seperator);
                builder.append(firstNumberHalf);
                builder.append("-");
                builder.append(secondNumberHalf);
                break;
            
            case 6:
                firstNumberHalf = unformattedPhoneNumber.subscriber.substring(0, 2);
                secondNumberHalf = unformattedPhoneNumber.subscriber.substring(2);
		        builder.append(seperator);
                builder.append(firstNumberHalf);
                builder.append("-");
                builder.append(secondNumberHalf);
                break;

            default:
                firstNumberHalf = unformattedPhoneNumber.subscriber.substring(0, 4);
                secondNumberHalf = unformattedPhoneNumber.subscriber.substring(4);
                builder.append(seperator);
                builder.append(firstNumberHalf);
                builder.append("-");
                builder.append(secondNumberHalf);
                break;

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