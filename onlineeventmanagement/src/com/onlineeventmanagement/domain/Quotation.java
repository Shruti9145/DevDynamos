package com.onlineeventmanagement.domain;

import java.util.Objects;

public class Quotation {
	private int id;
	private double estimatedAmmount;
	private Vendor vendor;
	private User user;
	private PlanRequest planRequest;
	private String status;
	private String statusAfterQuotation;
	public Quotation(int id, double estimatedAmmount, Vendor vendor, User user, PlanRequest planRequest, String status,
			String statusAfterQuotation) {
		super();
		this.id = id;
		this.estimatedAmmount = estimatedAmmount;
		this.vendor = vendor;
		this.user = user;
		this.planRequest = planRequest;
		this.status = "pending";
		this.statusAfterQuotation = statusAfterQuotation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getEstimatedAmmount() {
		return estimatedAmmount;
	}
	public void setEstimatedAmmount(double estimatedAmmount) {
		this.estimatedAmmount = estimatedAmmount;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public PlanRequest getPlanRequest() {
		return planRequest;
	}
	public void setPlanRequest(PlanRequest planRequest) {
		this.planRequest = planRequest;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusAfterQuotation() {
		return statusAfterQuotation;
	}
	public void setStatusAfterQuotation(String statusAfterQuotation) {
		this.statusAfterQuotation = statusAfterQuotation;
	}
	@Override
	public String toString() {
		return "Quotation [id=" + id + ", estimatedAmmount=" + estimatedAmmount + ", vendor=" + vendor + ", user="
				+ user + ", planRequest=" + planRequest + ", status=" + status + ", statusAfterQuotation="
				+ statusAfterQuotation + "]";
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
		Quotation other = (Quotation) obj;
		return id == other.id;
	}
	
	
	
	
	

}
