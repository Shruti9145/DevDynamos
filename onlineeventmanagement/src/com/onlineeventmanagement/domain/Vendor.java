package com.onlineeventmanagement.domain;

import java.util.Objects;
import java.util.Set;

public class Vendor {
	private String name;
	private String id;
	private String address;
	private String email;
	private double contactNo;
	private Set<Package> eventPackage;
	
	public Vendor(){

	}

	public Vendor(String name, String id, String address, String email, double contactNo, Set<Package> eventPackage) {
		
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
	public double getContactNo() {
		return contactNo;
	}
	public void setContactNo(double contactNo) {
		this.contactNo = contactNo;
	}
	public Set<Package> getEventPackage() {
		return eventPackage;
	}
	public void setEventPackage(Set<Package> eventPackage) {
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
				+ contactNo + ", eventPackage=" + eventPackage + "]";
	}
	
	
	
}
