/**
 * Provide necessary to create a servlet class in controller
 */
package main.java;

import java.io.IOException;
import java.io.PrintWriter;

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
public class EmployeeController extends HttpServlet {
	
	/**
	 * This method is used to do crud operations for project details using jsp file
	 * By checking the mode crud operations are done
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(request.getServletPath());
		String urlMapping=request.getServletPath().split("/EmployeeController")[1]; 
		System.out.println(urlMapping);
		switch(urlMapping) {
		case "/Insert" :
			response.setContentType("text/html");
		    PrintWriter out = response.getWriter();

		    out.print("<html>");
		    out.print("<head>");
		    out.print("<title>");
		    out.print("</title>");
		    out.print("<h1>view accounts</h1>");
		    out.print("</head>");
		}
	}

	/**
	 * This method is used to save the project details using jsp file
	 * By checking the mode crud operations are done
	 *
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	}

}

