package com.onlineeventmanagement.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.onlineeventmanagement.domain.Quotation;
import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.exception.UserLoginException;
import com.onlineeventmanagement.exception.VendorLoginException;

public interface VendorDAO {
	
	public boolean vendorLogin(String username, String password) throws VendorLoginException;
	public boolean vendorLogout(String userName);
	public boolean updateLogStatus(boolean status, String userName);
	
	public String insertVendor(Vendor vendor) throws SQLException;
	
	public List<Vendor> searchVendors() throws SQLException;
	
	public Vendor searchVendor(int vendorId) throws SQLException;
	
	public String deleteVendor(int vendorId) throws SQLException;
}
