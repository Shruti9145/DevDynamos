package com.onlineeventmanagement.ui;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.exception.InvalidCredentialException;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.VendorAlreadyExistsException;
import com.onlineeventmanagement.exception.VendorNotFoundException;
import com.onlineeventmanagement.service.AdminService;
import com.onlineeventmanagement.service.AdminServiceImpl;

public class AdminUI {

    public static void adminLoginPage(String username, String password){
         // Create an instance of AdminService for handling admin login
        AdminService adminService = new AdminServiceImpl();

        try {
            // Attempt to log in the admin
            if(adminService.loginAdmin(username, password)){
                System.out.println("Admin Successfully Login");
            }
        } catch (InvalidCredentialException e) {
            // Handle and print InvalidCredentialException message
            e.getMessage();
        }

    }

    public static void seeAllVendorPage(){
        // Create an instance of AdminService for retrieving and displaying vendors
        AdminService adminService = new AdminServiceImpl();

        try {
            // Retrieve and display all vendors
            for(Vendor vendor: adminService.seeAllVendor()){
                System.out.println(vendor);
            }
        } catch (VendorNotFoundException e) {
             // Handle and print VendorNotFoundException message
            e.getMessage();
        }
    }

    public static void addVendorPage(Vendor vendor){
        // Create an instance of AdminService for adding a new vendor
            AdminService adminService = new AdminServiceImpl();

            try {
                 // Attempt to add a new vendor
                Vendor newVendor = adminService.addVendor(vendor);
                System.out.println(newVendor + " added to the database");
            } catch (VendorAlreadyExistsException e) {
                 // Handle and print VendorAlreadyExistsException message
                e.getMessage();
            }
    }

    public static void seeAllUserPage(){
        // Create an instance of AdminService for retrieving and displaying users
        AdminService adminService = new AdminServiceImpl();
        try {  
            // Retrieve and display all users 
            for(User user : adminService.seeAllUser()){
                System.out.println(user);
            }
        } catch (UserNotFoundException e) {
             // Handle and print UserNotFoundException message
            e.getMessage();
        }
    }

    public static void updateUserPage(User user, String status){
        // Create an instance of AdminService for updating user status
           AdminService adminService = new AdminServiceImpl();

        try {
            // Check the requested status change (activate or deactivate) and update user status accordingly
            if(status.equalsIgnoreCase("activate")){
                int bool = 1; // Assuming 1 represents activation
                if(adminService.updateUser(user,bool)){
                System.out.println("User Status is Activated");
            }
            }

            if(status.equalsIgnoreCase("deactivate")){
                int bool = 0;// Assuming 0 represents deactivation
                if(adminService.updateUser(user,bool)){
                System.out.println("User Status is deactivated");
            }
            }
            
        } catch (UserNotFoundException e) {
            // Handle and print UserNotFoundException message
            e.getMessage();
        }

    }
}
