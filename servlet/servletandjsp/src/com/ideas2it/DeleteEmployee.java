package com.ideas2it;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideas2it.employee.service.EmployeeServiceImpl;

public class DeleteEmployee extends HttpServlet {
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId")); 
	    String status = employeeService.deleteEmployee(employeeId);
		System.out.println(employeeId);
		response.getWriter().write(status);
		System.out.println(status);
	}

}
