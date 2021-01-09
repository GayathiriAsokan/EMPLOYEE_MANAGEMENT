/**
 * Provide the class necessary to create a dao class
 * To communicate with service and model classes
 *
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.employee.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.model.PersonalDetails;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ideas2it.employee.model.Address;
import org.hibernate.Transaction;

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
    public int insertEmployee(int employeeId, double salary, String companyName, String designation, int experience, int personalId,  String name, String  phoneNumber, String emailId, String dateOfBirth, Address currentAddress, Address permanentAddress) {
        System.out.println("EMPLOYEE DATA");
        SessionFactory sessionFactory = SessionManagement.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        Employee employee = new Employee(employeeId, companyName, salary, experience, designation);
        PersonalDetails personalDetails = new PersonalDetails(personalId, name, emailId, dateOfBirth, phoneNumber);
        employee.setPersonalDetails(personalDetails);
        personalDetails.setAddressList(currentAddress);
        personalDetails.setAddressList(permanentAddress);
        session.save(employee);
        t.commit();
        int rowCount = 0;
        return rowCount;
    }

    /**
     * ViewEmployee is used to view the employee details using select query
     *
     * @param employeeId int
     * @param viewFlag   boolean
     * @return employeeList List <Employee>
     */
    @Override
    public List<HashMap<String, Object>> viewEmployee(int employeeId, boolean viewFlag) {
        List<HashMap<String, Object>> employeeList = new ArrayList<HashMap<String, Object>>();
        return employeeList;
    }

    /**
     * IsDuplicate is used to check value already present in the Personal_details table or not
     * @param employeeId  int
     * @param emailId     String
     * @param phoneNumber long
     * @return employeeList List <Integer>  - to find how many rows affected
     */
    @Override
    public List<Integer> isDuplicate(int employeeId, double phoneNumber, String emailId) {
        List<Integer> employeeList = new ArrayList<Integer>();
        int countRow = 0;

        return employeeList;
    }

    /**
     * DeleteAddress is used to delete entries in Address table
     *
     * @return countAddress int- to find how many rows affected
     */
    @Override
    public int deleteAddress(int employeeId, String addressType) {
        int countAddress = 0;

        return countAddress;
    }

    /**
     * DeleteEmployee is used to delete entries in Employee
     *
     * @return countEmployee int - to find how many rows affected
     */
    @Override
    public int deleteEmployee(int employeeId) {
        int countEmployee = 0;
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
    public int updatePersonalDetails(int employeeId, double phoneNumber, String emailId) {
        int updateCount = 0;
        return updateCount;
    }
}
