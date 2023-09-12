package com.onlineeventmanagement.ui;

import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.exception.UserRequestNotFoundException;
import com.onlineeventmanagement.exception.VendorNotFoundException;
import com.onlineeventmanagement.service.VendorService;
import com.onlineeventmanagement.service.VendorServiceImpl;

public class VendorUIImpl implements VendorUI{

	VendorService vendorService = new VendorServiceImpl();
	@Override
	public void addPackage() {
		// TODO Auto-generated method stub
		vendorService.createPackage();

		
	}

	@Override
	public void showUserRequest() {
		try {
			vendorService.viewUserRequest();
		}
		catch(UserRequestNotFoundException e) {
			e.getMessage();
		}
		
	}
	
	@Override
	public void addQuoatation() {
		vendorService.createQuotation();
		
	}

}
