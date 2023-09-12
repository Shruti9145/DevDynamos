package com.onlineeventmanagement.controller;

import java.time.LocalDate;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.ui.AdminUI;
import com.onlineeventmanagement.ui.UserUI;
import com.onlineeventmanagement.ui.UserUI;

public class Main {
    public static void main(String[] args) {
    	
        UserUI ui = new UserUI();

        User user = new User("Shubhayu26", "Shubhayu" , "Password@Shubh", 
        LocalDate.of(1995, 11, 21), "9594046574", "shu@email.com", "Pune");
        
        ui.registration(user);
        
        // ui.login("Shubhayu26", "Password@123");
        // ui.updatePassword("Shubhayu26", "Password@123");
        // ui.showDetails("Shubhayu26");
        // ui.logout("Shubhayu26");
       
      
        
    }
}
