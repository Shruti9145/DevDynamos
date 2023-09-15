package com.onlineeventmanagement.ui;

import java.sql.SQLException;
import java.util.Set;

import com.onlineeventmanagement.domain.PackageObj;
import com.onlineeventmanagement.domain.PlanRequest;
import com.onlineeventmanagement.domain.Quotation;
import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.UserRequestNotFoundException;
import com.onlineeventmanagement.service.VendorService;
import com.onlineeventmanagement.service.VendorServiceImpl;

public class VendorUI {
	VendorService vendorService = new VendorServiceImpl();
	
	public void addPackage(PackageObj packageObj)	{
		try {
			System.out.println(vendorService.createPackage(packageObj));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void showUserRequest(Vendor vendor)throws UserRequestNotFoundException	{
		try {
			Set<PlanRequest> planRequests = vendorService.viewUserRequest(vendor);
			
			for(PlanRequest planRequest : planRequests)
				System.out.println(planRequest);
		} catch (SQLException | UserNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void addQuoatation(PlanRequest planRequest)	{
		try {
			System.out.println(vendorService.makeQuotation(planRequest));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
