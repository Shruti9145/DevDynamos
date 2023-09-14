package com.onlineeventmanagement.ui;

import java.util.List;

import com.onlineeventmanagement.domain.Quotation;
import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.exception.UserLoginException;
import com.onlineeventmanagement.exception.UserNotActiveException;
import com.onlineeventmanagement.exception.UserAlreadyExsistException;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.UserNotLoginException;
import com.onlineeventmanagement.service.UserService;
import com.onlineeventmanagement.service.UserServiceImpl;

public class UserUI  {
	UserService userService = new UserServiceImpl();
	
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
		} catch (UserNotActiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void logout(User user) {
		boolean result = userService.userLogout(user.getUserName());
		if(result) {
			System.out.println("User Log out Successfull");
		}else {
			System.out.println("User Log out error");
		}
		
	}
	
	public void showDetails(User user) {
		
		 try {
			User userData = userService.viewProfile(user.getUserName());
			System.out.println(userData);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (UserNotLoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	public void updatePassword(User user, String newPassword) {
		try {
			boolean result = userService.updatePassword(user.getUserName(), newPassword);
			
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

	public void updateEmail(User user,String email) {
		try {
			boolean result = userService.updateEmail(user,email);
			if(result) {
				System.out.println("Email Updated Successfully");
			}
		}catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserNotLoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void updatePhoneNumber(User user, String phoneNumber) {
		try {
			userService.updatePhoneNumber(user,phoneNumber);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserNotLoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void updateAddress(User user, String address) {
		try {
			userService.updateAddress(user,address);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserNotLoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void showAllQuotations(String userName) {
		
		List<Quotation> quotationList = userService.showAllQuotations(userName);
		for (Quotation quotation : quotationList) {
			System.out.println(quotation);
			
		}
		
	}
	
	public void setQuotationStatus(String userName, int quotationId, String status) {
		boolean result=userService.setQuotationStatus(userName, quotationId, status);
		if(result) {
			System.out.println("User Status Updated Successfully");
		}
		else {
			System.out.println("User Status update Failed");
		}
	}
	

	



	

	
}
