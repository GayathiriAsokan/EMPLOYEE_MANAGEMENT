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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sessionManagement.SessionManagement;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.model.PersonalDetails;
/**
 * @author GAYATHIRI
 * @version 1.0
 * @description EmployeeDao made jdbc connectivity for the employeeApplication
 * Using database we can insert ,update,select,delete data using sql query
 */
public class EmployeeDaoImpl implements EmployeeDao {
	SessionManagement sessionManagement = new SessionManagement();

	/**
	 * InsertEmployee is used to insert the employee data using insert query
	 *
	 * @param employeeId  int
	 * @param salary      String
	 * @param companyName String
	 * @return rowCount int - to find whether the employee data inserted or not
	 */
	@Override
	public int insertEmployee(double salary, String companyName, String designation, int experience, String name, String  phoneNumber, String emailId, String dateOfBirth, Address currentAddress, Address permanentAddress) {
		SessionFactory sessionFactory = SessionManagement.getSessionFactory();
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
	 * @param employeeId int
	 * @param viewFlag   boolean
	 * @return employeeList List <Employee>
	 */
	@Override
	public List <Employee> viewEmployee() {
		SessionFactory sessionFactory = SessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		List <Employee> employeeList = session.createQuery("from Employee", Employee.class).getResultList();
		return employeeList;
	}

	@Override 
	public Employee employeeViewById(int employeeId) {
		SessionFactory sessionFactory = SessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, employeeId);
		return employee;
	}

	/**
	 * IsDuplicate is used to check value already present in the Personal_details table or not
	 * @param employeeId  int
	 * @param emailId     String
	 * @param phoneNumber long
	 * @return employeeList List <Integer>  - to find how many rows affected
	 */
	@Override
	public List<Integer> isDuplicate(long phoneNumber, String emailId) {
		int countPhoneNumber = 0, countEmailId = 0;
		List<Integer> employeeList = new ArrayList<Integer>();
		SessionFactory sessionFactory = SessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		employeeList.add(0);
//		Query checkQuery = session.createQuery("from PersonalDetails personalDetails where personalDetails.phoneNumber = :phoneNumber", PersonalDetails.class);
//		checkQuery.setParameter("phoneNumber", phoneNumber);
//		countPhoneNumber = checkQuery.getFirstResult();
//		employeeList.add(countPhoneNumber);
		Query hqlQuery = session.createQuery("from PersonalDetails  personalDetails where personalDetails.emailId = :emailId", PersonalDetails.class);
		hqlQuery.setParameter("emailId", emailId);
		countEmailId = hqlQuery.getFirstResult();
		employeeList.add(countEmailId);
		transaction.commit();
		session.close();
		System.out.println(employeeList);
		return employeeList;
	}

	/**
	 * DeleteAddress is used to delete entries in Address table
	 *
	 * @return countAddress int- to find how many rows affected
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
		SessionFactory sessionFactory = SessionManagement.getSessionFactory();
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
	 * @return countEmployee int - to find how many rows affected
	 */
	@Override
	public int deleteEmployee(int employeeId) {
		int countEmployee = 0;
		SessionFactory sessionFactory = SessionManagement.getSessionFactory();
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
	 *
	 * @param employeeId  int
	 * @param emailId     String
	 * @param phoneNumber long
	 * @return updateCount int -to check the modification or done in a table or not
	 */
	@Override
	public int updatePersonalDetails(int employeeId, long phoneNumber, String emailId) {
		int updateCount = 0, personalId = 0;
		Employee employee = employeeViewById(employeeId);
		PersonalDetails personalDetails = employee.getPersonalDetails();
		personalId = personalDetails.getPersonalId();
		SessionFactory sessionFactory = SessionManagement.getSessionFactory();
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
