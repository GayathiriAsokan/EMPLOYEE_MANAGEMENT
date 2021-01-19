/**
 * Provide the interface necessary to create a EmployeeServiceImpl
 * To communicate with service class
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.employee.service;

import java.util.HashMap;
import java.util.List;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;

/**
 * @description To communicate with service class
 * @author GAYATHIRI
 * @version 1.0
 */
public interface EmployeeService {

	/**
	 * Insert values in database using hibernate
	 * 
	 * @param employeeId int - property in employee
	 * @param companyName String -  property in employee
	 * @param salary long - property in employee
	 * @param pinCode int - property in address
	 * @param name String - property in Personal details
	 * @param state String - property in address
	 * @param phoneNumber long - property in Personal details
	 * @param dateOfBirth String - property in Personal details
	 * @param city String -  property in address
	 * @param emailId String -  property in Personal details
	 * @param district String -  property in address
	 * @param street string -  property in address
	 * @return String - to return message status of the employee details
	 */
	public int insertEmployee(String companyName, double salary, String designation, int experience,
			String name, long phoneNumber, String dateOfBirth, String emailId, HashMap <String, Object> currentAddressMap , HashMap <String, Object> permanentAddressMap);

	/**
	 * ViewEmployee is used show the employee details 
	 * Values in the EmployeeMap are displayed 
	 * 
	 * @return employeeMap Map <Integer,Employee> - to print employee details
	 */
	public List<Employee> getAllEmployee();

	/**
	 * ViewsingleData method  used to display the employee data
	 * 
	 * @param employeeId int - to display the employee data
	 * @return List<HashMap<String, Object>> - to print the employee details
	 */
	public Employee getEmployee(int employeeId);

	/**
	 * DeleteData method used to delete the employee data
	 * 
	 * @param employeeId int - to check employeedata is present or not
	 * @return List<Integer>  - to print delted or not
	 */
	public List<Integer> deleteEmployee(int employeeId, String addressType);

	/**
	 * AddAddressValues used to set the address details in Address
	 * @param employeeListValues
	 * @return
	 */
	public Address addAddressValues(HashMap <String, Object> employeeListValues);

	/**
	 * CheckEmployeeData is used  for duplication check
	 * 
	 * @param emailId String - validate emailId
	 * @param  employeeId int
	 * @param phoneNumber long
	 * @return employeeList List <Integer> 
	 */
	public List<Integer> validateEmployeeData(long phoneNumber, String emailId);

	/**
	 * UpdatePhoneNumber to change the value of phone number
	 * 
	 * @param employeeId int - to get the personal details object
	 * @param phoneNumber long - check for validation and duplication
	 */
	public String updatePersonalDetails(int employeeId, long phoneNumber, String emailId);

	/**
	 * IsEmailIdValid is used  for validation and duplication check
	 * 
	 * @param emailId String - validate emailId
	 * @return boolean
	 */
	public boolean isEmailIdValid(String emailId);

	/**
	 * IsPhoneNumberValid is used  for validation and duplication check
	 * 
	 * @param phoneNumber long - validate phoneNumber
	 * @return boolean
	 */
	public boolean isPhoneNumberValid(long phoneNumber);

	/**
	 * IsDateOfBirthValid is used  for validation 
	 * 
	 * @param DateOfBirth String - validate DateOfBirth
	 * @return boolean
	 */
	public boolean isDateOfBirthValid(String dateOfBirth);
	
	/**
	 * AddProjectEmployee is used to add project employee details
	 * 
	 * @param listId
	 * @param employeeId
	 */
	public void addProjectEmployee(List <Integer> listId, int employeeId);
}
