/**
 * Provide necessary to create servlet in controller
 */
package com.ideas2it.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ideas2it.project.service.Impl.ProjectServiceImpl;

/**
 * @description ProjectController is used to save the project details
 * It is used for crud operations project details 
 * @author GAYATHIRI
 *
 */
public class ProjectController extends HttpServlet {
	ProjectServiceImpl projectService = new ProjectServiceImpl();

	/**
	 * This method is used to save the project details using jsp file
	 * By checking the mode crud operations are done
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(request.getServletPath());
		String urlMapping=request.getServletPath().split("/ProjectController")[1]; 
		System.out.println(urlMapping);
		switch(urlMapping) {
		case "/Insert" :
		case "/Update" :
		case "/Delete":
		case "/View" :
			insertProject(request, response);
			break;
		case "/Update/ajax" : 
			viewProject(request, response); 
			break; 
		case "/ViewAllProject" : 
			displayProject(request, response);
			break; 
		case "/AddEmployee" : 
			System.out.println("fdfhj");
			insertProjectToEmployee(request, response);
			break;
		}
	}

	/**
	 * This method is used to save the project details using jsp file
	 * By checking the mode crud operations are done
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(request.getServletPath());
		String urlMapping=request.getServletPath().split("/ProjectController")[1];
		switch(urlMapping) {
		case "/Insert/submit" :
			addProject(request, response);
			break;
		case "/Update/submit" :
			updateProject(request, response);
			break;		 
		case "/AddProject/submit" :
			System.out.println("ok");
			addEmployeeToProject(request, response);
			break;		 
		}
	}

	/**
	 * AddProject is used to get the values from the user
	 */
	public void addProject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String projectName = request.getParameter("ProjectName");
		String projectManager = request.getParameter("ProjectManager");
		String projectType = request.getParameter("ProjectType");
		String technology = request.getParameter("Technology");
		String startDate = request.getParameter("StartDate");
		String endDate = request.getParameter("EndDate");
		String actualEndDate = request.getParameter("ActualEndDate");
		String status = projectService.insertProject(projectName, projectManager, projectType, technology, startDate, endDate, actualEndDate);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/view/jsp/ProjectSubmission.jsp");
		request.setAttribute("status", status);
		dispatcher.forward(request,response);
	}

	/**
	 * This method is used to add insert Project details 
	 */
	public void insertProject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/view/jsp/AddProject.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * Update the values in project
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void updateProject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int projectId = Integer.parseInt(request.getParameter("ProjectId"));
		String actualEndDate = request.getParameter("ActualEndDate");
		String technology = request.getParameter("Technology");
		String status = projectService.updateProject(projectId, actualEndDate, technology);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/view/jsp/ProjectSubmission.jsp");
		request.setAttribute("status", status);
		dispatcher.forward(request,response);
	}

	/**
	 * AddEmployeeToProject is used to add employee to project Details
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void addEmployeeToProject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int projectId = Integer.parseInt(request.getParameter("Project"));
		List <Integer> listEmployeeId = new ArrayList <Integer> ();
		String [] employee = request.getParameterValues("Employee");
		for (int index = 0; index < employee.length ; index ++) {
			System.out.println(employee[index]);
			listEmployeeId.add(Integer.parseInt(employee[index]));
		}
		System.out.println(listEmployeeId);
		String status = projectService.addProjectEmployee(listEmployeeId, projectId);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/view/jsp/ProjectSubmission.jsp");
		request.setAttribute("status", status);
		dispatcher.forward(request,response);
	}

	/**
	 * Display the details of the project to update,delete and view
	 */
	public void viewProject(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int projectId = Integer.parseInt(request.getParameter("ProjectId"));
		if (projectId != 0) {
			response.setContentType("text/html");
			projectService.viewSingleProject(projectId);
			JSONArray arrayProjectValues = new JSONArray();
			JSONObject project = new JSONObject();
			project.put("ProjectName", projectService.viewSingleProject(projectId).getProjectName());
			project.put("ProjectManager", projectService.viewSingleProject(projectId).getProjectManager());
			project.put("Technology", projectService.viewSingleProject(projectId).getTechnology());
			project.put("ProjectType", projectService.viewSingleProject(projectId).getProjectType());
			project.put("StartDate", projectService.viewSingleProject(projectId).getStartDate());
			project.put("EndDate", projectService.viewSingleProject(projectId).getEndDate());
			project.put("ActualEndDate", projectService.viewSingleProject(projectId).getActualEndDate());
			arrayProjectValues.put(project);
			response.setContentType("application/json");
			response.getWriter().write(arrayProjectValues.toString());
		}
	}

	/**
	 * Display the details of the projects
	 */
	public void displayProject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServletContext context = getServletContext(); RequestDispatcher
		requestDispatcher =
		context.getRequestDispatcher("/view/jsp/ViewAllProject.jsp");
		requestDispatcher.forward(request,response);
	}

	/**
	 * AddEmployee method is used to add employee to project
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void insertProjectToEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/view/jsp/ProjectEmployee.jsp");
		dispatcher.forward(request,response);
	}
}
