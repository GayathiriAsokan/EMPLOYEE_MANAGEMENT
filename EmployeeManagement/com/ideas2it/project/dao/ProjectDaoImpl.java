/**
 * Provide the class necessary to create a dao class
 * To communicate with service and model classes
 *
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.project.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ideas2it.project.model.Project;
import sessionManagement.SessionManagement;

/**
 * ProjectDao made jdbc connectivity  and using hibernate for the employeeApplication Using database
 * we can insert ,update,select,delete data
 * 
 * @version 1.0
 * @author GAYATHIRI
 */
public class ProjectDaoImpl implements ProjectDao {
	SessionManagement sessionManagement  = new SessionManagement();

	/**
	 * InsertProject is used to insert the values using Insert query
	 */
	@Override
	public int insertProject(String projectName, String technology, String projectManager, String projectType, String startDate, String endDate) {
		SessionFactory sessionFactory = sessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Project project = new Project(projectName, technology, projectManager, projectType, startDate, endDate);
		int rowCount = 0;
		session.save(project);
		System.out.println(rowCount);
		transaction.commit();
		session.close();
		return rowCount;
	}

	/**
	 * ViewEmployee is used to view the project details using select query
	 */
	@Override
	public List<Project> viewProject() {
		SessionFactory sessionFactory = sessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Project> projectlist = session.createQuery("from Project", Project.class).getResultList();
		return projectlist;
	}

	/**
	 * ViewEmployee is used to view the project details using hql
	 */
	@Override
	public Project projectViewById(int projectId) {
		SessionFactory sessionFactory = sessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		Project project = session.get(Project.class, projectId);
		return project;
	}

	/**
	 * UpdateProject is used to change the actualEndDate
	 */
	@Override
	public int updateProject(int projectId, String actualEndDate) {
		int updateCount = 0;
		SessionFactory sessionFactory = sessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query UpdateQuery = session.createQuery("update Project project set project.actualEndDate = :actualEndDate where project.projectId = :projectId");
		UpdateQuery.setParameter("actualEndDate", actualEndDate);
		UpdateQuery.setParameter("projectId", projectId);
		updateCount =  UpdateQuery.executeUpdate();
		transaction.commit();
		session.close();
		return updateCount;
	}	
}
