/**
 * Provide the class necessary to create a dao interface
 * To communicate with service and model classes
 *
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.project.dao;

import java.util.List;

import com.ideas2it.project.model.Project;

public interface ProjectEmployeeDao {

	/**
	 * AddProjectEmployee is used to add employee and project details 
	 * @param listId int 
	 * @param projectId int 
	 */
	public void addProjectEmployee(List <Integer> listId, int projectId);

	/**
	 * ViewProjectEmployee is used to view both employee and project details
	 * @return List <Project>
	 */
	public List <Project> viewProjectEmployee();

	/**
	 * ViewProjectEmployeeById is used to view project employee details via Id
	 * @param projectId int 
	 * @return Project
	 */
	public Project viewProjectEmployeeById(int projectId);
}
