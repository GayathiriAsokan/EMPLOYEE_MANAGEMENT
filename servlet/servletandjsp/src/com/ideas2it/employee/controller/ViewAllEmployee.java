package com.ideas2it.employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideas2it.employee.service.EmployeeServiceImpl;

public class ViewAllEmployee extends HttpServlet {
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(employeeService.getAllEmployee());
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/ViewAllEmployee.jsp");
		dispatcher.forward(request,response);
	}
}
