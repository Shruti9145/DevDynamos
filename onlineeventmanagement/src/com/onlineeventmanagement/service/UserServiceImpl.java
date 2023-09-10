package com.onlineeventmanagement.service;

import com.onlineeventmanagement.dao.UserDAOImpl;
import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.exception.UserAlreadyExsistException;
import com.onlineeventmanagement.exception.UserLoginException;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.UserNotLoginException;

public class UserServiceImpl implements UserService {
	UserDAOImpl userDAO = new UserDAOImpl();

	@Override
	public boolean registerUser(User user) throws UserAlreadyExsistException   {
		boolean result;
		try {
			result = userDAO.userRegistration(user);
			return result;
		} catch (UserAlreadyExsistException e) {
			throw new UserAlreadyExsistException("Service: User Already exsists");
		}
		
	}

	@Override
	public boolean userLogin(String userName, String password) throws UserLoginException {
		boolean result;
		try {
			result = userDAO.userlogin(userName, password);
		} catch (UserLoginException e) {
			// TODO Auto-generated catch block
			throw new UserLoginException("Invalid Username or Password");
		}
		return result;
	}

	@Override
	public boolean userLogout(String userName) {
		boolean result = userDAO.userLogout(userName);
		return result;
	}

	@Override
	public User viewProfile(String userName) throws UserNotFoundException, UserNotLoginException {
		User user;
		try {
			user = userDAO.getInfo(userName);
			
		} catch (UserNotFoundException e) {
			throw new UserNotFoundException("Invalid user name");
		}
		return user;
	
		

	}

	@Override
	public boolean updatePassword(String userName, String newPassword) throws UserNotFoundException, UserNotLoginException {

		boolean result = userDAO.updatePassword(userName, newPassword);
		
		return result;

	}

	@Override
	public User updateAddress(String location) {
		throw new UnsupportedOperationException("Unimplemented method 'updateAddress'");
	}

	@Override
	public User updatePhoneNumber(String mobileNumber) {
		throw new UnsupportedOperationException("Unimplemented method 'updatePhoneNumber'");
	}

	@Override
	public User updateEmail(String email) {
		throw new UnsupportedOperationException("Unimplemented method 'updateEmail'");
	}

	@Override
	public void viewPackage() {
		throw new UnsupportedOperationException("Unimplemented method 'viewPackage'");
	}

	@Override
	public String selectPackage(String packageName) {
		throw new UnsupportedOperationException("Unimplemented method 'selectPackage'");
	}

	// @Override
	// public boolean createPlanRequest(PlanRequest PlanRequest) {
	// throw new UnsupportedOperationException("Unimplemented method
	// 'createPlanRequest'");
	// }

	// @Override
	// public boolean setQuatationStatus(Quatation quatation) {
	// throw new UnsupportedOperationException("Unimplemented method
	// 'setQuatationStatus'");
	// }

}
