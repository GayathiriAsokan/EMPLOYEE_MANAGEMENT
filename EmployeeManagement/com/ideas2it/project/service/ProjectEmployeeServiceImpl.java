/**
 * Provide the class necessary to create a service class
 * To communicate with controller and model classes
 *
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.project.service;

import java.util.List;

import com.ideas2it.project.dao.ProjectEmployeeDaoImpl;
import com.ideas2it.project.model.Project;

/**
 * @description ProjectService used to hold Project We can view, remove, add,
 * update operations in Project data
 * @author GAYATHIRI
 * @version 1.2
 */
public class ProjectEmployeeServiceImpl implements ProjectEmployeeService {
	ProjectEmployeeDaoImpl projectEmployeeDaoImpl = new ProjectEmployeeDaoImpl();
	
	/**
	 * AddProjectEmployee is used to add project employee details
	 */
	@Override
	public void addProjectEmployee(List <Integer> listId, int projectId) {
		projectEmployeeDaoImpl.addProjectEmployee(listId, projectId);
	}
	
	/**
	 * ViewProjectEmployee is used to view project employee details
	 */
	@Override
	public List <Project> viewProjectEmployee() {
		return projectEmployeeDaoImpl.viewProjectEmployee();
	}
	
	/**
	 * ViewProjectEmployeeById is used to view project employee details via Id
	 */
	@Override
	public Project viewProjectEmployeeById(int projectId) {
		return projectEmployeeDaoImpl.viewProjectEmployeeById(projectId);
	}

	
}
