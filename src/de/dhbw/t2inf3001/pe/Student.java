package de.dhbw.t2inf3001.pe;

import java.util.List;

public class Student {

	public String id;
	public String firstName;
	public String lastName;
	private Address address;
	private PhoneNumber phone;

	public Student(String id) {
		readDataFromStore(id);
	}

	public Address address() {
		return address;
	}

	public PhoneNumber phone() {
		return phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	private void readDataFromStore(String id) {
		/*
		Reads the datastore.csv file and returns a List of all contents of the matching id
		0: id
		1: firstname
		2: lastname
		3: street
		4: house number
		5: location
		6: zip code
		7: Country
		8: area code
		9: number
		*/
		List<String> data = DataStore.read(id);
		this.id = id;
		firstName = data.get(1);
		lastName = data.get(2);
		address = new Address(data.get(3), data.get(4), data.get(5),
				data.get(6), data.get(7));
		phone = new PhoneNumber(data.get(8), data.get(9), data.get(7));
	}

}
