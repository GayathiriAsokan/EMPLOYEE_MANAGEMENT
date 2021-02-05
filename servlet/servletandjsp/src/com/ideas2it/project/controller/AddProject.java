/**
 * Provide necessary to create a servlet class in controller
 */
package com.ideas2it.project.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description AddProject is used to add project values 
 * @author GAYATHIRI
 *
 */
public class AddProject extends HttpServlet {

	/**
	 * This method is used to add employee details 
	 * Here Get method is used
	 * Response is send to jsp file 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/view/jsp/AddProject.jsp");
		dispatcher.forward(request,response);
	}
}
