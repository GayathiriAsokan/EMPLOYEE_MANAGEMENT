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

/**
 * @description EmployeeDaoImpl to communicate with EmployeeDao
 * @version 1.0
 * @author GAYATHIRI
 */
public interface EmployeeDao {
	
	/*
	 * Insert values in database using hibernate
	 */
    public int insertEmployee(double salary, String companyName, String designation, int experience, String name, String phoneNumber, String emailId, String dateOfBirth, Address currentAddress, Address permanentAddress);
    
    /*
	 * View values from database using hibernate
	 */
    public List <Employee> viewEmployee();
    
    /*
     * View values by  Id from database using hibernate
     */
    public Employee employeeViewById(int employeeId);

    /*
     * isDuplicate from database using hibernate
     */
    public List<Integer> isDuplicate(long phoneNumber, String emailId);

    /*
	 * Delete values in address in database using hibernate
	 */
    public int deleteAddress(int employeeId, String addressType);

    /*
	 * Delete values in employee table database using hibernate
	 */
    public int deleteEmployee(int employeeId);

    /*
	 * Update values in database using hibernate
	 */
    public int updatePersonalDetails(int employeeId, long phoneNumber, String emailId);
}
