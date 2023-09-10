package com.onlineeventmanagement.dao;

import java.sql.SQLException;

import java.util.Set;

import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.exception.VendorAlreadyExistsException;

public interface AdminDAO {
    public Vendor saveVendor(Vendor vendor) throws SQLException, VendorAlreadyExistsException;
    public Set<Vendor> displayAllVendor() throws SQLException;
   //public Vendor updateVendorInfo(Vendor vendor);
   //public List<User> displayAllUser();
   //public boolean updateUserStatus(User user);


}
