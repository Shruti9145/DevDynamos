package com.onlineeventmanagement.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.onlineeventmanagement.dao.AdminDAO;
import com.onlineeventmanagement.dao.AdminDAOImpl;
import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.VendorAlreadyExistsException;
import com.onlineeventmanagement.exception.VendorNotFoundException;

public class AdminServiceImpl implements AdminService{

    private AdminDAO adminDAO = new AdminDAOImpl();

    @Override
    public Vendor addVendor(Vendor vendor) throws VendorAlreadyExistsException {
        
        try {
            return adminDAO.saveVendor(vendor);
        } catch (SQLException e) {
            throw new VendorAlreadyExistsException("Vendor Already Exists Exception!!");
        }
    }

    @Override
    public Set<Vendor> seeAllVendor() throws VendorNotFoundException {
       
        try {
            return adminDAO.displayAllVendor();
        } catch (SQLException e) {
            throw new VendorNotFoundException("No Vendor in database");
        }
    }

    @Override
    public List<User> seeAllUser() throws UserNotFoundException {
       
        try {
            return adminDAO.displayAllUser();
        } catch (SQLException e) {
           throw new UserNotFoundException("No User in the database!!");
        }
    }

    @Override
    public boolean activateUser(User user) throws UserNotFoundException {
        
        try {
            return adminDAO.activateUserStatus(user);
        } catch (SQLException e) {
            throw new UserNotFoundException("User not found in database!!");
        }
    }

    @Override
    public boolean deactivateUser(User user) throws UserNotFoundException {
      
       try {
        return adminDAO.deactivateUserStatus(user);
    } catch (SQLException e) {
        throw new UserNotFoundException("User Not Found in Database");
    }
    }
    
}
