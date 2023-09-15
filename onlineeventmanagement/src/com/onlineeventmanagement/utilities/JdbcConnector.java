package com.onlineeventmanagement.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnector {
	static Connection connection = null;
	
	public static Connection getJdbcConnection() throws SQLException	{
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devdynamos","root","Syndome@2903");
		
		return connection;
	}
}
