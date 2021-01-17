/**
 * Provide the class necessary to create a service class
 * To communicate with controller and model classes
 *
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.employee.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ideas2it.employee.dao.EmployeeDaoImpl;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.model.PersonalDetails;
import util.Validator;

/**
 * @description EmployeeService used to hold PersonalDetails,Address,Employee
 * We can view, remove, add, update operations in employee data
 * Meanwhile validating employee data
 * @author GAYATHIRI
 * @version 1.2
 */
public class EmployeeServiceImpl implements EmployeeService {
	Validator validator = new Validator();
	EmployeeDaoImpl employeeDAO = new EmployeeDaoImpl();

	/**
	 * InsertEmployee is used to inserting the data and getting the values from user
	 * Add all  employee details in the employeeMap
	 */
	@Override
	public int insertEmployee(String companyName, double salary, String designation, int experience, 
			String name, long phoneNumber, String dateOfBirth, String emailId, Address currentAddress, Address permanentAddress) {
		String mobileNumber = Long.toString(phoneNumber);
		PersonalDetails personalDetails = new PersonalDetails(name, emailId, dateOfBirth, mobileNumber);
		Set <Address> address = new HashSet <Address>();
		address.add(currentAddress);
		address.add(permanentAddress);
		personalDetails.setAddressSet(address);
		System.out.println(personalDetails);
		Employee employee = new Employee(companyName, salary, experience, designation);
		employee.setPersonalDetails(personalDetails);
		int countInsertedRow = employeeDAO.insertEmployee(employee.getSalary(), employee.getCompanyName(),
				employee.getDesignation(), employee.getExperience(), personalDetails.getName(), personalDetails.getPhoneNumber(), personalDetails.getEmailId(), 
				personalDetails.getDateOfBirth(), currentAddress, permanentAddress);
		return countInsertedRow;
	}

	/**
	 * ViewEmployee is used show the employee details 
	 * Values in the EmployeeMap are displayed 
	 */
	@Override
	public List<Employee> viewEmployee() {
		return employeeDAO.viewEmployee();
	}

	/**
	 * ViewsingleData method  used to display the employee data
	 */
	@Override
	public Employee viewSingleEmployee(int employeeId) {
		return employeeDAO.employeeViewById(employeeId);
	}

	/**
	 * DeleteData method used to delete the employee data
	 */
	@Override
	public List<Integer> deleteEmployee(int employeeId, String addressType) {
		List<Integer> employeeList = new ArrayList<Integer>();
		employeeList.add(employeeDAO.deleteAddress(employeeId, addressType));
		employeeList.add(employeeDAO.deleteEmployee(employeeId));
		return employeeList;
	}

	/**
	 * AddAddressValues used to set the address details in Address
	 */
	@Override
	public Address addAddressValues(String street, String city, String district, String state, int pinCode, String addressType) {
		Address addressValues = new Address(street, city, district, pinCode, state, addressType);
		return addressValues;
	}

	/**
	 * CheckEmployeeData is used  for duplication check
	 */
	@Override
	public List<Integer> checkEmployeeData(long phoneNumber, String emailId) {
		return employeeDAO.isDuplicate(phoneNumber, emailId);
	}

	/**
	 * UpdatePersonalDetails to change the value of phone number and emailId
	 */
	@Override
	public String updatePersonalDetails(int employeeId, long phoneNumber, String emailId) {
		List<Integer> employeeList = new ArrayList<Integer>();
		employeeList = checkEmployeeData(phoneNumber, emailId);
		if (employeeList.get(0) == 0 && employeeList.get(1) == 0) {
			employeeDAO.updatePersonalDetails(employeeId, phoneNumber, emailId);
			return "UPDATED SUCCESSFULLY";
		} else {
			return "ALREADY EXIXTS  DUPLICATE VALUE";
		}
	}

	/**
	 * CheckEmailId is used  for validation and duplication check
	 */
	@Override
	public String checkEmailId(String emailId) {
		return validator.checkEmailId(emailId);
	}

	/**
	 * CheckphoneNumber is used  for validation and duplication check
	 */
	@Override
	public long checkPhoneNumber(long phoneNumber) {
		return validator.checkPhoneNumber(phoneNumber);
	}

	/**
	 * CheckDateOfBirth is used  for validation 
	 */
	@Override
	public String checkDateOfBirth(String dateOfBirth) {
		return validator.checkDate(dateOfBirth);
	}
}

