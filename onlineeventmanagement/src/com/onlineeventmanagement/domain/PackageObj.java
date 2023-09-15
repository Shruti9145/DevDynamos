package com.onlineeventmanagement.domain;

import java.util.Objects;
import java.util.Set;

public class PackageObj {
	private int packageId;
	private String type;
	private Set<String> services;
	private double amount;
	private Vendor vendor;
	
	public PackageObj() {}
	
	public PackageObj(String type, Set<String> services, double amount, Vendor vendor) {
		this.type = type;
		this.services = services;
		this.amount = amount;
		this.vendor = vendor;
	}

	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Set<String> getServices() {
		return services;
	}
	public void setServices(Set<String> services) {
		this.services = services;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(packageId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PackageObj other = (PackageObj) obj;
		return packageId == other.packageId;
	}

	@Override
	public String toString() {
		return "PackageObj [packageId=" + packageId + ", type=" + type + ", services=" + services + ", amount=" + amount + ", vendor=" + vendor + "]";
	}
}
