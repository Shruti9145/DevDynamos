package com.onlineeventmanagement.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Admin {
	
	//essential attributes
	private int adminId;
	private String username;
	private String fullName;
	private String password;
	private String email;
	private String mobile;
	
	private Set<Vendor> vendorList = new HashSet<>();
	
	
	
	public Set<Vendor> getVendorList() {
		return vendorList;
	}


	public void setVendorList(Set<Vendor> vendorList) {
		this.vendorList = vendorList;
	}


	public Admin() {
		//Empty Constructor
	}
	
	
	//Parameterized constructor
	public Admin(int adminId, String username, String fullName, String password, String email, String mobile) {
		
		this.adminId = adminId;
		this.username = username;
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}

	
	//getters and setters
	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

// override hashcode and equals method on adminId;
	@Override
	public int hashCode() {
		return Objects.hash(adminId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return adminId == other.adminId;
	}

//toString method to display admin info.
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", username=" + username + ", fullName=" + fullName + ", password="
				+ password + ", email=" + email + ", mobile=" + mobile + "]";
	}
	
}