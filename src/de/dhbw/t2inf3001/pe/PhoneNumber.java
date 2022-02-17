package de.dhbw.t2inf3001.pe;

public class PhoneNumber {

	private String areaCode;
	private String subscriber;


	public PhoneNumber(String areaCode, String subscriber, String country) {
		this.areaCode = areaCode;
		this.subscriber = subscriber;
	}
	
	public String format() {
		StringBuilder builder = new StringBuilder();
		builder.append(areaCode);
		builder.append("-");
		builder.append(subscriber);
		return builder.toString();
	}
	
	public String formatInternational() {
		StringBuilder builder = new StringBuilder();
		builder.append("+49-");
		builder.append(areaCode.substring(1));
		builder.append("-");
		builder.append(subscriber);
		return builder.toString();
	}
	
}
