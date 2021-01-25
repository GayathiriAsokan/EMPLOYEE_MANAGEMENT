package com.ideas2it;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ideas2it.employee.service.EmployeeServiceImpl;

public class ViewEmployee extends HttpServlet {
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

	public void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException{
		int employeeId = Integer.parseInt(req.getParameter("EmployeeId"));
		if (employeeId != 0) {
			response.setContentType("text/html");
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString = objectMapper.writeValueAsString(employeeService.getEmployee(employeeId).getCompanyName());
			System.out.println(jsonString);
			PrintWriter out = response.getWriter(); 
			out.write(jsonString);
		}
	}
}
