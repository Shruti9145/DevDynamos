package com.onlineeventmanagement.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.VendorAlreadyExistsException;

public interface AdminDAO {
    
    public Vendor saveVendor(Vendor vendor) throws SQLException, VendorAlreadyExistsException;
    public Set<Vendor> displayAllVendor() throws SQLException;
   //public Vendor updateVendorInfo(Vendor vendor);
   //public Vendor deactivateVendor(Vendor vendor);
   //Logout functionality
   public List<User> displayAllUser() throws SQLException;
   public boolean updateUserStatus(User user, int status) throws SQLException, UserNotFoundException;
   //public boolean deactivateUserStatus(User user) throws SQLException, UserNotFoundException;


}
