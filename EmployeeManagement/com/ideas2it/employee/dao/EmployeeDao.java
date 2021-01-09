/**
 * Provide the interface necessary to create EmployeeDaoImpl
 * To communicate with EmployeeDao
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.employee.dao;

import com.ideas2it.employee.model.Address;

import java.util.HashMap;
import java.util.List;

/**
 * @description EmployeeDaoImpl to communicate with EmployeeDao
 * @version 1.0
 * @author GAYATHIRI
 */
public interface EmployeeDao {
    public int insertEmployee(int employeeId, double salary, String companyName, String designation, int experience, int personalId, String name, String phoneNumber, String emailId, String dateOfBirth, Address currentAddress, Address permanentAddress);

    public List<HashMap<String, Object>> viewEmployee(int employeeId, boolean viewFlag);

    public List<Integer> isDuplicate(int employeeId, double phoneNumber, String emailId);

    public int deleteAddress(int employeeId, String addressType);

    public int deleteEmployee(int employeeId);

    public int updatePersonalDetails(int employeeId, double phoneNumber, String emailId);
}
