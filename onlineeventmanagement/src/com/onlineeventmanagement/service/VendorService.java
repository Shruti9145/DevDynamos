package com.onlineeventmanagement.service;

import java.util.Set;

import com.onlineeventmanagement.domain.PlanRequest;
import com.onlineeventmanagement.domain.Quotation;
import com.onlineeventmanagement.exception.CreateQuotationException;

public interface VendorService {
	public Package createPackage();
	public Set<PlanRequest> viewUserRequest();
	public Quotation createQuotation() throws CreateQuotationException;
	
}
