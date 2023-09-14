package com.onlineeventmanagement.service;

import java.util.List;

import com.onlineeventmanagement.domain.Quotation;
import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.exception.UserLoginException;
import com.onlineeventmanagement.exception.UserNotActiveException;
import com.onlineeventmanagement.exception.UserAlreadyExsistException;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.UserNotLoginException;

public interface UserService {
	
	public boolean registerUser(User user) throws UserAlreadyExsistException;
	
	public boolean userLogin(String userName,String password) throws UserLoginException, UserNotActiveException;
	
	public boolean userLogout(String userName);
	
    /*User will get all the details from DB */
    public User viewProfile(String userId) throws UserNotFoundException, UserNotLoginException;
    
    /*User can Change Password*/
    public boolean updatePassword(String userName,String newPassword) throws UserNotFoundException, UserNotLoginException;

    /*User can Update the location in DB */
    public boolean updateAddress(User user, String location) throws UserNotFoundException, UserNotLoginException;
   
    /*User can update Phone Number in DB */
    public boolean updatePhoneNumber(User user, String mobileNumber) throws UserNotFoundException, UserNotLoginException;

    /*
     * Method viewPackage will get the package details from Package table in DB.
     * Packages will be stored by Vendor in Package table.
     */
    public void viewPackage();

    /*User will Select the package */
    public String selectPackage(String packageName);
    
    public boolean setQuotationStatus(String userName,int quotationId,String status);

	boolean updateEmail(User user, String email) throws UserNotFoundException, UserNotLoginException;

	public List<Quotation> showAllQuotations(String userName);

	


    
    
}
