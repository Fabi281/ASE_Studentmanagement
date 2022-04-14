package de.dhbw.t2inf3001.pe.Formatter;

import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Student;

public class USFormatter extends GenericFormatter {

    //Source for Format: https://support.twilio.com/hc/en-us/articles/223183008-Formatting-International-Phone-Numbers
    public String formatPhoneNumber(PhoneNumber unformattedPhoneNumber) {
        //For Area Code: (xxx) 
        //Use: xxx-xxxx
        StringBuilder builder = new StringBuilder();
		builder.append("(");
		builder.append(unformattedPhoneNumber.areaCode);
		builder.append(") ");
		builder.append(unformattedPhoneNumber.subscriber.substring(0, 3));
		builder.append("-");
		builder.append(unformattedPhoneNumber.subscriber.substring(3));
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
        builder.append(", ");
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
