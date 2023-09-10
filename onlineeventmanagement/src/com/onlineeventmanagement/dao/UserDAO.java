package com.onlineeventmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.exception.UserLoginException;
import com.onlineeventmanagement.exception.UserAlreadyExsistException;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.exception.UserNotLoginException;

public class UserDAO {

	public boolean userRegistration(User user) throws UserAlreadyExsistException {
		String url = "jdbc:mysql://localhost/onlineeventmanagement";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			con = DriverManager.getConnection(url, "root", "root");
			// Get Data from DB where user name is provided by user
			String query = "insert into users(userName,name,password,dateofBirth,mobileNumber,email,location) values(?,?,?,?,?,?,?) ";
			stmt = con.prepareStatement(query);
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getPassword());
			stmt.setDate(4, null);
			stmt.setString(5, user.getMobileNumber());
			stmt.setString(6, user.getEmail());
			stmt.setString(7, user.getLocation());

			stmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			throw new UserAlreadyExsistException(" DAO:User Already Exsists");
		}

	}

	// User Login
	public boolean userlogin(String userName, String password) throws UserLoginException {
		String url = "jdbc:mysql://localhost/onlineeventmanagement";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			con = DriverManager.getConnection(url, "root", "root");
			// Get Data from DB where user name is provided by user
			String query = "select userName,password from users where userName = ? ";
			stmt = con.prepareStatement(query);
			stmt.setString(1, userName);
			res = stmt.executeQuery();

			// Store data retrieve from DB in 2 variables
			String userNameFromDB = "";
			String userPasswordFromDB = "";
			while (res.next()) {
				userNameFromDB = res.getString("userName");
				userPasswordFromDB = res.getString("password");
			}
			// Check if user provided data matches with Database
			if ((userNameFromDB.equals(userName)) && (userPasswordFromDB.equals(password))) {

				// Update user Status to logged in in DB
				updateLogStatus(true, userName);
				return true;
			} else {
				throw new UserLoginException("Invalid User name or Password");
			}

		} catch (SQLException e) {
			throw new UserLoginException("Invalid User name or Password");
		}

	}

	/* Logout the user and set the Log status to false in DB*/
	public boolean userLogout(String userName) {
		// Update user Status to logged out in DB
		if (updateLogStatus(false, userName)) {
			return true;
		}
		return false;
	}

	/*
	 * method is used to update the log status to true when user login's in
	 * method is used to update the log status to false when user log's out 
	 */
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

	/*
	 * method gets the Login status of the user
	 * if user is not login all user cannot call any method
	 */
	public boolean getUserLoginStatus(String userName) {
		String url = "jdbc:mysql://localhost/onlineeventmanagement";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		boolean status = false;
		try {
			con = DriverManager.getConnection(url, "root", "root");
			String query = "select loginStatus from users where userName = ?";
			// PreparedSatement to execute Query
			stmt = con.prepareStatement(query);
			stmt.setString(1, userName);
			res = stmt.executeQuery();
			
			while (res.next()) {
				status = res.getBoolean("loginStatus");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public User getInfo(String userName) throws UserNotFoundException, UserNotLoginException {
		
		if(!getUserLoginStatus(userName)) {
			throw new UserNotLoginException("User need to login first");
		}
		
		String url = "jdbc:mysql://localhost/onlineeventmanagement";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			con = DriverManager.getConnection(url, "root", "root");
			String query = "select * from users where  userName = ?";
			// PreparedSatement to execute Query
			stmt = con.prepareStatement(query);
			stmt.setString(1, userName);
			res = stmt.executeQuery();
			
			User user = new User();
			while (res.next()) {
				user.setUserId(res.getString("userId"));
				user.setPassword(res.getString("password"));
				user.setName(res.getString("name"));
				user.setUserName(res.getString("userName"));
				user.setMobileNumber(res.getString("mobileNumber"));
				user.setEmail(res.getString("email"));
				user.setLocation(res.getString("location"));
				// Date dateOfBirthSql = res.getDate("dateOfBirth");
				// LocalDate dateOfBirthLocalDate = dateOfBirthSql.();
				// user.setDateOfBirth(dateOfBirthLocalDate);
			}
			stmt.close();
			con.close();
			return user;
		} catch (SQLException e) {
			throw new UserNotFoundException("DAO: Invalid User");
		}

	}

	public boolean updatePassword(String userName, String newPassword) throws UserNotFoundException, UserNotLoginException {
		if(!getUserLoginStatus(userName)) {
			throw new UserNotLoginException("User need to login first");
		}
		String url = "jdbc:mysql://localhost/onlineeventmanagement";
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = DriverManager.getConnection(url, "root", "root");
			String query = "update users set password = ? where userName = ? ";
			// PreparedSatement to execute Query
			stmt = con.prepareStatement(query);
			stmt.setString(1, newPassword);
			stmt.setString(2, userName);
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				return true;
			} else {
				throw new UserNotFoundException("Invalid User ID . Not able to change Password");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UserNotFoundException(" Invalid User ID. Not able to change Password");
		}

	}

}
