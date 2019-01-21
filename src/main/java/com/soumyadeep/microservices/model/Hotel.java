package com.soumyadeep.microservices.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Hotels")
public class Hotel {
	
	@Id
	private String id;
	private String name;
	@Indexed(direction=IndexDirection.ASCENDING)
	private int pricePerNight;
	private Address address;
	private List<Review> reviews;
	
	protected Hotel() {}

	public Hotel(String id, String name, int pricePerNight, Address address, List<Review> reviews) {
		super();
		this.id = id;
		this.name = name;
		this.pricePerNight = pricePerNight;
		this.address = address;
		this.reviews = reviews;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPricePerNight() {
		return pricePerNight;
	}

	public Address getAddress() {
		return address;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", pricePerNight=" + pricePerNight + ", address=" + address
				+ ", reviews=" + reviews + "]";
	}
}
