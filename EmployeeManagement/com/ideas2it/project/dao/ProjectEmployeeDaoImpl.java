/**
 * Provide the class necessary to create a dao class
 * To communicate with service and model classes
 *
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.project.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ideas2it.employee.model.Employee;
import com.ideas2it.project.model.Project;
import sessionManagement.SessionManagement;

/**
 * ProjectDao made jdbc connectivity for the employeeApplication Using database
 * we can insert ,update,select,delete data
 * 
 * @version 1.0
 * @author GAYATHIRI
 */
public class ProjectEmployeeDaoImpl implements ProjectEmployeeDao{

	/**
	 * AddProjectEmployee is used to add details in project and employee
	 */
	@Override
	public void addProjectEmployee(List <Integer> listId, int projectId) {
		SessionFactory sessionFactory = SessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Project project = session.get(Project.class, projectId);
		List <Employee> employee = session.createQuery("select emp from Employee emp where emp.employeeId IN :listId").setParameter("listId", listId).getResultList();
		System.out.println("employee list" + employee);
		Set <Employee> employeeSet = new HashSet <Employee>(employee);
		project.setEmployeeSet(employeeSet);
		session.save(project);
		transaction.commit();
		session.close();
	}

	/**
	 * ViewProjectEmployee() is used to view the project employee details
	 */
	@Override
	public List <Project> viewProjectEmployee() {
		SessionFactory sessionFactory = SessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		List <Project> project = session.createQuery("from Project", Project.class).getResultList();
		return project;
	}

	/**
	 * ViewProjectEmployeeById is used to view the project employee via Id
	 */
	@Override
	public Project viewProjectEmployeeById(int projectId) {
		SessionFactory sessionFactory = SessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		Project project = session.get(Project.class, projectId);
		return project;
	}
}
