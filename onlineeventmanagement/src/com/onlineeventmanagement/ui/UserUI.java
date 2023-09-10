package com.onlineeventmanagement.ui;

import com.onlineeventmanagement.domain.User;

public interface UserUI {
	
	public void registration(User user);
	
	public void login(String userName, String password);
	
	public void logout(User user);
	
    public void showDetails(User user);
    
    public void updatePassword(User user, String password);

	public void updateEmail(User user, String email);

	public void updatePhoneNumber(User user, String phoneNumber);

	public void updateAddress(User user, String address);

	
    
}
