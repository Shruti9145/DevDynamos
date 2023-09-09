package com.onlineeventmanagement.service;

import java.sql.SQLException;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.exception.UserNotFoundException;

public interface UserService {
    /*User will get all the details from DB */
    public User viewProfile(String userId) throws UserNotFoundException;
    
    /*User can Change Password*/
    public boolean updatePassword(String userId,String newPassword) throws UserNotFoundException;

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
