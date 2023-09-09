package com.onlineeventmanagement.service;

import java.sql.SQLException;

import com.onlineeventmanagement.dao.UserDAO;
import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.exception.UserNotFoundException;

public class UserServiceImpl implements UserService {
	UserDAO userDAO = new UserDAO();

	@Override
	public User viewProfile(String userId) throws UserNotFoundException {
		User user;
		user = userDAO.getInfo(userId);
		if (user.getUserId() == null) {
			throw new UserNotFoundException("UserID Invalid");
		} else {
			return user;
		}

	}

	@Override
	public boolean updatePassword(String userId, String newPassword) throws UserNotFoundException {

		boolean result = userDAO.updatePassword(userId, newPassword);
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
