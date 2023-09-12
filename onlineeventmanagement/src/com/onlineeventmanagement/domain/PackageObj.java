package com.onlineeventmanagement.domain;

import java.util.Objects;
import java.util.Set;

public class PackageObj {
	private int id;
	private String type;
	private Set<String> services;
	private double amount;
	
	public PackageObj() {
		// TODO Auto-generated constructor stub
	}
	public PackageObj(int id, String type, Set<String> services, double amount) {
		this.id = id;
		this.type = type;
		this.services = services;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		PackageObj other = (PackageObj) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Package [id=" + id + ", type=" + type + ", services=" + services + ", amount=" + amount + "]";
	}
}
