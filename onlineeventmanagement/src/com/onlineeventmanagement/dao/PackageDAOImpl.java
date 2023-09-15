package com.onlineeventmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.onlineeventmanagement.domain.PackageObj;
import com.onlineeventmanagement.utilities.JdbcConnector;


public class PackageDAOImpl implements PackageDAO {

	@Override
	public String insertPackage(PackageObj packageObj) throws SQLException {
		Connection connection = JdbcConnector.getJdbcConnection();
		PreparedStatement statement = null;
		
		String query = "insert into packages(?,?,?,?,?)";
		statement = connection.prepareStatement(query);
		statement.setInt(1, packageObj.getPackageId());
		statement.setString(2, packageObj.getType());
		String setValues = String.join(",", packageObj.getServices());
		statement.setString(3, setValues);
		statement.setDouble(4, packageObj.getAmount());
		statement.setInt(5, packageObj.getVendor().getVendorId());
		
		int res = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return (res + " vendor added!");
	}

	@Override
	public List<PackageObj> searchPackage() throws SQLException {
		Connection connection = JdbcConnector.getJdbcConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<PackageObj> packages = new ArrayList<>();
		
		String query = "select * from packages";
		statement = connection.prepareStatement(query);
		resultSet = statement.executeQuery();
		
		if(resultSet.next())	{
			PackageObj packageObj = new PackageObj();
			
			packageObj.setPackageId(resultSet.getInt("package_id"));
			packageObj.setType(resultSet.getString("type"));

			Set<String> services = new HashSet<>();
			String elements[] = resultSet.getString("services").split(",");
			for(String element : elements)
				services.add(element);
			packageObj.setServices(services);
			
			packageObj.setAmount(resultSet.getDouble("amount"));
			
			VendorDAO vendorDAO = new VendorDAOImpl();
			packageObj.setVendor(vendorDAO.searchVendor(resultSet.getInt("vendorId")));
			
			packages.add(packageObj);
		}
		
		return packages;
	}

	@Override
	public PackageObj searhPackage(int packageId) throws SQLException {
		Connection connection = JdbcConnector.getJdbcConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String query = "select * from packages where packageId=?";
		statement = connection.prepareStatement(query);
		statement.setInt(1, packageId);
		resultSet = statement.executeQuery();
		PackageObj packageObj = new PackageObj();
		
		if(resultSet.next())	{
			packageObj.setPackageId(resultSet.getInt("id"));
			packageObj.setType(resultSet.getString("type"));
			
			Set<String> services = new HashSet<>();
			String elements[] = resultSet.getString("services").split(",");
			for(String element : elements)
				services.add(element);
			packageObj.setServices(services);
			
			packageObj.setAmount(resultSet.getDouble("amount"));
			
			VendorDAO vendorDAO = new VendorDAOImpl();
			packageObj.setVendor(vendorDAO.searchVendor(resultSet.getInt("vendorId")));
		}
		
		return packageObj;
	}

	@Override
	public String deletePackage(int packageId) throws SQLException {
		Connection connection = JdbcConnector.getJdbcConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String query = "delete from packages where packageId=?";
		statement = connection.prepareStatement(query);
		statement.setInt(1, packageId);
		resultSet = statement.executeQuery();
		
		return ("Vendor" + packageId + " deleted!");
	}
}
