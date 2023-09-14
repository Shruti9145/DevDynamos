package com.onlineeventmanagement.controller;

import java.time.LocalDate;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.ui.AdminUI;
import com.onlineeventmanagement.ui.UserUI;
import com.onlineeventmanagement.ui.UserUI;

public class Main {
    public static void main(String[] args) {
    	
        UserUI ui = new UserUI();

//        User user = new User("Arreb", "Arreb" , "Password@Shubh", LocalDate.of(1990, 07, 26), "9594046574", "shu@email.com", "Pune");
          User user = new User("Shruti12", "Shruti" , "Password@Shruti", LocalDate.of(1990, 07, 26), "8790987680", "shruti@email.com", "Pune");

        
//        ui.registration(user);
        
        AdminUI.adminLoginPage("devdynamos@123", "Devdynamos@111");

//        AdminUI.activateUserPage(user);
        
        
        
//        ui.login("Shruti12", "Password@Shruti");       
        ui.updatePassword(user, "Password@123");
//        ui.showDetails(user);
//        ui.updateEmail(user,"shubhayu@gmail.com");
//        ui.updatePhoneNumber(user,"9598654789");
//        ui.updateAddress(user,"Mumbai");
//        ui.logout(user);
       
      
        
    }
}
