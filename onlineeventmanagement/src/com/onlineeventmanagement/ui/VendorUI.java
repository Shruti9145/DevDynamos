package com.onlineeventmanagement.ui;

import com.onlineeventmanagement.exception.UserRequestNotFoundException;

public interface VendorUI {
	public void addPackage();
	public void showUserRequest()throws UserRequestNotFoundException;
	public void addQuoatation();
	
}
