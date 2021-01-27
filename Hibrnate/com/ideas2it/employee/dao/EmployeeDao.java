/**
 * Provide the interface necessary to create EmployeeDaoImpl
 * To communicate with EmployeeDao
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.employee.dao;

import java.util.List;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.model.PersonalDetails;

/**
 * @description EmployeeDaoImpl to communicate with EmployeeDao
 * @version 1.0
 * @author GAYATHIRI
 */
public interface EmployeeDao {

	/**
	 * Insert values in database using hibernate
	 * 
	 * @param employeeId  int
	 * @param salary      String
	 * @param companyName String
	 * @return rowCount int - to find whether the employee data inserted or not
	 */
	public void insertEmployee(Employee employee, PersonalDetails personalDetails, Address currentAddress, Address permanentAddress) ;

	/**
	 * View values from database using hibernate
	 * 
	 * @param employeeId int
	 * @param viewFlag   boolean
	 * @return employeeList List <Employee>
	 */
	public List <Employee> viewEmployee();

	/**
	 * View values by  Id from database using hibernate
	 * @param employeeId int 
	 * @return Employee
	 */
	public Employee employeeViewById(int employeeId);

	/**
	 * IsDuplicate from database using hibernate
	 *  
	 * @param employeeId  int
	 * @param emailId     String
	 * @param phoneNumber long
	 * @return employeeList List <Integer>  - to find how many rows affected
	 */
	public List<Integer> isDuplicate(long phoneNumber, String emailId);

	/**
	 * Delete values in employee table database using hibernate
	 * 
	 * @return countEmployee int - to find how many rows affected
	 */
	public int deleteEmployee(int employeeId);

	/**
	 * Update values in database using hibernate
	 * 
	 * @param employeeId  int
	 * @param emailId     String
	 * @param phoneNumber long
	 * @return updateCount int -to check the modification or done in a table or not
	 */
	public int updatePersonalDetails(int employeeId, long phoneNumber, String emailId);
	
	/**
	 * AddProjectEmployee is used to add details in project and employee
	 * 
	 * @param listId
	 * @param employeeId
	 */
	public void addProjectEmployee(List <Integer> listId, int employeeId);
}
