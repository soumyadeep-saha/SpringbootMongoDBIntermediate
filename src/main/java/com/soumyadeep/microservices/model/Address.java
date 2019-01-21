package com.soumyadeep.microservices.model;

public class Address {
	
	private String city;
	private String country;
	
	protected Address() {}
	
	public Address(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + "]";
	}
}
