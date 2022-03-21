package de.dhbw.t2inf3001.pe.Formatter;

import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Student;

public abstract class GenericFormatter {

    public abstract String formatPhoneNumber(PhoneNumber unformattedPhoneNumber);

    public abstract String formatAddress(Address unformattedAddress);

    public abstract String formatInfo(Student unformattedInfo);

    public String formatPhoneNumberInternational(PhoneNumber unformattedPhoneNumber) {
        StringBuilder builder = new StringBuilder();
        builder.append("+");
        switch (unformattedPhoneNumber.country) {
            case "DE":
                builder.append("49");
                builder.append(unformattedPhoneNumber.areaCode.substring(1));
                break;
            case "GB":
                builder.append("44");
                builder.append(unformattedPhoneNumber.areaCode.substring(1));
                break;
            case "US":
                builder.append("1");
                builder.append(unformattedPhoneNumber.areaCode);
                break;
            case "FR":
                builder.append("33");
                builder.append(unformattedPhoneNumber.areaCode.substring(1));
                break;
            default:
                builder.append(unformattedPhoneNumber.country);
                builder.append(unformattedPhoneNumber.areaCode);
                break;
        }
        builder.append(unformattedPhoneNumber.subscriber);
        return builder.toString();
    }
}
