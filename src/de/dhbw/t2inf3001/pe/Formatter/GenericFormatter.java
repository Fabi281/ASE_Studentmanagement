package de.dhbw.t2inf3001.pe.Formatter;

import java.util.HashMap;
import java.util.Map;

import de.dhbw.t2inf3001.pe.Address;
import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Student;

public abstract class GenericFormatter {

    public abstract String formatPhoneNumber(PhoneNumber unformattedPhoneNumber);

    public abstract String formatAddress(Address unformattedAddress);

    public abstract String formatInfo(Student unformattedInfo);

    private static class CountryInfo {
        public String countryCode;
        public int cutoff;
        public CountryInfo(String countryCode, int cutoff) {
            this.countryCode = countryCode;
            this.cutoff = cutoff;
        }
    }
    private static final Map<String, CountryInfo> COUNTRY_INFO_MAP = new HashMap<String, CountryInfo>() {{
        put("DE", new CountryInfo("49", 1));
        put("GB", new CountryInfo("44", 1));
        put("US", new CountryInfo("1", 0));
        put("FR", new CountryInfo("33", 1));
    }};

    public String formatPhoneNumberInternational(PhoneNumber unformattedPhoneNumber) {
        StringBuilder builder = new StringBuilder();
        builder.append("+");
        CountryInfo countryInfo = COUNTRY_INFO_MAP.get(unformattedPhoneNumber.country);
        if(countryInfo != null) {
            builder.append(countryInfo.countryCode);
            builder.append(unformattedPhoneNumber.areaCode.substring(countryInfo.cutoff));
        } else {
            builder.append(unformattedPhoneNumber.country);
            builder.append(unformattedPhoneNumber.areaCode);
        }
        builder.append(unformattedPhoneNumber.subscriber);
        return builder.toString();
    }
}
