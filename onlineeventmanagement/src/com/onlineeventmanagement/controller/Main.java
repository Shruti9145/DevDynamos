package com.onlineeventmanagement.controller;

import java.sql.SQLException;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.service.UserService;
import com.onlineeventmanagement.service.UserServiceImpl;
import com.onlineeventmanagement.ui.UserUI;
import com.onlineeventmanagement.ui.UserUIImpl;

public class Main {
    public static void main(String[] args) {
    	
        UserUI ui = new UserUIImpl();
        
       
        ui.showDetails("123");
        ui.updatePassword("12","Pass_123");
    }
}
