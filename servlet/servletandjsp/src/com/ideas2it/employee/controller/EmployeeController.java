/**
 * Provide necessary to create a servlet class in controller
 */
package com.ideas2it.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import com.ideas2it.employee.service.EmployeeServiceImpl;

/**
 * @description AddEmployee is used to add employee values 
 * @author GAYATHIRI
 */
public class EmployeeController extends HttpServlet {
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
	/**
	 * This method is used to add employee details 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(request.getServletPath());
		String urlMapping=request.getServletPath().split("/EmployeeController")[1];
		switch(urlMapping) {
		case "/Insert" :
			System.out.println("ggh");
			addEmployee(request, response);
			break;
		case "/Insert/submit" :

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(request.getServletPath());
		String urlMapping=request.getServletPath().split("/EmployeeController")[1];
		switch(urlMapping) {
		case "/Insert/submit" :
			System.out.println("ggh");
			insertEmployee(request, response);
			break;
		case "/Insert" :

		}

	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * 
	 */
	public void addEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("inside add");
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/view/jsp/AddEmployee.jsp");
		dispatcher.forward(request,response);
	}

	public void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
		/*
		 * request.setAttribute("status", insertStatus);
		 * System.out.println(insertStatus);
		 */
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		out.println(insertStatus);
		/*
		 * ServletContext context = getServletContext(); RequestDispatcher dispatcher =
		 * context.getRequestDispatcher("/view/jsp/EmployeeSubmission.jsp");
		 * dispatcher.forward(request,response);
		 */
	}
}

