/**
 * Provide the class necessary to create a service class
 * To communicate with controller and model classes
 *
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.project.service;

import java.util.List;

import com.ideas2it.project.dao.ProjectDaoImpl;
import com.ideas2it.project.model.Project;
import util.Validator;


/**
 * @description ProjectService used to hold Project We can view, remove, add,
 * update operations in Project data
 * @author GAYATHIRI
 * @version 1.2
 */
public class ProjectServiceImpl implements ProjectService {
	ProjectDaoImpl projectDao = new ProjectDaoImpl();
	Validator validator = new Validator();

	/**
	 * InsertProject is used to inserting the data and getting the values from user
	 */
	@Override
	public String insertProject(String projectName, String projectManager, String projectType, String technology, String startDate, String endDate, String actualEndDate) {
		projectDao.insertProject(projectName, technology, projectManager, projectType, startDate, endDate, actualEndDate);
		return "PROJECT DATA ADDED SUCCESSFULLY";
	}

	/**
	 * ViewProject is used show the project details 
	 */
	@Override
	public List<Project> viewProject() {
		return projectDao.viewProject();
	}

	/**
	 * ViewsingleData method used to display the employee data 
	 */
	@Override
	public Project viewSingleProject(int projectId) {
		return projectDao.projectViewById(projectId);
	}

	/**
	 * CheckDate is used to validate date
	 */
	@Override
	public String checkDate(String dateValue) {
		return validator.checkDate(dateValue);
	}

	/**
	 * UpdateEmployee is used to change the value from employee details
	 */
	@Override
	public String updateProject (int projectId, String actualEndDate, String technology) {
		if (projectDao.updateProject(projectId, actualEndDate, technology) == 1) { 
			return "UPDATED SUCCESSFULLY"; 
		} else { 
			return "CANNOT UPDATE GIVE  VALID DATE KINDLY CHECK IT"; }
	}
}
