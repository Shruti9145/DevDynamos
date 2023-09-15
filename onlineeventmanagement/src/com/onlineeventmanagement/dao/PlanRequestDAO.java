package com.onlineeventmanagement.dao;

import java.sql.SQLException;
import java.util.List;

import com.onlineeventmanagement.domain.PlanRequest;
import com.onlineeventmanagement.exception.InvalidDate;
import com.onlineeventmanagement.exception.NumberPeople;
import com.onlineeventmanagement.exception.UserNotFoundException;

public interface PlanRequestDAO {
	public String insertPlanRequest(PlanRequest planRequest) throws SQLException, InvalidDate, NumberPeople;
	
	public List<PlanRequest> searchPlanRequests() throws SQLException, UserNotFoundException;
	
	public PlanRequest searchPlanRequest(int planRequestId) throws SQLException, UserNotFoundException;
	
	public String deletePlanRequest(int planRequestId) throws SQLException;
}
