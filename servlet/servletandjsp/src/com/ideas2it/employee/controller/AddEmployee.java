/**
 * Provide necessary to create a servlet class in controller
 */
package com.ideas2it.employee.controller;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @description AddEmployee is used to add employee values 
 * @author GAYATHIRI
 */
public class AddEmployee extends HttpServlet {

	/**
	 * This method is used to add employee details 
	 * Here Get method is used
	 * Response is send to jsp file 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/view/jsp/AddEmployee.jsp");
		dispatcher.forward(request,response);
	}
}
