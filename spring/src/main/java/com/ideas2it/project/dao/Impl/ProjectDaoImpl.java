/**
 * Provide the class necessary to create a dao class
 * To communicate with service and model classes
 *
 * @version 1.0
 * @since 1.0
 */
package main.java.com.ideas2it.project.dao.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import main.java.com.ideas2it.Logger.LoggerClass;
import main.java.com.ideas2it.employee.model.Employee;
import main.java.com.ideas2it.project.dao.ProjectDao;
import main.java.com.ideas2it.project.model.Project;
import main.java.com.ideas2it.sessionManagement.SessionManagement;

/**
 * ProjectDao made jdbc connectivity  and using hibernate for the employeeApplication Using database
 * we can insert ,update,select,delete data
 * 
 * @version 1.0
 * @author GAYATHIRI
 */
public class ProjectDaoImpl implements ProjectDao {
     LoggerClass logger = new LoggerClass();
     
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertProject(String projectName, String technology, String projectManager, String projectType, String startDate, String endDate, String actualEndDate, String projectStatus) {
		logger.loggerInfo("Inserting values for project");
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Project project = new Project(projectName, technology, projectManager, projectType, startDate, endDate, actualEndDate, projectStatus);
		session.save(project);
		transaction.commit();
		session.close();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Project> viewProject() {
		logger.loggerInfo("Display all for project");
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		List<Project> projectlist = session.createQuery("from Project", Project.class).getResultList();
		return projectlist;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Project projectViewById(int projectId) {
		logger.loggerInfo("Display for project");
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		Project project = session.get(Project.class, projectId);
		return project;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int updateProject(int projectId, String actualEndDate, String technology) {
		logger.loggerInfo("Update values for project");
		int updateCount = 0;
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query UpdateQuery = session.createQuery("update Project project set project.actualEndDate = :actualEndDate , project.technology = :technology where project.projectId = :projectId");
		UpdateQuery.setParameter("actualEndDate", actualEndDate);
		UpdateQuery.setParameter("technology", technology);
		UpdateQuery.setParameter("projectId", projectId);
		updateCount =  UpdateQuery.executeUpdate();
		transaction.commit();
		session.close();
		return updateCount;
	}	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addProjectEmployee(List <Integer> listId, int projectId) {
		logger.loggerInfo("Add Employee values for project");
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Project project = session.get(Project.class, projectId); 
		List <Employee> employee = session.createQuery("select employee from Employee employee where employee.employeeId IN :listId").setParameter("listId", listId).getResultList();
		System.out.println("employee list" + employee);
		Set <Employee> employeeSet = new HashSet <Employee>(employee);
		project.setEmployeeSet(employeeSet);
		session.save(project);
		transaction.commit();
		session.close();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int deleteProject(int projectId) {
		int countEmployee = 0;
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query deleteQuery = session.createQuery("update Project project set projectStatus = 'PROJECT COMPLETED' where project.projectId = :projectId");
		deleteQuery.setParameter("projectId", projectId);
		countEmployee =  deleteQuery.executeUpdate();
		transaction.commit();
		session.close();
		return countEmployee;
	}
}
