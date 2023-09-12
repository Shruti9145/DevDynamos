
package com.onlineeventmanagement.dao;

import java.sql.SQLException;
import java.util.List;

import com.onlineeventmanagement.domain.PackageObj;

public interface PackageDAO {
	public int insertPackage(PackageObj packageObj) throws SQLException;
	
	public List<PackageObj> searchPackage() throws SQLException;
	
	public PackageObj searhPackage(String id) throws SQLException;
	
	public int deletePackage(String id);
	
	public int updatePackage(String id);
}
