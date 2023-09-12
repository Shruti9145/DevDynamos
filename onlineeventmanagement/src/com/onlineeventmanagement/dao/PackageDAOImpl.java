
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


public class PackageDAOImpl implements PackageDAO {

	@Override
	public int insertPackage(PackageObj packageObj) throws SQLException {
		Connection connection = JdbcConnector.getJdbcConnection();
		PreparedStatement statement = null;
		
		String query = "insert into package(?,?,?,?,?)";
		statement = connection.prepareStatement(query);
		statement.setString(1, packageObj.getId());
		statement.setString(2, packageObj.getType());
		String setValues = String.join(",", packageObj.getServices());
		statement.setString(3, setValues);
		statement.setDouble(4, packageObj.getAmount());
		statement.setString(5, packageObj.getVendor().getId());
		
		int res = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return res;
	}

	@Override
	public List<PackageObj> searchPackage() throws SQLException {
		Connection connection = JdbcConnector.getJdbcConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<PackageObj> packages = new ArrayList<>();
		
		String query = "select * from package";
		statement = connection.prepareStatement(query);
		resultSet = statement.executeQuery();
		
		if(resultSet.next())	{
			PackageObj packageObj = new PackageObj();
			packageObj.setId(resultSet.getString("package_id"));
			packageObj.setType(resultSet.getString("type"));

			Set<String> services = new HashSet<>();
			String elements[] = resultSet.getString("services").split(",");
			for(String element : elements)
				services.add(element);
			packageObj.setServices(services);
			
			packageObj.setAmount(resultSet.getDouble("amount"));
			//packageObj.setVendor(resultSet.get);
			
			packages.add(packageObj);
		}
		
		return packages;
	}

	@Override
	public PackageObj searhPackage(String id) throws SQLException {
		Connection connection = JdbcConnector.getJdbcConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String query = "select * from package where id=?";
		statement = connection.prepareStatement(query);
		statement.setString(1, id);
		resultSet = statement.executeQuery();
		PackageObj packageObj = new PackageObj();
		
		if(resultSet.next())	{
			packageObj.setId(resultSet.getString("id"));
			packageObj.setType(resultSet.getString("type"));
			
			Set<String> services = new HashSet<>();
			String elements[] = resultSet.getString("services").split(",");
			for(String element : elements)
				services.add(element);
			packageObj.setServices(services);
			
			packageObj.setAmount(resultSet.getDouble("amount"));
			//packageObj.setVendor(resultSet.get);
		}
		
		return packageObj;
	}

	@Override
	public int deletePackage(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePackage(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
