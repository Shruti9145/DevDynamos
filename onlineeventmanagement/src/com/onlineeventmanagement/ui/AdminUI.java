package com.onlineeventmanagement.ui;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.VendorAlreadyExistsException;
import com.onlineeventmanagement.exception.VendorNotFoundException;
import com.onlineeventmanagement.service.AdminService;
import com.onlineeventmanagement.service.AdminServiceImpl;

public class AdminUI {

    public static void seeAllVendorPage(){
        AdminService adminService = new AdminServiceImpl();

        try {
            for(Vendor vendor: adminService.seeAllVendor()){
                System.out.println(vendor);
            }
        } catch (VendorNotFoundException e) {
            e.getMessage();
        }
    }

    public static void addVendorPage(Vendor vendor){
            AdminService adminService = new AdminServiceImpl();

            try {
                Vendor newVendor = adminService.addVendor(vendor);
                System.out.println(newVendor);
            } catch (VendorAlreadyExistsException e) {
                e.getMessage();
            }
    }

    public static void seeAllUserPage(){
        AdminService adminService = new AdminServiceImpl();
        try {   
            for(User user : adminService.seeAllUser()){
                System.out.println(user);
            }
        } catch (UserNotFoundException e) {
            e.getMessage();
        }
    }

    public static void updateUserPage(User user, String status){
           AdminService adminService = new AdminServiceImpl();

        try {
            if(status.equals("activate")){
                int bool = 1;
                if(adminService.updateUser(user,bool)){
                System.out.println("User Status is Activated");
            }
            }

            if(status.equals("deactivate")){
                int bool = 0;
                if(adminService.updateUser(user,bool)){
                System.out.println("User Status is deactivated");
            }
            }
            
        } catch (UserNotFoundException e) {
            e.getMessage();
        }

    }

    // public static void deactivateUserPage(User user){
    //         AdminService adminService = new AdminServiceImpl();

    //         try {
    //             if(adminService.deactivateUser(user)){
    //                 System.out.println("User Status is Deactivated");
    //             }
    //         } catch (UserNotFoundException e) {
                
    //             e.printStackTrace();
    //         }
    // }

}
