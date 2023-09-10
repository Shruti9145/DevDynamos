package com.onlineeventmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.VendorAlreadyExistsException;

public class AdminDAOImpl implements AdminDAO{

    @Override
    public Vendor saveVendor(Vendor vendor) throws SQLException, VendorAlreadyExistsException {
        String url = "jdbc:mysql://localhost/onlineeventmanagement";
        Connection con = null; 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        con = DriverManager.getConnection(url, "root", "root");

        // Check if the vendor already exists by email
        String checkSql = "SELECT * FROM vendors WHERE vendor_email = ?";
        PreparedStatement checkStmt = con.prepareStatement(checkSql);
        //checkStmt.setString(1, vendor.getVendoEmail());
        rs = checkStmt.executeQuery();

        if(rs.next()){
              // Vendor with the same email already exists
            throw new VendorAlreadyExistsException("This Vendor Id is Already Exists in the database");
        }else{

        String sql = "insert into vendors values(?,?,?,?,?,?)";
        stmt = con.prepareStatement(sql);
        //stmt.setInt(1, vendor.getVendorId);
        stmt.setString(2,"vendor.getVendorName()");
        stmt.setString(3, "vendor.getAddress()");
        stmt.setString(4, "vendor.getEmail()");
        stmt.setString(5, "vendor.getVendorContact()");
        //stmt.setString(6, "vendor.getEventPackage().getId()");

        int n = stmt.executeUpdate();
        System.out.println(n + " Vendor Detail Inserted!!!");

        stmt.close();
        con.close();
        return vendor;
        }
    }

    @Override
    public Set<Vendor> displayAllVendor() throws SQLException {

        String url = "jdbc:mysql://localhost/onlineeventmanagement";
        Connection con = null; 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Set<Vendor> vendors = new HashSet<>();
        con = DriverManager.getConnection(url, "root", "root");

        String sql = "select * from vendors";
        stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();

        while(rs.next()){
            Vendor vendor = new Vendor();
            //vendor.setVendorName(rs.getString("vendor_name"));
            //vendor.setVendorAddress(rs.getString("vendor_address"));
            //vendor.setVendorEmail(rs.getString("vendor_email"));
            //vendor.setVendorContactNumber(rs.getString("vendor_contact_number"));
            //vendor.setVendorEventPackage(rs.getInt(event_package_id));
            //here we need to add the event package in the vendor.
            vendors.add(vendor);
        }

            rs.close();
			stmt.close();
			con.close();

        return vendors;
        
    }

    @Override
    public List<User> displayAllUser() throws SQLException {
       
        String url = "jdbc:mysql://localhost/onlineeventmanagement";
        Connection con = null; 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();

        con = DriverManager.getConnection(url, "root", "root");

        String sql = "select * from users";
        stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();

        while(rs.next()){
            User user = new User();
            user.setName(rs.getString("name"));

            Date sqlDate = rs.getDate("dateOfBirth");
            Date utilDate = new Date(sqlDate.getTime());
            LocalDate newDate = utilDate.toLocalDate(); 
            user.setDateOfBirth(newDate);
            user.setEmail(rs.getString("email"));
            user.setLocation(rs.getString("location"));
            user.setMobileNumber(rs.getString("mobileNumber"));
            user.setPassword(rs.getString("password"));
            user.setUserId(rs.getString("userId"));
            user.setUserName(rs.getString("userName"));
            users.add(user);
        }

        rs.close();
		stmt.close();
		con.close();

        return users;
    }

    @Override
    public boolean activateUserStatus(User user) throws SQLException, UserNotFoundException {
        
        String url = "jdbc:mysql://localhost/onlineeventmanagement";
        Connection con = null; 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        con = DriverManager.getConnection(url, "root", "root");
        
        String sql = "select * from users where userId=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, user.getUserId());
        rs = stmt.executeQuery();

        if(rs.next()){
            String sql2 = "update users set status=true where userID=?";
            stmt = con.prepareStatement(sql2);
            stmt.setString(1, user.getUserId());

            int n = stmt.executeUpdate();

            if(n>0){
                System.out.println(n + " user status is activated!!");
                 rs.close();
                stmt.close();
                con.close();
                return true;
            }

        }else {
            throw new UserNotFoundException("Given User Not Found!!");
        }
           
        return false;
    }

    @Override
    public boolean deactivateUserStatus(User user) throws SQLException, UserNotFoundException {
        
        String url = "jdbc:mysql://localhost/onlineeventmanagement";
        Connection con = null; 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        con = DriverManager.getConnection(url, "root", "root");
        
        String sql = "select * from users where userId=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, user.getUserId());
        rs = stmt.executeQuery();

        if(rs.next()){
            String sql2 = "update users set status=false where userID=?";
            stmt = con.prepareStatement(sql2);
            stmt.setString(1, user.getUserId());

            int n = stmt.executeUpdate();

            if(n>0){
                System.out.println(n + " user status is deactivated!!");
                rs.close();
                stmt.close();
                con.close();
                return true;
            }

        }else {
            throw new UserNotFoundException("Given User Not Found!!");
        }
           
        return false;
        
    }
    
}
