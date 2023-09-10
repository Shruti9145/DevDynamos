package com.onlineeventmanagement.ui;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.service.UserService;
import com.onlineeventmanagement.service.UserServiceImpl;

public class UserUIImpl implements UserUI {
	UserService userService = new UserServiceImpl();
	
	@Override
	public void showDetails(String userID) {
		
		 try {
			User user = userService.viewProfile(userID);
			System.out.println(user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updatePassword(String userId, String newPassword) {
		try {
			boolean result = userService.updatePassword(userId, newPassword);
			
			if(result) {
				System.out.println("Password Updated Successfully");
			}
			else {
				System.out.println("Password not updated");
			}
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}

	}

}
