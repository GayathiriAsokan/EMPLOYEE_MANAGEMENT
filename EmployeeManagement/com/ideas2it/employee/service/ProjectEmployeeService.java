/**
 * Provide the class necessary to create a service class
 * To communicate with controller and model classes
 *
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.employee.service;

import java.util.List;

import com.ideas2it.employee.model.Employee;

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
	public void addProjectEmployee(List <Integer> listId, int employeeId);

	/**
	 * ViewProjectEmployee is used to view project and employee details 
	 * @return List <Project>
	 */
	public List <Employee> viewProjectEmployee();

	/**
	 * ViewProjectEmployeeById is used to view project and employee via Id
	 * @param projectId int 
	 * @return Project
	 */
	public Employee viewProjectEmployeeById(int projectId);
}
