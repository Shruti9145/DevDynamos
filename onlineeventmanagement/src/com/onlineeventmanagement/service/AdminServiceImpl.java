package com.onlineeventmanagement.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.onlineeventmanagement.dao.AdminDAO;
import com.onlineeventmanagement.dao.AdminDAOImpl;
import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.exception.InvalidCredentialException;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.VendorAlreadyExistsException;
import com.onlineeventmanagement.exception.VendorNotFoundException;

public class AdminServiceImpl implements AdminService{

    // Initialize an instance of the AdminDAO for database operations
    private AdminDAO adminDAO = new AdminDAOImpl();

    @Override
    public boolean loginAdmin(String username, String password) throws InvalidCredentialException {
        try {
            // Call the DAO method to validate admin credentials
            return adminDAO.adminLogin(username, password);
        } catch (SQLException e) {
             // Handle SQL exceptions and throw custom InvalidCredentialException
           throw new InvalidCredentialException("Invalid Username/Password");
        } 
       
    }

    @Override
    public Vendor addVendor(Vendor vendor) throws VendorAlreadyExistsException {
        
        try {
            // Call the DAO method to save a new vendor
            return adminDAO.saveVendor(vendor);
        } catch (SQLException e) {
            // Handle SQL exceptions and throw custom VendorAlreadyExistsException
            throw new VendorAlreadyExistsException("Vendor Already Exists Exception!!");
        }
    }

    @Override
    public Set<Vendor> seeAllVendor() throws VendorNotFoundException {
       
        try {
            // Call the DAO method to retrieve and display all vendors
            return adminDAO.displayAllVendor();
        } catch (SQLException e) {
            // Handle SQL exceptions and throw custom VendorNotFoundException
            throw new VendorNotFoundException("No Vendor in database");
        }
    }

    @Override
    public List<User> seeAllUser() throws UserNotFoundException {
       
        try {
              // Call the DAO method to retrieve and display all users
            return adminDAO.displayAllUser();
        } catch (SQLException e) {
             // Handle SQL exceptions and throw custom UserNotFoundException
           throw new UserNotFoundException("No User in the database!!");
        }
    }

    @Override
    public boolean updateUser(User user, int status) throws UserNotFoundException {
        
        try {
             // Call the DAO method to update user status
            return adminDAO.updateUserStatus(user,status);
        } catch (SQLException e) {
              // Handle SQL exceptions and throw custom UserNotFoundException
            throw new UserNotFoundException("User not found in database!!");
        }
    }
       
}
