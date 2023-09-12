package com.onlineeventmanagement.ui;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.exception.UserLoginException;
import com.onlineeventmanagement.exception.UserAlreadyExsistException;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.UserNotLoginException;
import com.onlineeventmanagement.service.UserService;
import com.onlineeventmanagement.service.UserServiceImpl;

public class UserUIImpl implements UserUI {
	UserService userService = new UserServiceImpl();
	
	@Override
	public void registration(User user) {
		boolean result;
		try {
			result = userService.registerUser(user);
			if(result) {
				System.out.println("User Registration Successfull");
			}
			else {
				System.out.println("User Registration Failed");
			}
		} catch (UserAlreadyExsistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void login(String userName, String password) {
		boolean result;
		try {
			result = userService.userLogin(userName, password);
			if(result) {
				System.out.println("User Login Successfull");
			}else {
				System.out.println("Incorrect User Name or Password");
			}
		} catch (UserLoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void logout(String userName) {
		boolean result = userService.userLogout(userName);
		if(result) {
			System.out.println("User Log out Successfull");
		}else {
			System.out.println("User Log out error");
		}
		
	}
	
	
	@Override
	public void showDetails(String userName) {
		
		 try {
			User user = userService.viewProfile(userName);
			System.out.println(user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (UserNotLoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public void updatePassword(String userName, String newPassword) {
		try {
			boolean result = userService.updatePassword(userName, newPassword);
			
			if(result) {
				System.out.println("Password Updated Successfully");
			}
			else {
				System.out.println("Password not updated");
			}
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (UserNotLoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	



	

	
}
