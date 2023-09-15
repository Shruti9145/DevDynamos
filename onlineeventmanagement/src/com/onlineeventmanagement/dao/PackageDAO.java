
package com.onlineeventmanagement.dao;

import java.sql.SQLException;
import java.util.List;

import com.onlineeventmanagement.domain.PackageObj;

public interface PackageDAO {
	public String insertPackage(PackageObj packageObj) throws SQLException;
	
	public List<PackageObj> searchPackage() throws SQLException;
	
	public PackageObj searhPackage(int id) throws SQLException;
	
	public String deletePackage(int id) throws SQLException;
}
