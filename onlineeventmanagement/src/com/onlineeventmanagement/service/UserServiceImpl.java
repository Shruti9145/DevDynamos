package com.onlineeventmanagement.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.onlineeventmanagement.dao.PackageDAO;
import com.onlineeventmanagement.dao.PackageDAOImpl;
import com.onlineeventmanagement.dao.PlanRequestDAO;
import com.onlineeventmanagement.dao.PlanRequestDAOImpl;
import com.onlineeventmanagement.dao.QuotationDAO;
import com.onlineeventmanagement.dao.QuotationDAOImpl;
import com.onlineeventmanagement.dao.UserDAOImpl;
import com.onlineeventmanagement.domain.PackageObj;
import com.onlineeventmanagement.domain.PlanRequest;
import com.onlineeventmanagement.domain.Quotation;
import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.exception.InvalidDate;
import com.onlineeventmanagement.exception.NumberPeople;
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
	public List<PackageObj> viewPackage() throws SQLException {
		PackageDAO packageDAO = new PackageDAOImpl();
		List<PackageObj> packages = packageDAO.searchPackage();
		
		return packages;
	}

	@Override
	public PlanRequest selectPackage(int packageId, LocalDate fromDate, LocalDate toDate, int numberPeople, Set<String> otherServices, User user) throws SQLException {
		List<PackageObj> packages = viewPackage();
		
		for(PackageObj packageObj : packages)	{
			if(packageObj.getPackageId() == packageId)	{
				PlanRequestDAO planRequestDAO = new PlanRequestDAOImpl();
				try {
					PlanRequest planRequest = new PlanRequest(fromDate, toDate, packageObj.getServices(), numberPeople, otherServices, packageObj, user);
					planRequestDAO.insertPlanRequest(planRequest);
					
					return planRequest;
				} catch (SQLException | InvalidDate | NumberPeople e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	@Override
	public List<Quotation> showAllQuotations(int userId) throws SQLException, UserNotFoundException {
		QuotationDAO quotationDAO = new QuotationDAOImpl(); 
		List<Quotation> quotations = quotationDAO.searchQuotations();
		List<Quotation> quotationUser = new ArrayList<>();
		
		for(Quotation quotation : quotations)
			if(quotation.getUserId() == userId)
				quotationUser.add(quotation);
		
		return quotations;
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
