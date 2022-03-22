package de.dhbw.t2inf3001.pe;

public class Address {
	
	public String street;
	public String streetNumber;
	public String city;
	public String zipCode;
	
	public Address(String street, String streetNumber, String city, String zipCode, String country) {
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.zipCode = zipCode;
	}
}
