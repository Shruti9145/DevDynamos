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
import com.onlineeventmanagement.exception.InvalidCredentialException;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.VendorAlreadyExistsException;

public class AdminDAOImpl implements AdminDAO{

    @Override
    public boolean adminLogin(String username, String password) throws SQLException, InvalidCredentialException {
        // Establish a database connection
        String url = "jdbc:mysql://localhost/onlineeventmanagement";
        Connection con = null; 
        ResultSet rs = null;
        con = DriverManager.getConnection(url, "root", "root");

         // Check if the admin credentials are valid
        String checkSql = "SELECT * FROM admin WHERE username=? and password=?";
        PreparedStatement checkStmt = con.prepareStatement(checkSql);
        checkStmt.setString(1, username);
        checkStmt.setString(2, password);
        rs = checkStmt.executeQuery();

        if(rs.next()){
             // Admin credentials are valid
            return true;
        }else{
             // Invalid admin credentials
            throw new InvalidCredentialException("Invalid Username/Password");
        }
        
    }

    @Override
    public Vendor saveVendor(Vendor vendor) throws SQLException, VendorAlreadyExistsException {
         // Establish a database connection
        String url = "jdbc:mysql://localhost/onlineeventmanagement";
        Connection con = null; 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        con = DriverManager.getConnection(url, "root", "root");

        // Check if the vendor already exists by email
        String checkSql = "SELECT * FROM vendors WHERE vendor_email = ?";
        PreparedStatement checkStmt = con.prepareStatement(checkSql);
        checkStmt.setString(1, vendor.getEmail());
        rs = checkStmt.executeQuery();

        if(rs.next()){
              // Vendor with the same email already exists
            throw new VendorAlreadyExistsException("This Vendor Id is Already Exists in the database");
        }else{

        String sql = "insert into vendors (name,address,email,contact_number,username,password) values(?,?,?,?,?,?)";
        stmt = con.prepareStatement(sql);
        stmt.setString(1,vendor.getName());
        stmt.setString(2,vendor.getAddress());
        stmt.setString(3,vendor.getEmail());
        stmt.setString(4,vendor.getContactNo());
        stmt.setString(5,vendor.getUsername());
        stmt.setString(6,vendor.getPassword());

        int n = stmt.executeUpdate();
        System.out.println(n + " Vendor Detail Inserted!!!");

        stmt.close();
        con.close();
        return vendor;
        }
    }

    @Override
    public Set<Vendor> displayAllVendor() throws SQLException {
         // Establish a database connection
        String url = "jdbc:mysql://localhost/onlineeventmanagement";
        Connection con = null; 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Set<Vendor> vendors = new HashSet<>();
        con = DriverManager.getConnection(url, "root", "root");

         // Retrieve and populate vendor information
        String sql = "select * from vendors";
        stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();

        while(rs.next()){
            Vendor vendor = new Vendor();
            vendor.setName(rs.getString("name"));
            vendor.setAddress(rs.getString("address"));
            vendor.setEmail(rs.getString("email"));
            vendor.setContactNo(rs.getString("contact_number"));
            vendor.setUsername(rs.getString("username"));
            vendor.setPassword(rs.getString("password"));
            vendors.add(vendor);
        }

            rs.close();
			stmt.close();
			con.close();

        return vendors;
        
    }

    @Override
    public List<User> displayAllUser() throws SQLException {
        // Establish a database connection
        String url = "jdbc:mysql://localhost/onlineeventmanagement";
        Connection con = null; 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();

        con = DriverManager.getConnection(url, "root", "root");

         // Retrieve and populate user information
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
    public boolean  updateUserStatus(User user, int status) throws SQLException, UserNotFoundException {
         // Establish a database connection
        String url = "jdbc:mysql://localhost/onlineeventmanagement";
        Connection con = null; 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        con = DriverManager.getConnection(url, "root", "root");
        
        // Check if the user exists by username
        String sql = "select * from users where userName=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, user.getUserName());
        rs = stmt.executeQuery();

        if(rs.next()){
            // Update the user's status
            String sql2 = "update users set status=? where userName=?";
            stmt = con.prepareStatement(sql2);
            stmt.setInt(1,status);
            stmt.setString(2, user.getUserName());

            int n = stmt.executeUpdate();

            if(n>0){
                System.out.println(n + " user status is activated!!");
                rs.close();
                stmt.close();
                con.close();
                return true;
            }

		} else{
             // User not found
			 throw new UserNotFoundException("Given User Not Found!!");
        }
		return false;
    	
    }
}
