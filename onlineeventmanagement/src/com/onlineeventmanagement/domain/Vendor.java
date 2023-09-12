package com.onlineeventmanagement.domain;

import java.util.Objects;
import java.util.Set;

public class Vendor {
	private String name;
	private String id;
	private String address;
	private String email;
	private String contactNo;
	private Set<PackageObj> eventPackage;
	private String username;
	private String password;
	
	public Vendor() {
		// TODO Auto-generated constructor stub
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



	public Vendor(String name, String id, String address, String email, String contactNo, Set<PackageObj> eventPackage) {

		this.name = name;
		this.id = id;
		this.address = address;
		this.email = email;
		this.contactNo = contactNo;
		this.eventPackage = eventPackage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Set<PackageObj> getEventPackage() {
		return eventPackage;
	}
	public void setEventPackage(Set<PackageObj> eventPackage) {
		this.eventPackage = eventPackage;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Vendor [name=" + name + ", id=" + id + ", address=" + address + ", email=" + email + ", contactNo="
				+ contactNo + ", eventPackage=" + eventPackage + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	
	
}
