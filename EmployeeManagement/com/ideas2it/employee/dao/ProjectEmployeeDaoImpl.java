/**
 * Provide the class necessary to create a dao class
 * To communicate with service and model classes
 *
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.employee.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	public void addProjectEmployee(List <Integer> listId, int employeeId) {
		SessionFactory sessionFactory = SessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = session.get(Employee.class, employeeId);
		List <Project> project = session.createQuery("select project from Project project where project.projectId IN :listId").setParameter("listId", listId).getResultList();
		System.out.println("employee list" + project);
		Set<Project> projectSet = new HashSet <Project>(project);
		employee.setProjectSet(projectSet);
		session.save(employee);
		transaction.commit();
		session.close();
	}

	/**
	 * ViewProjectEmployee() is used to view the project employee details
	 */
	@Override
	public List <Employee> viewProjectEmployee() {
		SessionFactory sessionFactory = SessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		List <Employee> employee = session.createQuery("from Employee", Employee.class).getResultList();
		return employee;
	}

	/**
	 * ViewProjectEmployeeById is used to view the project employee via Id
	 */
	@Override
	public Employee viewProjectEmployeeById(int employeeId) {
		SessionFactory sessionFactory = SessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, employeeId);
		return employee;
	}
}
