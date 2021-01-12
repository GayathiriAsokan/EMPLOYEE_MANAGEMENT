/**
 * Provide the interface necessary to create a EmployeeServiceImpl
 * To communicate with service class
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.employee.service;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;

import java.util.HashMap;
import java.util.List;

/**
 * @description To communicate with service class
 * @author GAYATHIRI
 * @version 1.0
 */
public interface EmployeeService {
	/*
	 * Insert values in database using hibernate
	 */
    public int insertEmployee(String companyName, double salary, String designation, int experience,
    		String name, long phoneNumber, String dateOfBirth, String emailId, Address currentAddress, Address permanentAddress);
    /*
	 * View values from database using hibernate
	 */
    public List<Employee> viewEmployee();
    
    /*
     * View values by  Id from database using hibernate
     */
    public Employee viewSingleEmployee(int employeeId);
    
    /*
	 * Delete values in employee in database using hibernate
	 */
    public List<Integer> deleteEmployee(int employeeId, String addressType);
    
    /*
     * Add address values in employee
     */
    public Address addAddressValues(String street, String city, String district, String state, int pinCode, String addressType);

    /*
     * checkEmployeeData used for employee duplication
     */
    public List<Integer> checkEmployeeData(int employeeId, long phoneNumber, String emailId);

    /*
     * updatePersonalDetails used for update employee using hibernate
     */
    public String updatePersonalDetails(int employeeId, long phoneNumber, String emailId);

    /*
     * checkEmailId used for validation
     */
    public String checkEmailId(String emailId);

    /*
     * checkPhoneNumber used for validation
     */
    public long checkPhoneNumber(long phoneNumber);

    /*
     * checkDateOfBirth used for validation
     */
    public String checkDateOfBirth(String dateOfBirth);
}
