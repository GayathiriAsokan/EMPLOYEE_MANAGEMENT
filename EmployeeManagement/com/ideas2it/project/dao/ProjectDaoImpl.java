/**
 * Provide the class necessary to create a dao class
 * To communicate with service and model classes
 *
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.ideas2it.project.model.Project;
import sessionManagement.SessionManagement;

/**
 * ProjectDao made jdbc connectivity for the employeeApplication Using database
 * we can insert ,update,select,delete data
 * 
 * @version 1.0
 * @author GAYATHIRI
 */
public class ProjectDaoImpl implements ProjectDao {

	/**
	 * InsertProject is used to insert the values using Insert query
	 * 
	 * @param projectName    String
	 * @param technology     String
	 * @param projectManager String
	 * @param projectId      int
	 * @param projectType    String
	 * @return rowCount int - to find whether the row inserted or not
	 */
	@Override
	public int insertProject(String projectName, String technology, String projectManager, String projectType) {
		SessionFactory sessionFactory = SessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Project project = new Project(projectName, technology, projectManager, projectType);
		int rowCount = (int) session.save(project);
		System.out.println(rowCount);
		transaction.commit();
		session.close();
		return rowCount;
	}

	/**
	 * ViewEmployee is used to view the employee details using select query
	 * 
	 * @return employeeList List <Employee>
	 */
	@Override
	public List<Project> viewProject() {
		SessionFactory sessionFactory = SessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Project> projectlist = session.createQuery("from Project", Project.class).getResultList();
		return projectlist;
	}

	/**
	 * ViewEmployee is used to view the employee details using select query
	 * 
	 * @return employeeList List <Employee>
	 */
	@Override
	public Project projectViewById(int projectId) {
		SessionFactory sessionFactory = SessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		Project project = session.get(Project.class, projectId);
		return project;
	}

}
