package com.onlineeventmanagement.service;

import java.util.Set;

import com.onlineeventmanagement.domain.PlanRequest;

public interface VendorService {
	public Package createPackage();
	public Set<PlanRequest> viewUserRequest();
	public Quotation createQuotation();
	
}
