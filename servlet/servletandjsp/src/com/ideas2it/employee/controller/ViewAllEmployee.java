/**
 * Provide a class necessary to create a servlet class in controller
 */	
package com.ideas2it.employee.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description Display the details of the employee
 * @author GAYATHIRI
 *
 */
public class ViewAllEmployee extends HttpServlet {
	
	/**
	 * Display the details of the employee
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/view/jsp/ViewAllEmployee.jsp");
		dispatcher.forward(request,response);
	}
}
