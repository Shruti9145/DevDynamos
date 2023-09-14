package com.onlineeventmanagement.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.exception.InvalidCredentialException;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.VendorAlreadyExistsException;

public interface AdminDAO {
    
    //Admin Login functionality
    public boolean adminLogin(String username, String password) throws SQLException, InvalidCredentialException;
    
    //adding new Vendor by admin
    public Vendor saveVendor(Vendor vendor) throws SQLException, VendorAlreadyExistsException;
    
    //displaying all the vendors
    public Set<Vendor> displayAllVendor() throws SQLException;
    
    //displaying all the users
    public List<User> displayAllUser() throws SQLException;
    
    //updating the user status
    public boolean updateUserStatus(User user, int status) throws SQLException, UserNotFoundException;
}
