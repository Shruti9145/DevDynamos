package com.onlineeventmanagement.service;

import java.util.ArrayList;
import java.util.List;

import com.onlineeventmanagement.dao.UserDAOImpl;
import com.onlineeventmanagement.domain.Quotation;
import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.exception.UserAlreadyExsistException;
import com.onlineeventmanagement.exception.UserLoginException;
import com.onlineeventmanagement.exception.UserNotActiveException;
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
	public boolean userLogin(String userName, String password) throws UserLoginException, UserNotActiveException {
		boolean result;
		try {
			result = userDAO.userlogin(userName, password);
		} catch (UserLoginException e) {
			// TODO Auto-generated catch block
			throw new UserLoginException("Invalid Username or Password");
		} catch (UserNotActiveException e) {
			throw new UserNotActiveException("User is not Activated by Admin");
			
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
	public boolean updateEmail(User user, String email) throws UserNotFoundException, UserNotLoginException {
		
		boolean result = userDAO.updateEmail(user, email);
		
		return result;
	}

	@Override
	public boolean updateAddress(User user,String location) throws UserNotFoundException, UserNotLoginException {
		boolean result = userDAO.updateAddress(user,location);
		return result;
	}

	@Override
	public boolean updatePhoneNumber(User user,String mobileNumber) throws UserNotFoundException, UserNotLoginException {
		boolean result = userDAO.updatePhoneNumber(user,mobileNumber);
		return result;
	}

	@Override
	public void viewPackage() {
		throw new UnsupportedOperationException("Unimplemented method 'viewPackage'");
	}

	@Override
	public String selectPackage(String packageName) {
		throw new UnsupportedOperationException("Unimplemented method 'selectPackage'");
	}

	@Override
	public List<Quotation> showAllQuotations(String userName) {
		try {
			List<Quotation> quotationList = new ArrayList<>();
			quotationList=userDAO.getAllQuotation(userName);
			return quotationList;
		} catch (UserNotLoginException | UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean setQuotationStatus(String userName, int quotationId, String status) {
		try {
			boolean result = userDAO.setQuotationStatus(userName, quotationId, status);
			return result;
		} catch (UserNotLoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	

}
