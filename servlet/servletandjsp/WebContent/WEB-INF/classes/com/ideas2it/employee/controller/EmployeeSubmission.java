/**
 * 
 */
package com.ideas2it.employee.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideas2it.employee.service.EmployeeServiceImpl;

/**
 * @author ubuntu
 *
 */
public class EmployeeSubmission extends HttpServlet {
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

	/**
	 * 
	 */
	public void doGET(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("mode"));
		int caseSubmit = Integer.parseInt(request.getParameter("mode")); 
		switch (caseSubmit) { 
		case 1:
			String status = addEmployee(request);
			response.setContentType("status/plain");
			response.getWriter().write(status); 
			System.out.println(status);
			break;
		case 2:
			status = updateEmployee(request);
			response.setContentType("status/plain");
			response.getWriter().write(status); 
			System.out.println(status);
			break;
		case 3:
			status = deleteEmployee(request);
			response.setContentType("status/plain");
			response.getWriter().write(status); 
			System.out.println(status);
			break;
		}

	}

	/**
	 * 
	 */

	public String addEmployee(HttpServletRequest request) {
		String companyName = request.getParameter("CompanyName");
		double salary = Double.parseDouble(request.getParameter("Salary"));
		String designation = request.getParameter("Designation");
		int experience = Integer.parseInt(request.getParameter("Experience"));
		String status = request.getParameter("Status");
		String name = request.getParameter("Name");
		long phoneNumber = Long.parseLong(request.getParameter("PhoneNumber"));
		String emailId = request.getParameter("EmailId");
		String dateOfBirth = request.getParameter("DateOfBirth");
		HashMap <String, Object> currentAddressMap = new HashMap <String, Object>();
		currentAddressMap.put("Street", request.getParameter("Street"));
		currentAddressMap.put("City", request.getParameter("City"));
		currentAddressMap.put("District", request.getParameter("District"));
		currentAddressMap.put("PinCode", Integer.parseInt(request.getParameter("PinCode")));
		currentAddressMap.put("State", request.getParameter("State"));
		currentAddressMap.put("AddressType", request.getParameter("AddressType"));
		HashMap <String, Object> permanentAddressMap = new HashMap <String, Object>();
		permanentAddressMap.put("Street", request.getParameter("PermanentStreet"));
		permanentAddressMap.put("City", request.getParameter("PermanentCity"));
		permanentAddressMap.put("District", request.getParameter("PermanentDistrict"));
		permanentAddressMap.put("PinCode", Integer.parseInt(request.getParameter("PermanentPinCode")));
		permanentAddressMap.put("State", request.getParameter("PermanentState"));
		permanentAddressMap.put("AddressType", request.getParameter("PermanentAddressType"));
		String insertStatus = employeeService.insertEmployee(companyName, salary, designation, experience, status,
				name, phoneNumber, dateOfBirth, emailId, currentAddressMap, permanentAddressMap);
		return insertStatus;
	}

	/**
	 * 
	 */
	public String updateEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("employeeId")); 
		long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
		String emailId = request.getParameter("emailId");
		String status = employeeService.updatePersonalDetails(employeeId, phoneNumber, emailId);
		System.out.println(status);
		return status;
	}

	/**
	 * 
	 */
	public String deleteEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("employeeId")); 
		String status = employeeService.deleteEmployee(employeeId);
		System.out.println(status);
		return status;
	}
}
