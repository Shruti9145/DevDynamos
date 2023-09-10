package com.onlineeventmanagement.ui;

import com.onlineeventmanagement.service.VendorService;
import com.onlineeventmanagement.service.VendorServiceImpl;

public class VendorUIImpl implements VendorUI{

	VendorService vs = new VendorServiceImpl();
	@Override
	public void addPackage() {
		// TODO Auto-generated method stub
		vs.createPackage();
		
	}

	@Override
	public void showUserRequest() {
		// TODO Auto-generated method stub
		vs.viewUserRequest();
		
	}
	
	@Override
	public void addQuoatation() {
		vs.createQuotation();
		
	}

}
