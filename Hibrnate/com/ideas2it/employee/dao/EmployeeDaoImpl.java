/**
 * Provide the class necessary to create a dao class
 * To communicate with service and model classes
 *
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.employee.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.model.PersonalDetails;
import com.ideas2it.project.model.Project;
import com.ideas2it.sessionManagement.SessionManagement;

/**
 * @description EmployeeDao made jdbc connectivity using hibernate for the employeeApplication
 * @author GAYATHIRI
 * @version 1.0
 */
public class EmployeeDaoImpl implements EmployeeDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertEmployee(Employee employee, PersonalDetails personalDetails, Address currentAddress, Address permanentAddress) {
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		employee.setPersonalDetails(personalDetails);
		currentAddress.setPersonalDetails(personalDetails); 
		permanentAddress.setPersonalDetails(personalDetails);
		session.save(employee);
		session.save(personalDetails);
		session.save(currentAddress);
		session.save(permanentAddress);
		transaction.commit();
		session.close();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List <Employee> viewEmployee() {
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		List <Employee> employeeList = session.createQuery("from Employee", Employee.class).getResultList();
		return employeeList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override 
	public Employee employeeViewById(int employeeId) {
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, employeeId);
		return employee;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Integer> isDuplicate(long phoneNumber, String emailId) {
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String mobileNumber = Long.toString(phoneNumber);
		Criteria criteria = session.createCriteria(PersonalDetails.class);
		criteria.add(Restrictions.eq("phoneNumber", mobileNumber));
		List phoneList = criteria.list();
		List <Integer> employeeList = new ArrayList();
		employeeList.add(phoneList.size());
		Criteria criteriaEmailId = session.createCriteria(PersonalDetails.class);
		criteriaEmailId.add(Restrictions.eq("emailId", emailId));
		List emailIdList = criteriaEmailId.list();
		employeeList.add(emailIdList.size());
		transaction.commit();
		session.close();
		return employeeList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int deleteEmployee(int employeeId) {
		int countEmployee = 0;
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query deleteQuery = session.createQuery("update Employee employee set status = 'INACTIVE' where employee.employeeId = :employeeId");
		deleteQuery.setParameter("employeeId", employeeId);
		countEmployee =  deleteQuery.executeUpdate();
		transaction.commit();
		session.close();
		return countEmployee;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int updatePersonalDetails(int employeeId, long phoneNumber, String emailId) {
		int updateCount = 0, personalId = 0;
		Employee employee = employeeViewById(employeeId);
		PersonalDetails personalDetails = employee.getPersonalDetails();
		personalId = personalDetails.getPersonalId();
		SessionFactory sessionFactory = SessionManagement.getInstance();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String mobileNumber = Long.toString(phoneNumber);
		Query UpdateQuery = session.createQuery("update PersonalDetails personalDetails set personalDetails.phoneNumber = :mobileNumber, personalDetails.emailId = :emailId where personalDetails.personalId = :personalId");
		UpdateQuery.setParameter("mobileNumber", mobileNumber);
		UpdateQuery.setParameter("emailId", emailId);
		UpdateQuery.setParameter("personalId", personalId);
		updateCount =  UpdateQuery.executeUpdate();
		transaction.commit();
		session.close();
		return updateCount;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addProjectEmployee(List <Integer> listId, int employeeId) {
		SessionFactory sessionFactory = SessionManagement.getInstance();
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
}
