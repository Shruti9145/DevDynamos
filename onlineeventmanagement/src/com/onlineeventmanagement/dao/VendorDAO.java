package com.onlineeventmanagement.dao;

import java.util.Set;

import com.onlineeventmanagement.domain.Quotation;
import com.onlineeventmanagement.exception.UserLoginException;
import com.onlineeventmanagement.exception.VendorLoginException;

public interface VendorDAO {
	
	public boolean vendorLogin(String username, String password) throws VendorLoginException;
	public boolean vendorLogout(String userName);
	boolean updateLogStatus(boolean status, String userName);
}
