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

        //Source for these Formats: https://en.wikipedia.org/wiki/Telephone_numbers_in_Germany
        switch(unformattedPhoneNumber.areaCode.length()){
            case 3:
                //For Area Code: (0xx) 
                //Use: xxxx-xxxx
                firstNumberHalf = unformattedPhoneNumber.subscriber.substring(0, 4);
                secondNumberHalf = unformattedPhoneNumber.subscriber.substring(4);
		        builder.append(seperator);
                builder.append(firstNumberHalf);
                builder.append("-");
                builder.append(secondNumberHalf);
                break;
            
            case 4:
                //For Area Code:(0xxx)
                //Use: xxxx-xxxx
                firstNumberHalf = unformattedPhoneNumber.subscriber.substring(0, 4);
                secondNumberHalf = unformattedPhoneNumber.subscriber.substring(4);
		        builder.append(seperator);
                builder.append(firstNumberHalf);
                builder.append("-");
                builder.append(secondNumberHalf);
                break;
            
            case 5:
                //For Area Code: (0xxxx)
                //Use: xxx-xxxx
                firstNumberHalf = unformattedPhoneNumber.subscriber.substring(0, 3);
                secondNumberHalf = unformattedPhoneNumber.subscriber.substring(3);
		        builder.append(seperator);
                builder.append(firstNumberHalf);
                builder.append("-");
                builder.append(secondNumberHalf);
                break;
            
            case 6:
                //For Area Code: (0xxxxx) 
                //Use: xx-xxxx
                firstNumberHalf = unformattedPhoneNumber.subscriber.substring(0, 2);
                secondNumberHalf = unformattedPhoneNumber.subscriber.substring(2);
		        builder.append(seperator);
                builder.append(firstNumberHalf);
                builder.append("-");
                builder.append(secondNumberHalf);
                break;

            default:
                //As default
                //Use: xxxx-xxxx
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