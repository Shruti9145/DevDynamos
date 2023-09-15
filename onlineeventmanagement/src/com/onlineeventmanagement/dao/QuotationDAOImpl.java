package com.onlineeventmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineeventmanagement.domain.Quotation;
import com.onlineeventmanagement.exception.UserNotFoundException;
import com.onlineeventmanagement.utilities.JdbcConnector;

public class QuotationDAOImpl implements QuotationDAO{

	@Override
	public String createQuotation(Quotation quotation) throws SQLException {
		Connection connection = JdbcConnector.getJdbcConnection();
		PreparedStatement statement = null;
		
		String query = "insert into quotations(?,?,?,?,?,?)";
		statement = connection.prepareStatement(query);
		statement.setDouble(1, quotation.getEstimatedAmmount());
		statement.setInt(2, quotation.getVendor().getVendorId());
		statement.setInt(3, quotation.getUser().getUserId());
		statement.setInt(4, quotation.getPlanRequest().getPlanRequestId());
		statement.setString(5, quotation.getStatus());
		
		int res = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return (res + " quotation added!");
	}

	@Override
	public List<Quotation> searchQuotations() throws SQLException, UserNotFoundException {
		Connection connection = JdbcConnector.getJdbcConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Quotation> quotations = new ArrayList<>();
		
		String query = "select * from quotations";
		statement = connection.prepareStatement(query);
		resultSet = statement.executeQuery();

		if(resultSet.next())	{
			Quotation quotation = new Quotation();
			
			quotation.setQuotationId(resultSet.getInt("quotationId"));
			quotation.setEstimatedAmmount(resultSet.getDouble("estimated_amount"));

			VendorDAO vendor = new VendorDAOImpl();
			quotation.setVendor(vendor.searchVendor(resultSet.getInt("vendorId")));
			
			UserDAO user = new UserDAOImpl();
			quotation.setUser(user.getUser(resultSet.getInt("userId")));
			
			PlanRequestDAO planRequest = new PlanRequestDAOImpl();
			quotation.setPlanRequest(planRequest.searchPlanRequest(resultSet.getInt("planRequestId")));
			
			quotation.setStatus(resultSet.getString("statusBefore"));
			
			quotations.add(quotation);
		}
		
		return quotations;
	}

	@Override
	public Quotation searchQuotation(int quotationId) throws SQLException, UserNotFoundException {
		Connection connection = JdbcConnector.getJdbcConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String query = "select * from quotations where quotationId=?";
		statement = connection.prepareStatement(query);
		resultSet = statement.executeQuery();

		if(resultSet.next())	{
			Quotation quotation = new Quotation();
			
			quotation.setQuotationId(resultSet.getInt("quotationId"));
			quotation.setEstimatedAmmount(resultSet.getDouble("estimated_amount"));

			VendorDAO vendor = new VendorDAOImpl();
			quotation.setVendor(vendor.searchVendor(resultSet.getInt("vendorId")));
			
			UserDAO user = new UserDAOImpl();
			quotation.setUser(user.getUser(resultSet.getInt("userId")));
			
			PlanRequestDAO planRequest = new PlanRequestDAOImpl();
			quotation.setPlanRequest(planRequest.searchPlanRequest(resultSet.getInt("planRequestId")));
			
			quotation.setStatus(resultSet.getString("statusBefore"));
		}
		
		return null;
	}

}
