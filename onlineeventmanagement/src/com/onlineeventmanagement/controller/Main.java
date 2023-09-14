package com.onlineeventmanagement.controller;


import java.time.LocalDate;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.ui.AdminUI;
import com.onlineeventmanagement.ui.UserUI;


public class Main {
    public static void main(String[] args) {
    	
        UserUI ui = new UserUI();

         User user = new User("Shruti12", "Shruti" , "Password@Shruti", LocalDate.of(1990, 07, 26), "8790987680", "shruti@email.com", "Pune");

        
         ui.registration(user);
                
      // Admin Functionalities
         AdminUI.seeAllUserPage();
         AdminUI.seeAllVendorPage();
         AdminUI.adminLoginPage("devdynamos@123", "Devdynamos@111");
         AdminUI.updateUserPage(user,"activate");
         AdminUI.addVendorPage(new Vendor());
         
        
        
        
        ui.login("Shubhayu26", "Password@123");   
        ui.showAllQuotations("Shubhayu26");
        ui.setQuotationStatus("Shubhayu26",5,"accept");
//        ui.updatePassword(user, "Password@123");
//        ui.showDetails(user);
//        ui.updateEmail(user,"shubhayu@gmail.com");
//        ui.updatePhoneNumber(user,"9598654789");
//        ui.updateAddress(user,"Mumbai");
//        ui.logout(user);
       
      
        
    }
}
