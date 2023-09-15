package com.onlineeventmanagement.dao;

import java.sql.SQLException;
import java.util.List;

import com.onlineeventmanagement.domain.Quotation;
import com.onlineeventmanagement.exception.UserNotFoundException;

public interface QuotationDAO {
	public String createQuotation(Quotation quotation) throws SQLException;

	public List<Quotation> searchQuotations() throws SQLException, UserNotFoundException;
	
	public Quotation searchQuotation(int quotationId) throws SQLException, UserNotFoundException;
}
