/**
 * Provide the interface necessary to create a ProjectServiceImpl
 * To communicate with ProjectService class
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.project.service;

import java.util.List;

import com.ideas2it.project.model.Project;

/**
 * @description ProjectServiceImpl communicate with ProjectService class
 * @author GAYATHIRI
 * @version 1.2
 */
public interface ProjectService {

	/**
	 * Insert is used to insert to project details 
	 * @param projectName
	 * @param projectManager
	 * @param projectType
	 * @param technology
	 * @param startDate
	 * @param endDate
	 * @param actualEndDate
	 * @return String
	 */
	public String insertProject(String projectName, String projectManager,
			String projectType, String technology, String startDate, String endDate, String actualEndDate);

	/**
	 * View the list of project
	 * @return List<Project>
	 */
	public List<Project> viewProject();

	/**
	 * View project via Id
	 * @param projectId
	 * @return Project
	 */
	public Project viewSingleProject(int projectId);

	/**
	 * Update the project details
	 * @param projectId int  
	 * @param actualEndDate String
	 * @return String
	 */
	public String updateProject(int projectId, String actualEndDate, String technology);

	/**
	 * Check date is used to validate date
	 * @param dateValue String
	 * @return String
	 */
	//public boolean isDateValid(String dateValue);
	
	/**
	 * AddProjectEmployee is used to add project employee details
	 */
	public void addProjectEmployee(List <Integer> listId, int projectId);
}

