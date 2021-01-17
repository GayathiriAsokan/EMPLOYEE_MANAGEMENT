/**
 * Provide the class necessary to create a service class
 * To communicate with controller and model classes
 *
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.employee.service;

import java.util.List;

import com.ideas2it.employee.dao.ProjectEmployeeDaoImpl;
import com.ideas2it.employee.model.Employee;

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
	public void addProjectEmployee(List <Integer> listId, int employeeId) {
		projectEmployeeDaoImpl.addProjectEmployee(listId, employeeId);
	}

	/**
	 * ViewProjectEmployee is used to view project employee details
	 */
	@Override
	public List <Employee> viewProjectEmployee() {
		return projectEmployeeDaoImpl.viewProjectEmployee();
	}

	/**
	 * ViewProjectEmployeeById is used to view project employee details via Id
	 */
	@Override
	public Employee viewProjectEmployeeById(int employeeId) {
		return projectEmployeeDaoImpl.viewProjectEmployeeById(employeeId);
	}
}
