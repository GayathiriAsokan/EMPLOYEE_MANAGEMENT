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
 * @description Display the details of the projects
 * @author GAYATHIRI
 *
 */
public class ViewAllProject extends HttpServlet {

	/**
	 * Display the details of the projects
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		  ServletContext context = getServletContext(); RequestDispatcher
		  requestDispatcher =
		  context.getRequestDispatcher("/view/jsp/ViewAllProject.jsp");
		  requestDispatcher.forward(request,response);
		}
	}

