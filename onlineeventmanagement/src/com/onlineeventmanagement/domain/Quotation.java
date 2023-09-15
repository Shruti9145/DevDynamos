package com.onlineeventmanagement.domain;

import java.util.Objects;

public class Quotation {
	private int quotationId;
	private double estimatedAmmount;
	private Vendor vendor;
	private User user;
	private PlanRequest planRequest;
	private String status="pending";
	private int vendorId;
	private int userId;
	private int planRequestId;
	
	
	public Quotation(double estimatedAmmount, Vendor vendor, User user, PlanRequest planRequest, String status) {
		
		this.estimatedAmmount = estimatedAmmount;
		this.vendor = vendor;
		this.user = user;
		this.planRequest = planRequest;
		this.status = status;
	}
	

public Quotation() {
	// TODO Auto-generated constructor stub
}
	public int getQuotationId() {
		return quotationId;
	}
	public void setQuotationId(int quotationId) {
		this.quotationId = quotationId;
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
	
	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPlanRequestId() {
		return planRequestId;
	}

	public void setPlanRequestId(int planRequestId) {
		this.planRequestId = planRequestId;
	}


	@Override
	public int hashCode() {
		return Objects.hash(quotationId);
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
		return quotationId == other.quotationId;
	}


	@Override
	public String toString() {
		return "Quotation [quotationId=" + quotationId + ", estimatedAmmount=" + estimatedAmmount + ", vendor=" + vendor
				+ ", user=" + user + ", planRequest=" + planRequest + ", status=" + status + ", vendorId=" + vendorId
				+ ", userId=" + userId + ", planRequestId=" + planRequestId + "]";
	}
}
