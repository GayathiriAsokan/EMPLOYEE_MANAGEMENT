/**
 * Provide the class necessary to create a service class
 * To communicate with controller and model classes
 *
 * @version 1.1
 * @since 1.0
 */
package main.java.com.ideas2it.project.service.Impl;

import java.util.List;

import main.java.com.ideas2it.Constants.Constants;
import main.java.com.ideas2it.project.dao.Impl.ProjectDaoImpl;
import main.java.com.ideas2it.project.model.Project;
import main.java.com.ideas2it.project.service.ProjectService;
import main.java.com.ideas2it.util.Validator;


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
	 * {@inheritDoc}
	 */
	@Override
	public String insertProject(String projectName, String projectManager, String projectType, String technology, String startDate, String endDate, String actualEndDate, String projectStatus) {
		projectDao.insertProject(projectName, technology, projectManager, projectType, startDate, endDate, actualEndDate, projectStatus);
		return Constants.INSERT_MESSAGE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Project> viewProject() {
		System.out.println(projectDao.viewProject());
		return projectDao.viewProject();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Project viewSingleProject(int projectId) {
		return projectDao.projectViewById(projectId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String updateProject (int projectId, String actualEndDate, String technology) {
		if (Constants.ONE == projectDao.updateProject(projectId, actualEndDate, technology)) { 
			return Constants.UPDATE_MESSAGE; 
		} else { 
			return "CANNOT UPDATE GIVE VALID DATE KINDLY CHECK IT"; 
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String addProjectEmployee(List <Integer> listId, int projectId) {
		projectDao.addProjectEmployee(listId, projectId);
		return Constants.ASSIGN_EMPLOYEE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String deleteProject(int projectId) {
		projectDao.deleteProject(projectId);
		return Constants.DELETE_MESSAGE;
	}
}
