package com.onlineeventmanagement.service;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.exception.UserLoginException;
import com.onlineeventmanagement.exception.UserAlreadyExsistException;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.UserNotLoginException;

public interface UserService {
	
	public boolean registerUser(User user) throws UserAlreadyExsistException;
	
	public boolean userLogin(String userName,String password) throws UserLoginException;
	
	public boolean userLogout(String userName);
	
    /*User will get all the details from DB */
    public User viewProfile(String userId) throws UserNotFoundException, UserNotLoginException;
    
    /*User can Change Password*/
    public boolean updatePassword(String userName,String newPassword) throws UserNotFoundException, UserNotLoginException;

    /*User can Update the location in DB */
    public User updateAddress(String location);
   
    /*User can update Phone Number in DB */
    public User updatePhoneNumber(String mobileNumber);

    /*User can update Email in DB */
    public User updateEmail(String email);


    /*
     * Method viewPackage will get the package details from Package table in DB.
     * Packages will be stored by Vendor in Package table.
     */
    public void viewPackage();

    /*User will Select the package */
    public String selectPackage(String packageName);
    /*
     * createPlanRequest will take object of PlanRequest class.
     * It uses setters of PlanRequest class to generate a plan request which will be stored in PlanRequest table in DB
     * View PlanRequest of Vendor can view the request from DB.
     */
    // public boolean createPlanRequest(PlanRequest PlanRequest); 
    /*
     * vendor Provides a quatation 
     * User sets the quatation to accept or reject.
     */
    // public boolean setQuatationStatus(Quatation quatation);

	


    
    
}
