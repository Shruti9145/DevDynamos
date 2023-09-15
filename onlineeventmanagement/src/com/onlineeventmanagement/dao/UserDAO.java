package com.onlineeventmanagement.dao;

import java.util.List;

import com.onlineeventmanagement.domain.Quotation;
import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.exception.UserAlreadyExsistException;
import com.onlineeventmanagement.exception.UserLoginException;
import com.onlineeventmanagement.exception.UserNotActiveException;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.UserNotLoginException;

public interface UserDAO {
	
	public boolean userRegistration(User user) throws UserAlreadyExsistException ;
	
	public boolean userlogin(String userName, String password) throws UserLoginException, UserNotActiveException;
	
	public boolean userLogout(String userName);
	
	public boolean updateLogStatus(boolean status, String userName);
	
	public boolean getUserLoginStatus(String userName);
	
	public boolean getUserActiveStatus(String userName);
	
	public User getInfo(String userName) throws UserNotFoundException, UserNotLoginException ;
	
	public boolean updatePassword(String userName, String newPassword) throws UserNotFoundException, UserNotLoginException;
	
	public boolean updateEmail(User user, String email) throws UserNotFoundException, UserNotLoginException;
	
	public boolean updatePhoneNumber(User user, String mobileNumber) throws UserNotFoundException, UserNotLoginException;
	
	public boolean updateAddress(User user, String location) throws UserNotFoundException, UserNotLoginException;
	
	public User getUser(int userId) throws UserNotFoundException;
	
	public List<Quotation> getAllQuotation(String userName) throws UserNotLoginException, UserNotFoundException;
	
	public boolean setQuotationStatus(String userName,int quoatationId,String status) throws UserNotLoginException ;


}
