/**
 * Provide the class necessary to create a dao class
 * To communicate with service and model classes
 *
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.employee.dao;

import java.util.ArrayList;
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
import sessionManagement.SessionManagement;

/**
 * @description EmployeeDao made jdbc connectivity using hibernate for the employeeApplication
 * @author GAYATHIRI
 * @version 1.0
 */
public class EmployeeDaoImpl implements EmployeeDao {
	SessionManagement sessionManagement = new SessionManagement();

	/**
	 * InsertEmployee is used to insert the employee data using insert query
	 */
	@Override
	public int insertEmployee(double salary, String companyName, String designation, int experience, String name, String  phoneNumber, String emailId, String dateOfBirth, Address currentAddress, Address permanentAddress) {
		SessionFactory sessionFactory = sessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = new Employee(companyName, salary, experience,designation); 
		PersonalDetails personalDetails = new PersonalDetails(name, emailId, dateOfBirth, phoneNumber);
		employee.setPersonalDetails(personalDetails);
		currentAddress.setPersonalDetails(personalDetails); 
		permanentAddress.setPersonalDetails(personalDetails);
		session.save(employee);
		session.save(personalDetails);
		session.save(currentAddress);
		session.save(permanentAddress);
		transaction.commit();
		session.close();
		int rowCount = 0;
		return rowCount;
	}

	/**
	 * ViewEmployee is used to view the employee details using select query
	 */
	@Override
	public List <Employee> viewEmployee() {
		SessionFactory sessionFactory = sessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		List <Employee> employeeList = session.createQuery("from Employee", Employee.class).getResultList();
		return employeeList;
	}

	/**
	 * EmployeeViewById is used to view employee in hibernate using id
	 */
	@Override 
	public Employee employeeViewById(int employeeId) {
		SessionFactory sessionFactory = sessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, employeeId);
		return employee;
	}

	/**
	 * IsDuplicate is used to check value already present in the Personal_details table or not
	 */
	@Override
	public List<Integer> isDuplicate(long phoneNumber, String emailId) {
		SessionFactory sessionFactory = sessionManagement.getSessionFactory();
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
	 * DeleteAddress is used to delete entries in Address table
	 */
	@Override
	public int deleteAddress(int employeeId, String addressType) {
		int countAddress = 0, addressId =0;
		Employee employee = employeeViewById(employeeId);
		PersonalDetails personalDetails = employee.getPersonalDetails();
		Set <Address> address= personalDetails.getAddressSet();
		for (Address address_details : address) {
			if  (address_details.getAddressType().equals(addressType)) {
				addressId = address_details.getAddressId(); 	 
			}
		}
		SessionFactory sessionFactory = sessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query hqlquery = session.createQuery("delete from Address address where address.addressId = :addressId and address.addressType = :addressType");
		hqlquery.setParameter("addressId",addressId);
		hqlquery.setParameter("addressType", addressType);
		countAddress = hqlquery.executeUpdate();
		transaction.commit();
		session.close();
		return countAddress;
	}

	/**
	 * DeleteEmployee is used to delete entries in Employee
	 */
	@Override
	public int deleteEmployee(int employeeId) {
		int countEmployee = 0;
		SessionFactory sessionFactory = sessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query deleteQuery = session.createQuery("update Employee employee set designation = null where employee.employeeId = :employeeId");
		deleteQuery.setParameter("employeeId", employeeId);
		countEmployee =  deleteQuery.executeUpdate();
		transaction.commit();
		session.close();
		return countEmployee;
	}

	/**
	 * UpdatePersonalDetails is used to change the Personal_details values of emailId, phoneNumber
	 */
	@Override
	public int updatePersonalDetails(int employeeId, long phoneNumber, String emailId) {
		int updateCount = 0, personalId = 0;
		Employee employee = employeeViewById(employeeId);
		PersonalDetails personalDetails = employee.getPersonalDetails();
		personalId = personalDetails.getPersonalId();
		SessionFactory sessionFactory = sessionManagement.getSessionFactory();
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
}
