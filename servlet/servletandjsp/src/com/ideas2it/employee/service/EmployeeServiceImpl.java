/**
 * Provide the class necessary to create a service class
 * To communicate with controller and model classes
 *
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.employee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ideas2it.employee.dao.EmployeeDaoImpl;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.model.PersonalDetails;
//import com.ideas2it.util.Validator;

/**
 * @description EmployeeService used to hold PersonalDetails,Address,Employee
 * We can view, remove, add, update operations in employee data
 * Meanwhile validating employee data
 * @author GAYATHIRI
 * @version 1.2
 */
public class EmployeeServiceImpl implements EmployeeService {
	//Validator validator = new Validator();
	EmployeeDaoImpl employeeDAO = new EmployeeDaoImpl();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String insertEmployee(String companyName, double salary, String designation, int experience, String status,
			String name, long phoneNumber, String dateOfBirth, String emailId, HashMap <String, Object> currentAddressMap , HashMap <String, Object> permanentAddressMap) {
		String mobileNumber = Long.toString(phoneNumber);
		PersonalDetails personalDetails = new PersonalDetails(name, emailId, dateOfBirth, mobileNumber);
		Address currentAddress = addAddressValues(currentAddressMap);
		Address permanentAddress = addAddressValues(permanentAddressMap);
		Set <Address> address = new HashSet <Address> ();
		address.add(currentAddress);
		address.add(permanentAddress);
		personalDetails.setAddressSet(address);
		Employee employee = new Employee(companyName, salary, experience, designation, status);
		employee.setPersonalDetails(personalDetails);
		employeeDAO.insertEmployee(employee.getSalary(), employee.getCompanyName(),
				employee.getDesignation(), employee.getExperience(), employee.getStatus(), personalDetails.getName(), personalDetails.getPhoneNumber(), personalDetails.getEmailId(), 
				personalDetails.getDateOfBirth(), currentAddress, permanentAddress);
		return "INSERTED SUCCESSFULLY";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Employee> getAllEmployee() {
		return employeeDAO.viewEmployee();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Employee getEmployee(int employeeId) {
		return employeeDAO.employeeViewById(employeeId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String deleteEmployee(int employeeId) {
		employeeDAO.deleteEmployee(employeeId);
		return "DELETED SUCCESSFULLY";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Address addAddressValues(HashMap <String, Object> employeeMap) {
		String street = (String) employeeMap.get("Street");
		String city = (String) employeeMap.get("City");
		String district = (String) employeeMap.get("District");
		String state = (String) employeeMap.get("State");
		String addressType = (String) employeeMap.get("AddressType");
		int pinCode = (int) employeeMap.get("PinCode");
		Address addressValues = new Address(street, city, district, pinCode, state, addressType);
		return addressValues;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Integer> validateEmployeeData(long phoneNumber, String emailId) {
		return employeeDAO.isDuplicate(phoneNumber, emailId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String updatePersonalDetails(int employeeId, long phoneNumber, String emailId) {
		List<Integer> employeeList = new ArrayList<Integer>();
		employeeList = validateEmployeeData(phoneNumber, emailId);
		if (employeeList.get(0) == 0 && employeeList.get(1) == 0) {
			employeeDAO.updatePersonalDetails(employeeId, phoneNumber, emailId);
			return "UPDATED SUCCESSFULLY";
		} else {
			return "ALREADY EXIXTS  DUPLICATE VALUE";
		}
	}

	/**
	 * {@inheritDoc}
	 
	@Override
	public boolean isEmailIdValid(String emailId) {
		//System.out.println(validator.isEmailIdValid(emailId));
		return validator.isEmailIdValid(emailId);
	}

	/**
	 * {@inheritDoc}
	 
	@Override
	public boolean isPhoneNumberValid(long phoneNumber) {
		return validator.isPhoneNumberValid(phoneNumber);
	}

	/**
	 * {@inheritDoc}
	 
	@Override
	public boolean isDateOfBirthValid(String dateOfBirth) {
		return validator.isDateValid(dateOfBirth);
	}

	/**
	 * {@inheritDoc}
	 *
	@Override
	public void addProjectEmployee(List <Integer> listId, int employeeId) {
		employeeDAO.addProjectEmployee(listId, employeeId);
	}*/
}

