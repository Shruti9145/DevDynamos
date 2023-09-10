package com.onlineeventmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.onlineeventmanagement.domain.Vendor;
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
        //checkStmt.setString(1, vendor.getVendoId());
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
    
}
