package com.onlineeventmanagement.service;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.onlineeventmanagement.dao.PackageDAO;
import com.onlineeventmanagement.dao.PackageDAOImpl;
import com.onlineeventmanagement.dao.PlanRequestDAO;
import com.onlineeventmanagement.dao.PlanRequestDAOImpl;
import com.onlineeventmanagement.dao.QuotationDAO;
import com.onlineeventmanagement.dao.QuotationDAOImpl;
import com.onlineeventmanagement.dao.VendorDAO;
import com.onlineeventmanagement.dao.VendorDAOImpl;
import com.onlineeventmanagement.domain.PackageObj;
import com.onlineeventmanagement.domain.PlanRequest;
import com.onlineeventmanagement.domain.Quotation;
import com.onlineeventmanagement.domain.Vendor;
import com.onlineeventmanagement.exception.UserNotFoundException;

public class VendorServiceImpl implements VendorService{
	VendorDAO vendorDAO = new VendorDAOImpl();
	
	@Override
	public PackageObj createPackage(PackageObj packageObj) throws SQLException {
		PackageDAO packageDAO = new PackageDAOImpl();
		packageDAO.insertPackage(packageObj);
		
		return packageObj;
	}

	@Override
	public Set<PlanRequest> viewUserRequest(Vendor vendor) throws SQLException, UserNotFoundException {
		PlanRequestDAO planRequestDAO = new PlanRequestDAOImpl();
		List<PlanRequest> planRequests = planRequestDAO.searchPlanRequests();
		Set<PlanRequest> planRequestSet = new HashSet<>(); 
		
		for(PlanRequest planRequest : planRequests)
			if(planRequest.getPackageName().getVendor().equals(vendor))
				planRequestSet.add(planRequest);
		
		return planRequestSet;
	}

	@Override
	public String makeQuotation(PlanRequest planRequest) throws SQLException{
		QuotationDAO quotationDAO = new QuotationDAOImpl();
		
		Quotation quotation = new Quotation(planRequest.getPackageName().getAmount(), planRequest.getPackageName().getVendor(), planRequest.getUser(), planRequest, "Pending");
		
		quotationDAO.createQuotation(quotation);
		
		return "Quotation created!";
	}

	

}
