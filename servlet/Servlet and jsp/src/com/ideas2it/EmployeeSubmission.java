package com.ideas2it;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideas2it.employee.service.EmployeeServiceImpl;

public class EmployeeSubmission extends HttpServlet {
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		 String companyName = req.getParameter("CompanyName");
		 double salary = Double.parseDouble(req.getParameter("Salary"));
		 String designation = req.getParameter("Designation");
		 int experience = Integer.parseInt(req.getParameter("Experience"));
		 String status = req.getParameter("Status");
		 String name = req.getParameter("Name");
		 long phoneNumber = Long.parseLong(req.getParameter("PhoneNumber"));
		 String emailId = req.getParameter("EmailId");
		 String dateOfBirth = req.getParameter("DateOfBirth");
		 HashMap <String, Object> currentAddressMap = new HashMap <String, Object>();
		 currentAddressMap.put("Street", req.getParameter("Street"));
		 currentAddressMap.put("City", req.getParameter("City"));
		 currentAddressMap.put("District", req.getParameter("District"));
		 currentAddressMap.put("PinCode", Integer.parseInt(req.getParameter("PinCode")));
		 currentAddressMap.put("State", req.getParameter("State"));
		 currentAddressMap.put("AddressType", req.getParameter("AddressType"));
		 HashMap <String, Object> permanentAddressMap = new HashMap <String, Object>();
		 permanentAddressMap.put("Street", req.getParameter("PermanentStreet"));
		 permanentAddressMap.put("City", req.getParameter("PermanentCity"));
		 permanentAddressMap.put("District", req.getParameter("PermanentDistrict"));
		 permanentAddressMap.put("PinCode", Integer.parseInt(req.getParameter("PermanentPinCode")));
		 permanentAddressMap.put("State", req.getParameter("PermanentState"));
		 permanentAddressMap.put("AddressType", req.getParameter("PermanentAddressType"));
		 PrintWriter out = res.getWriter(); 
		 System.out.println(req.getParameter("PermanentAddressType"));
		 String insertStatus = employeeService.insertEmployee(companyName, salary, designation, experience, status,
					name, phoneNumber, dateOfBirth, emailId, currentAddressMap, permanentAddressMap);
			System.out.println(insertStatus);
		 //out.println("result is"+k);
	}
}
