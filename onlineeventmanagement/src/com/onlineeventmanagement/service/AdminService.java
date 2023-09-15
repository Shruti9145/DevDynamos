package com.onlineeventmanagement.service;


import java.util.List;
import java.util.Set;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.exception.InvalidCredentialException;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.VendorAlreadyExistsException;
import com.onlineeventmanagement.exception.VendorNotFoundException;

public interface AdminService {
    
    //Admin Login Service
    public boolean loginAdmin(String username,String password) throws InvalidCredentialException;
    
    //adding new Vendor by admin Service
    public Vendor addVendor(Vendor vendor) throws VendorAlreadyExistsException;
    
    //displaying all the vendors Service
    public Set<Vendor> seeAllVendor() throws VendorNotFoundException;
    
    //displaying all the users Service
    public List<User> seeAllUser() throws UserNotFoundException;
    
    //updating the user status Service
    public boolean updateUser(User user, int status) throws UserNotFoundException;

    


}
