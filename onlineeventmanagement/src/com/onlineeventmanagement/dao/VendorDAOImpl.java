package com.onlineeventmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.onlineeventmanagement.domain.PackageObj;
import com.onlineeventmanagement.domain.Quotation;
import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.exception.UserLoginException;
import com.onlineeventmanagement.exception.VendorLoginException;
import com.onlineeventmanagement.utilities.JdbcConnector;

public class VendorDAOImpl implements VendorDAO{

	
	
	
	@Override
	public boolean vendorLogin(String userName, String password) throws VendorLoginException {
		String url = "jdbc:mysql://localhost/onlineeventmanagement";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			con = DriverManager.getConnection(url, "root", "root");
			// Get Data from DB where user name is provided by user
			String query = "select userName,password from vendors where userName = ? ";
			stmt = con.prepareStatement(query);
			stmt.setString(1, userName);
			res = stmt.executeQuery();

			// Store data retrieve from DB in 2 variables
			String vendorNameFromDB = "";
			String vendorPasswordFromDB = "";
			while (res.next()) {
				vendorNameFromDB = res.getString("userName");
				vendorPasswordFromDB = res.getString("password");
			}
			// Check if user provided data matches with Database
			if ((vendorNameFromDB.equals(userName)) && (vendorPasswordFromDB.equals(password))) {

				// Update user Status to logged in in DB
				updateLogStatus(true, userName);
				return true;
			} else {
				throw new VendorLoginException("Invalid User name or Password");
			}

		} catch (SQLException e) {
			throw new VendorLoginException("Invalid User name or Password");
		}

	}

	/* Logout the user and set the Log status to false in DB*/
	@Override
	public boolean vendorLogout(String userName) {
		// Update user Status to logged out in DB
		if (updateLogStatus(false, userName)) {
			return true;
		}
		return false;
	}
	@Override
	public boolean updateLogStatus(boolean status, String userName) {
		String url = "jdbc:mysql://localhost/onlineeventmanagement";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DriverManager.getConnection(url, "root", "root");
			// Update query to update the Login/Logout status of user in DB;
			String query = "update users set loginStatus = ? where userName = ? ";
			// PreparedSatement to execute Query
			stmt = con.prepareStatement(query);
			stmt.setBoolean(1, status);
			stmt.setString(2, userName);
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return false;

	}
	
	public String insertVendor(Vendor vendor) throws SQLException	{
		Connection connection = JdbcConnector.getJdbcConnection();
		PreparedStatement statement = null;
		
		String query = "insert into vendors(?,?,?,?,?,?)";
		statement = connection.prepareStatement(query);
		statement.setString(1, vendor.getName());
		statement.setString(2, vendor.getAddress());
		statement.setString(3, vendor.getEmail());
		statement.setString(4, vendor.getContactNo());
		statement.setString(5, vendor.getUsername());
		statement.setString(6, vendor.getPassword());
		
		int res = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return (res + " vendor added!");
	}
	
	public List<Vendor> searchVendors() throws SQLException	{
		Connection connection = JdbcConnector.getJdbcConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Vendor> vendors = new ArrayList<>();
		
		String query = "select * from vendors";
		statement = connection.prepareStatement(query);
		resultSet = statement.executeQuery();
		
		if(resultSet.next())	{
			Vendor vendor = new Vendor();
			
			vendor.setVendorId(resultSet.getInt("vendorId"));
			vendor.setName(resultSet.getString("name"));
			vendor.setAddress(resultSet.getString("address"));
			vendor.setEmail(resultSet.getString("email"));
			vendor.setContactNo(resultSet.getString("contactNumber"));
			vendor.setUsername(resultSet.getString("username"));
			vendor.setPassword(resultSet.getString("password"));
			
			vendors.add(vendor);
		}
		
		return vendors;
	}
	
	public Vendor searchVendor(int vendorId) throws SQLException	{
		Connection connection = JdbcConnector.getJdbcConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Vendor vendor = new Vendor();
		
		String query = "select * from vendors where vendorId=?";
		statement = connection.prepareStatement(query);
		statement.setInt(1, vendorId);
		resultSet = statement.executeQuery();
		
		if(resultSet.next())	{
			vendor.setVendorId(resultSet.getInt("vendorId"));
			vendor.setName(resultSet.getString("name"));
			vendor.setAddress(resultSet.getString("address"));
			vendor.setEmail(resultSet.getString("email"));
			vendor.setContactNo(resultSet.getString("contactNumber"));			
			vendor.setUsername(resultSet.getString("username"));
			vendor.setPassword(resultSet.getString("password"));
		}
		
		return vendor;
	}
	
	public String deleteVendor(int vendorId) throws SQLException	{
		Connection connection = JdbcConnector.getJdbcConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String query = "delete from vendors where vendorId=?";
		statement = connection.prepareStatement(query);
		statement.setInt(1, vendorId);
		resultSet = statement.executeQuery();
		
		return ("Vendor" + vendorId + " deleted!");
	}
}
