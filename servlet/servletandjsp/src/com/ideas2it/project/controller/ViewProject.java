/**
 * 
 */
package com.ideas2it.project.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ideas2it.project.service.ProjectServiceImpl;

/**
 * 
 * @author ubuntu
 *
 */
public class ViewProject extends HttpServlet {

	ProjectServiceImpl projectService = new ProjectServiceImpl();
	
	/**
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
}
