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
    public int insertEmployee(String companyName, double salary, String designation, int experience,
    		String name, long phoneNumber, String dateOfBirth, String emailId, Address currentAddress, Address permanentAddress);
    public List <Employee>viewEmployee();

   // public List<HashMap<String, Object>> viewSingleEmployee(int employeeId);

    public List<Integer> deleteEmployee(int employeeId, String addressType);

    public Address addAddressValues(String street, String city, String district, String state, int pinCode, String addressType);

   // public List<Integer> checkEmployeeData(int employeeId, long phoneNumber, String emailId);

    //public String updatePersonalDetails(int employeeId, long phoneNumber, String emailId);

    public String checkEmailId(String emailId);

    public long checkPhoneNumber(long phoneNumber);

    public String checkDateOfBirth(String dateOfBirth);
}
