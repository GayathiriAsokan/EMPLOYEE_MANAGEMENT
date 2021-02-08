/**
 * Provide necessary to create servlet in controller
 */
package com.ideas2it.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ideas2it.project.service.ProjectServiceImpl;

/**
 * @description EmployeeSubmission is used to save the employee details
 * It is used for crud operations employee details are saved in the database table using hibernate
 * @author GAYATHIRI
 *
 */
public class ProjectSubmission extends HttpServlet {
	ProjectServiceImpl projectService = new ProjectServiceImpl();

	/**
	 * This method is used to save the employee details using jsp file
	 * By checking the mode crud operations are done
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("mode"));
		PrintWriter out = response.getWriter();
		int caseSubmit = Integer.parseInt(request.getParameter("mode")); 
		switch (caseSubmit) { 
		case 1:
			String status = addProject(request);
			response.setContentType("text/plain");
			response.getWriter().write(status); 
			break;
		case 2:
			status = updateProject(request); 
			response.setContentType("text/plain");
			response.getWriter().write(status); 
			break;
		case 5:
			status = addEmployeeToProject(request); 
			response.setContentType("text/plain");
			response.getWriter().write(status); 
			break;
		}
	}

	/**
	 * AddProject is used to get the values from the user
	 */
	public String addProject(HttpServletRequest request) {
		String projectName = request.getParameter("ProjectName");
		String projectManager = request.getParameter("ProjectManager");
		String projectType = request.getParameter("ProjectType");
		String technology = request.getParameter("Technology");
		String startDate = request.getParameter("StartDate");
		String endDate = request.getParameter("EndDate");
		String actualEndDate = request.getParameter("ActualEndDate");
		String status = projectService.insertProject(projectName, projectManager, projectType, technology, startDate, endDate, actualEndDate);
		return status;
	}

	/**
	 * Update the values in project
	 */
	public String updateProject(HttpServletRequest request) {
		int projectId = Integer.parseInt(request.getParameter("ProjectId"));
		String actualEndDate = request.getParameter("ActualEndDate");
		String technology = request.getParameter("Technology");
		String status = projectService.updateProject(projectId, actualEndDate, technology);
		return status;
	}

	/**
	 * AddEmployeeToProject is used to add employee and project Details
	 */
	public String addEmployeeToProject(HttpServletRequest request) {
		int projectId = Integer.parseInt(request.getParameter("Project"));
		List <Integer> listEmployeeId = new ArrayList <Integer> ();
		String [] employee = request.getParameterValues("Employee");
		for (int index = 0; index < employee.length ; index ++) {
			System.out.println(employee[index]);
			listEmployeeId.add(Integer.parseInt(employee[index]));
		}
		System.out.println(listEmployeeId);
		String status = projectService.addProjectEmployee(listEmployeeId, projectId);
		return status;
	}
}
