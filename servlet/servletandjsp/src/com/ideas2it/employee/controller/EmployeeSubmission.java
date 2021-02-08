/**
 * Provide necessary to create servlet class in controller
 */
package com.ideas2it.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideas2it.employee.service.EmployeeServiceImpl;

/**
 * @description EmployeeSubmission is used to save the employee details
 * It is used for crud operations employee details are saved in the database table using hibernate
 * @author GAYATHIRI
 *
 */
public class EmployeeSubmission extends HttpServlet {
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

	/**
	 * This method is used to save the employee details using jsp file
	 * By checking the mode crud operations are done
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("mode"));
		PrintWriter out = response.getWriter();
		int caseSubmit = Integer.parseInt(request.getParameter("mode")); 
		switch (caseSubmit) { 
		case 1:
			String status = addEmployee(request);
			response.setContentType("text/plain");
			response.getWriter().write(status); 
			System.out.println(status);
			break;
		case 2:
			//status = updateEmployee(request);
			status="gbfg";
			response.setContentType("text/plain");
			response.getWriter().write(status); 
			System.out.println(status);
			break;
		case 3:
			status = deleteEmployee(request);
			response.setContentType("text/plain");
			response.getWriter().write(status); 
			System.out.println(status);
			break;
		case 5:
			status = addEmployeeToProject(request);
			response.setContentType("text/plain");
			response.getWriter().write(status); 
			System.out.println(status);
			break;
		}

	}

	/**
	 * AddEmployee method is used to add employee details 
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
	 * UpdateEmployee method is used to update the employee details
	 */
	public String updateEmployee(HttpServletRequest request) {
		System.out.println(request.getParameter("EmployeeId"));
		int employeeId = Integer.parseInt(request.getParameter("EmployeeId")); 
		long phoneNumber = Long.parseLong(request.getParameter("PhoneNumber"));
		String emailId = request.getParameter("EmailId");
		String status = employeeService.updatePersonalDetails(employeeId, phoneNumber, emailId);
		return status;
	}

	/**
	 * DeleteEmployee is used to change the status of the employee
	 */
	public String deleteEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("EmployeeId")); 
		String status = employeeService.deleteEmployee(employeeId);
		return status;
	}

	/**
	 * AddEmployeeToProject is used to add employee and project Details
	 * To insert and view the employee and project
	 */
	public String addEmployeeToProject(HttpServletRequest request) {
		List <Integer> listProjectId = new ArrayList <Integer> ();
		int employeeId = Integer.parseInt(request.getParameter("Employee"));
		String [] project = request.getParameterValues("Project");
		for (int index = 0; index < project.length ; index ++) {
			System.out.println(project[index]);
			listProjectId.add(Integer.parseInt(project[index]));
		}
		System.out.println(listProjectId);
		String status = employeeService.addProjectEmployee(listProjectId, employeeId);
		return status;
	}
}
