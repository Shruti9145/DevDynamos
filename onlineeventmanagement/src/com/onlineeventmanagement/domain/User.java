package com.onlineeventmanagement.domain;

import java.time.LocalDate;

public class User {
	private String userName;
	private String userId;
	private String name;
	private String password;
	private LocalDate dateOfBirth;
	private String mobileNumber;
	private String email;
	private String location;
	private boolean status = false; // By default user status is false.

	public User() {

	}

	/*
	 * Parameterized constructor for all properties except the status property. User
	 * status will be provided by Admin.
	 */
	public User(String userName, String name, String password, LocalDate dateOfBirth, String mobileNumber, String email,
			String location) {
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.location = location;
	}

	/*
	 * Getters and Setters of all the properties except for status property. Status
	 * will only have getters method. User can only get the status. User cannot set
	 * status.
	 */

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	/*
	 * User Cannot Set the status. User can only get the status. so only getter for
	 * the status property
	 */
	public boolean isStatus() {
		return status;
	}

	/* Overrided toString method */
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userId=" + userId + ", name=" + name + ", password=" + password
				+ ", dateOfBirth=" + dateOfBirth + ", mobileNumber=" + mobileNumber + ", email=" + email + ", location="
				+ location + ", status=" + status + "]";
	}

	/* Overrided equals and hashmap methods */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
