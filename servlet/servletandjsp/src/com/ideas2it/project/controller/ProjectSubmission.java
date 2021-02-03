package com.ideas2it.project.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideas2it.project.service.ProjectServiceImpl;

public class ProjectSubmission extends HttpServlet {
	ProjectServiceImpl projectService = new ProjectServiceImpl();

	/**
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("mode"));
		int caseSubmit = Integer.parseInt(request.getParameter("mode")); 
		switch (caseSubmit) { 
		case 1:
			String status = addProject(request);
			response.setContentType("text/plain");
			response.getWriter().write(status); 
			System.out.println(status);
			break;
		case 2:
			status = updateProject(request); 
			response.setContentType("text/plain");
			response.getWriter().write(status);
			System.out.println(status);
			break;
		}
	}

	/**
	 * AddProject is used to get the values from the user
	 */
	public String addProject(HttpServletRequest request) {
		String projectName = request.getParameter("ProjectName");
		String projectManager = request.getParameter("ProjectManager");
		String technology = request.getParameter("Technology");
		String projectType = request.getParameter("ProjectType");
		String startDate = request.getParameter("StartDate");
		String endDate = request.getParameter("EndDate");
		String actualEndDate = request.getParameter("ActualEndDate");
		String status = projectService.insertProject(projectName, projectManager, projectType, technology, startDate, endDate, actualEndDate);
		return status;
	}

	/**
	 * 
	 */
	public String updateProject(HttpServletRequest request) {
		int projectId = Integer.parseInt(request.getParameter("ProjectId"));
		String actualEndDate = request.getParameter("ActualEndDate");
		String technology = request.getParameter("Technology");
		String status = projectService.updateProject(projectId, actualEndDate, technology);
		return status;

	}
}
