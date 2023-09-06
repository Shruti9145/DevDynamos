package com.onlineeventmanagement.service;

import java.util.Set;

public interface VendorService {
	public Package addPackage();
	public Set<PlanRequests> viewUserRequest();
	public Quotation createQuotation();
	
}
