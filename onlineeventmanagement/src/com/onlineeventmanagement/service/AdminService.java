package com.onlineeventmanagement.service;


import java.util.List;
import java.util.Set;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.VendorAlreadyExistsException;
import com.onlineeventmanagement.exception.VendorNotFoundException;

public interface AdminService {
    
    public Vendor addVendor(Vendor vendor) throws VendorAlreadyExistsException;
    public Set<Vendor> seeAllVendor() throws VendorNotFoundException;
    public List<User> seeAllUser() throws UserNotFoundException;

    public boolean activateUser(User user) throws UserNotFoundException;

    public boolean deactivateUser(User user) throws UserNotFoundException;





}
