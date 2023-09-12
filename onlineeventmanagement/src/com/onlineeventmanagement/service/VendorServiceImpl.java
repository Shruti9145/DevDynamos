package com.onlineeventmanagement.service;

import java.sql.SQLException;
import java.util.Set;

import com.onlineeventmanagement.dao.VendorDAO;
import com.onlineeventmanagement.dao.VendorDAOImpl;
import com.onlineeventmanagement.domain.PlanRequest;
import com.onlineeventmanagement.domain.Quotation;
import com.onlineeventmanagement.exception.CreateQuotationException;

public class VendorServiceImpl implements VendorService{

	VendorDAO vendorDAO = new VendorDAOImpl();
	@Override
	public Package createPackage() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addPackage'");
	}

	@Override
	public Set<PlanRequest> viewUserRequest() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'viewUserRequest'");
	}

	@Override
	public Quotation createQuotation() throws CreateQuotationException{
		
		try {
			return vendorDAO.addQuotation();
		}catch(SQLException s) {
			throw new CreateQuotationException("Couldn't create Quotation");
		}
		// TODO Auto-generated method stub
		
	}

	

}
