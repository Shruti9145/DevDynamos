package com.onlineeventmanagement.dao;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.exception.UserAlreadyExsistException;
import com.onlineeventmanagement.exception.UserLoginException;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.UserNotLoginException;

public interface UserDAO {
	
	public boolean userRegistration(User user) throws UserAlreadyExsistException ;
	
	public boolean userlogin(String userName, String password) throws UserLoginException;
	
	public boolean userLogout(String userName);
	
	public boolean updateLogStatus(boolean status, String userName);
	
	public boolean getUserLoginStatus(String userName);
	
	public User getInfo(String userName) throws UserNotFoundException, UserNotLoginException ;
	
	public boolean updatePassword(String userName, String newPassword) throws UserNotFoundException, UserNotLoginException;


}
