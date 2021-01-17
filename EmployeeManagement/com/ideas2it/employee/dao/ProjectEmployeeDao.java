/**
 * Provide the class necessary to create a dao class
 * To communicate with service and model classes
 */
package com.ideas2it.employee.dao;

import java.util.List;

import com.ideas2it.employee.model.Employee;

public interface ProjectEmployeeDao {

	/**
	 * AddProjectEmployee is used to add employee and project details 
	 * @param listId int 
	 * @param employeeId int 
	 */
	public void addProjectEmployee(List <Integer> listId, int employeeId);

	/**
	 * ViewProjectEmployee is used to view both employee and project details
	 * @return List <Employee>
	 */
	public List <Employee> viewProjectEmployee();

	/**
	 * ViewProjectEmployeeById is used to view project employee details via Id
	 * @param employeeId int 
	 * @return Employee
	 */
	public Employee viewProjectEmployeeById(int employeeId);
}
