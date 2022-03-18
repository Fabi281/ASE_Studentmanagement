package de.dhbw.t2inf3001.pe.Formatter;

import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Student;

public class BritishFormatter extends GenericFormatter {

    public String formatPhoneNumber(PhoneNumber unformattedPhoneNumber) {
        if(!unformattedPhoneNumber.country.equals("GB")) {
            return unformattedPhoneNumber.formatInternational();
        }

        StringBuilder builder = new StringBuilder();
        String seperator = " ";
        /*
            If we want to add CountryCode (Afterwards the tests need to be changed)
            builder.append(unformattedPhoneNumber.countrycode);
            builder.append(seperator);
        */

        //areaCode.length() always needs to be the actual length +1 because the leading 0 is incorporated
        //in the areacode in the database
        if(unformattedPhoneNumber.areaCode.length() == 6){
            builder.append(unformattedPhoneNumber.areaCode.substring(0,4));
            builder.append(seperator);
            builder.append(unformattedPhoneNumber.areaCode.substring(4));
        }else{
            builder.append(unformattedPhoneNumber.areaCode);
        }
		
		builder.append(seperator);


        //Source for these formats: https://en.wikipedia.org/wiki/Telephone_numbers_in_the_United_Kingdom
        switch(unformattedPhoneNumber.areaCode.length()){
            case 5:
                if(unformattedPhoneNumber.subscriber.length() == 6){
                    builder.append(unformattedPhoneNumber.subscriber.substring(0,3));
                    builder.append(seperator);
                    builder.append(unformattedPhoneNumber.subscriber.substring(3));
                }else{
                    builder.append(unformattedPhoneNumber.subscriber.substring(0,2));
                    builder.append(seperator);
                    builder.append(unformattedPhoneNumber.subscriber.substring(2));
                }
                break;
            case 4:
                builder.append(unformattedPhoneNumber.subscriber.substring(0,3));
                builder.append(seperator);
                builder.append(unformattedPhoneNumber.subscriber.substring(3));
                break;
            case 3:
                builder.append(unformattedPhoneNumber.subscriber.substring(0,4));
                builder.append(seperator);
                builder.append(unformattedPhoneNumber.subscriber.substring(4));
                break;
            case 6:
                if(unformattedPhoneNumber.subscriber.length() == 5){
                    builder.append(unformattedPhoneNumber.subscriber.substring(0,2));
                    builder.append(seperator);
                    builder.append(unformattedPhoneNumber.subscriber.substring(2));
                }else{
                    builder.append(unformattedPhoneNumber.subscriber);
                }
                break;
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
