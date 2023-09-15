package com.onlineeventmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.onlineeventmanagement.domain.PlanRequest;
import com.onlineeventmanagement.exception.InvalidDate;
import com.onlineeventmanagement.exception.NumberPeople;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.utilities.JdbcConnector;

public class PlanRequestDAOImpl implements PlanRequestDAO {

	@Override
	public String insertPlanRequest(PlanRequest planRequest) throws SQLException, InvalidDate, NumberPeople {
		if(planRequest.getFromDate().isAfter(planRequest.getToDate()))
			throw new InvalidDate("From date should be before to date!");
		if(planRequest.getFromDate().isBefore(LocalDate.now()))
			throw new InvalidDate("Plan date greater than Actual Date");
		
		Connection connection = JdbcConnector.getJdbcConnection();
		PreparedStatement statement = null;
		
		String query = "insert into planrequests(?,?,?,?,?,?,?)";
		statement = connection.prepareStatement(query);
		statement.setDate(1, Date.valueOf(planRequest.getFromDate()));
		statement.setDate(2, Date.valueOf(planRequest.getToDate()));
		String setValues = String.join(",", planRequest.getServices());
		statement.setString(3, setValues);
		
		if(planRequest.getNumberPeople() <= 30)
			throw new NumberPeople("People less than 30!");
		statement.setInt(4, planRequest.getNumberPeople());
		setValues = String.join(",", planRequest.getOtherServices());
		statement.setString(5, setValues);
		statement.setInt(6, planRequest.getPackageName().getPackageId());
		
		int res = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return (res + " planRequest added!");
	}

	@Override
	public List<PlanRequest> searchPlanRequests() throws SQLException, UserNotFoundException {
		Connection connection = JdbcConnector.getJdbcConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<PlanRequest> planRequests = new ArrayList<>();
		
		String query = "select * from planrequests";
		statement = connection.prepareStatement(query);
		resultSet = statement.executeQuery();
		
		if(resultSet.next())	{
			PlanRequest planRequest = new PlanRequest();
			
			planRequest.setPlanRequestId(resultSet.getInt("planRequestId"));
			planRequest.setFromDate(resultSet.getDate("fromDate").toLocalDate());
			planRequest.setToDate(resultSet.getDate("toDate").toLocalDate());
			
			Set<String> services = new HashSet<>();
			String elements[] = resultSet.getString("services").split(",");
			for(String element : elements)
				services.add(element);
			planRequest.setServices(services);
			
			planRequest.setNumberPeople(resultSet.getInt("numberPeople"));
			
			Set<String> otherServices = new HashSet<>();
			String elements2[] = resultSet.getString("otherServices").split(",");
			for(String element : elements2)
				otherServices.add(element);
			planRequest.setOtherServices(otherServices);
			
			PackageDAO packageName = new PackageDAOImpl();
			planRequest.setPackageName(packageName.searhPackage(resultSet.getInt("packageId")));
			
			UserDAO user = new UserDAOImpl();
			planRequest.setUser(user.getUser(resultSet.getInt("userId")));
			
			planRequests.add(planRequest);
		}
		
		return planRequests;
	}

	@Override
	public PlanRequest searchPlanRequest(int planRequestId) throws SQLException, UserNotFoundException {
		Connection connection = JdbcConnector.getJdbcConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String query = "select * from planrequests where planRequestId=?";
		statement = connection.prepareStatement(query);
		statement.setInt(1, planRequestId);
		resultSet = statement.executeQuery();
		PlanRequest planRequest = new PlanRequest();
		
		if(resultSet.next())	{
			planRequest.setPlanRequestId(resultSet.getInt("planRequestId"));
			planRequest.setFromDate(resultSet.getDate("fromDate").toLocalDate());
			planRequest.setToDate(resultSet.getDate("toDate").toLocalDate());
			
			Set<String> services = new HashSet<>();
			String elements[] = resultSet.getString("services").split(",");
			for(String element : elements)
				services.add(element);
			planRequest.setServices(services);
			
			planRequest.setNumberPeople(resultSet.getInt("numberPeople"));
			
			Set<String> otherServices = new HashSet<>();
			String elements2[] = resultSet.getString("otherServices").split(",");
			for(String element : elements2)
				otherServices.add(element);
			planRequest.setOtherServices(otherServices);
			
			PackageDAO packageName = new PackageDAOImpl();
			planRequest.setPackageName(packageName.searhPackage(resultSet.getInt("packageId")));
			
			UserDAO user = new UserDAOImpl();
			planRequest.setUser(user.getUser(resultSet.getInt("userId")));
		}
		
		return planRequest;
	}

	@Override
	public String deletePlanRequest(int planRequestId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
