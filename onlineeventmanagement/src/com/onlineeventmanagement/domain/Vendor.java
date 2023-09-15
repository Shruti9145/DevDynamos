package com.onlineeventmanagement.domain;

import java.util.Objects;

public class Vendor {
	private int vendorId;
	private String name;
	private String address;
	private String email;
	private String contactNo;
	private String username;
	private String password;
	
	public Vendor() {}

	public Vendor(String name, String address, String email, String contactNo, String username, String password) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.contactNo = contactNo;
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int id) {
		this.vendorId = id;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(vendorId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendor other = (Vendor) obj;
		return vendorId == other.vendorId;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", name=" + name + ", address=" + address + ", email=" + email + ", contactNo=" + contactNo + ", username=" + username + ", password=" + password + "]";
	}
}
