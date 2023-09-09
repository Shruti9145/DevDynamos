package com.onlineeventmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import com.onlineeventmanagement.domain.User;
import com.onlineeventmanagement.exception.UserNotFoundException;

public class UserDAO {

	public User getInfo(String userId) throws UserNotFoundException {

		String url = "jdbc:mysql://localhost/onlineeventmanagement";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			con = DriverManager.getConnection(url, "root", "root");
			String query = "select * from users where  userId = ?";
			// PreparedSatement to execute Query
			stmt = con.prepareStatement(query);
			stmt.setString(1, userId);
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
			throw new UserNotFoundException("Invalid User");
		}

	}

	public boolean updatePassword(String userId, String newPassword) throws UserNotFoundException  {
		String url = "jdbc:mysql://localhost/onlineeventmanagement";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DriverManager.getConnection(url, "root", "root");
			String query = "update users set password = ? where userId = ? ";
			// PreparedSatement to execute Query
			stmt = con.prepareStatement(query);
			stmt.setString(1, newPassword);
			stmt.setString(2, userId);
			int n= stmt.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UserNotFoundException("Invalid User ID. Not able to change Password");
		}

	}

}
