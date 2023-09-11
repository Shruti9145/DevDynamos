package com.onlineeventmanagement.controller;

import java.time.LocalDate;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.ui.AdminUI;
import com.onlineeventmanagement.ui.UserUI;
import com.onlineeventmanagement.ui.UserUI;

public class Main {
    public static void main(String[] args) {
    	
        UserUI ui = new UserUI();

        User user = new User("Shubhayu26", "Shubhayu" , "Password@Shubh", null, "9594046574", "shu@email.com", "Pune");
        
        
        
        AdminUI.activateUserPage(user);
        
//        ui.registration(user);
        
//        ui.login("Shubhayu26", "Password@123");       
//        ui.updatePassword(user, "Password@123");
//        ui.showDetails(user);
//        ui.updateEmail(user,"shubhayu@gmail.com");
//        ui.updatePhoneNumber(user,"9598654789");
//        ui.updateAddress(user,"Mumbai");
//        ui.logout(user);
       
      
        
    }
}
