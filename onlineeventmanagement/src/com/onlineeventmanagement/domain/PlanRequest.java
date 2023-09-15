package com.onlineeventmanagement.domain;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class PlanRequest {
	private int planRequestId;
	private LocalDate fromDate;
	private LocalDate toDate;
	private Set<String> services;
	private int numberPeople;
	private Set<String> otherServices;
	private PackageObj packageName;
	private User user;
	
	public PlanRequest() {}
	
	public PlanRequest(LocalDate fromDate, LocalDate toDate, Set<String> services, int numberPeople, Set<String> otherServices, PackageObj packageName, User user) {
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.services = services;
		this.numberPeople = numberPeople;
		this.otherServices = otherServices;
		this.packageName = packageName;
		this.user = user;
	}
	
	public int getPlanRequestId() {
		return planRequestId;
	}
	public void setPlanRequestId(int planRequestId) {
		this.planRequestId = planRequestId;
	}
	
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	
	public Set<String> getServices() {
		return services;
	}
	public void setServices(Set<String> services) {
		this.services = services;
	}
	
	public int getNumberPeople() {
		return numberPeople;
	}
	public void setNumberPeople(int numberPeople) {
		this.numberPeople = numberPeople;
	}
	
	public Set<String> getOtherServices() {
		return otherServices;
	}
	public void setOtherServices(Set<String> otherServices) {
		this.otherServices = otherServices;
	}
	
	public PackageObj getPackageName() {
		return packageName;
	}
	public void setPackageName(PackageObj packageName) {
		this.packageName = packageName;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(planRequestId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanRequest other = (PlanRequest) obj;
		return planRequestId == other.planRequestId;
	}

	@Override
	public String toString() {
		return "PlanRequest [planRequestId=" + planRequestId + ", fromDate=" + fromDate + ", toDate=" + toDate + ", services=" + services + ", numberPeople=" + numberPeople + ", otherServices=" + otherServices + ", packageName=" + packageName + ", user=" + user + "]";
	}
}
