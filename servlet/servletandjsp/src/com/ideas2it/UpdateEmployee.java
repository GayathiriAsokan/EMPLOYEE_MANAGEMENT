package com.ideas2it;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideas2it.employee.service.EmployeeServiceImpl;

/**
 * 
 * @author ubuntu
 *
 */
public class UpdateEmployee extends HttpServlet {
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

	/**
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId")); 
		long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
		String emailId = request.getParameter("emailId");
	    String status = employeeService.updatePersonalDetails(employeeId, phoneNumber, emailId);
		System.out.println(employeeId + " " + phoneNumber +"" + emailId);
		response.getWriter().write(status);
		System.out.println(status);
	}

}
