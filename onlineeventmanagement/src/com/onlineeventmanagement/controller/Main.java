package com.onlineeventmanagement.controller;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.onlineeventmanagement.domain.PackageObj;
import com.onlineeventmanagement.domain.PlanRequest;
import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.ui.AdminUI;
import com.onlineeventmanagement.ui.UserUI;
import com.onlineeventmanagement.ui.VendorUI;


public class Main {
    public static void main(String[] args) {
    	
        UserUI ui = new UserUI();
        VendorUI vi = new VendorUI();

         User user = new User("Shruti12", "Shruti" , "Password@Shruti", LocalDate.of(1990, 07, 26), "8790987680", "shruti@email.com", "Pune");
         Vendor vendor = new Vendor("Dhawal", "Mumbai", "d@gmail.com", "998877665", "d@username", "d@password");
         
         Set<String> services = new HashSet<>();
         services.add("Catering");
         services.add("Photography");
         services.add("Decoration");
         PackageObj packageObj = new PackageObj("Premium", services, 60000.00, vendor);
         
         Set<String> otherServices = new HashSet<>();
         otherServices.add("Dancers");
         otherServices.add("Musician");
        
         ui.registration(user);
                
      // Admin Functionalities
         AdminUI.seeAllUserPage();
         AdminUI.seeAllVendorPage();
         AdminUI.adminLoginPage("devdynamos@123", "Devdynamos@111");
         AdminUI.updateUserPage(user,"activate");
         AdminUI.addVendorPage(new Vendor());
         
        
        
        ui.login("Shruti", "Password@Shruti");   
        ui.showAllQuotations(1);
        ui.setQuotationStatus("Shubhayu26",5,"accept");
//        ui.updatePassword(user, "Password@123");
//        ui.showDetails(user);
//        ui.updateEmail(user,"shubhayu@gmail.com");
//        ui.updatePhoneNumber(user,"9598654789");
//        ui.updateAddress(user,"Mumbai");
//        ui.logout(user);
       
        // Automatically creates planRequest from seleting package
        PlanRequest planRequest = ui.selectPackage(1, LocalDate.of(2023, 10, 5), LocalDate.of(2023, 10, 9), 35, otherServices, user);
        
        // Vendor can go through the planRequests and create a quotation
        vi.addQuoatation(planRequest);
    }
}
