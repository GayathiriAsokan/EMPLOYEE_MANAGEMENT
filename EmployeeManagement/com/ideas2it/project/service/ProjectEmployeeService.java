/**
 * Provide the class necessary to create a service class
 * To communicate with controller and model classes
 *
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.project.service;

import java.util.List;

import com.ideas2it.project.model.Project;

/**
 * @description ProjectService used to hold Project We can view, remove, add,
 * update operations in Project data
 * @author GAYATHIRI
 * @version 1.2
 */
public interface ProjectEmployeeService {
	
	/**
	 * AddProjectEmployee is used to insert employee project details 
	 * @param employee int 
	 */
	public void addProjectEmployee(List <Integer> listId, int projectId);
	
	/**
	 * ViewProjectEmployee is used to view project and employee details 
	 * @return List <Project>
	 */
	public List <Project> viewProjectEmployee();
	
	/**
	 * ViewProjectEmployeeById is used to view project and employee via Id
	 * @param projectId int 
	 * @return Project
	 */
	public Project viewProjectEmployeeById(int projectId);
}
