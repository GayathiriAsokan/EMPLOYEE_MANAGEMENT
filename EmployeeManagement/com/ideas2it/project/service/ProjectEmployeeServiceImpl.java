package com.ideas2it.project.service;

import com.ideas2it.employee.service.EmployeeServiceImpl;
import com.ideas2it.project.dao.ProjectEmployeeDaoImpl;

public class ProjectEmployeeServiceImpl {
	EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
	ProjectEmployeeDaoImpl projectEmployeeDaoImpl = new ProjectEmployeeDaoImpl();
	
	public void addProjectEmployee(int employee) {
		ProjectEmployeeDaoImpl.addProjectEmployee(employee);
	}
}
