package com.onlineeventmanagement.ui;

import com.onlineeventmanagement.domain.User;

public interface UserUI {
	
	public void registration(User user);
	
	public void login(String userName, String password);
	
	public void logout(String userName);
	
    public void showDetails(String userID);
    
    public void updatePassword(String userName, String password);

	
    
}
