package com.onlineeventmanagement.service;

import java.sql.SQLException;
import java.util.Set;

import com.onlineeventmanagement.domain.PackageObj;
import com.onlineeventmanagement.domain.PlanRequest;
import com.onlineeventmanagement.domain.Quotation;
import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.exception.UserNotFoundException;

public interface VendorService {
	public PackageObj createPackage(PackageObj packageObj) throws SQLException;
	public Set<PlanRequest> viewUserRequest(Vendor vendor) throws SQLException, UserNotFoundException;
	public String makeQuotation(PlanRequest planRequest) throws SQLException;
	
}
