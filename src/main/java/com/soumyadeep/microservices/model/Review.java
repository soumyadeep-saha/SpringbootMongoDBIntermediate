package com.soumyadeep.microservices.model;

public class Review {
	
	private String userName;
	private int rating;
	private boolean approved;
	
	protected Review() {}

	public Review(String userName, int rating, boolean approved) {
		super();
		this.userName = userName;
		this.rating = rating;
		this.approved = approved;
	}

	public String getUserName() {
		return userName;
	}

	public int getRating() {
		return rating;
	}

	public boolean isApproved() {
		return approved;
	}

	@Override
	public String toString() {
		return "Review [userName=" + userName + ", rating=" + rating + ", approved=" + approved + "]";
	}
}
