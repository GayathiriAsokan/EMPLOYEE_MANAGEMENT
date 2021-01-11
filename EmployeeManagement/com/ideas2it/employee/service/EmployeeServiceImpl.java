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
import java.util.List;

import com.ideas2it.employee.dao.EmployeeDao;
import com.ideas2it.employee.dao.EmployeeDaoImpl;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.model.PersonalDetails;
import com.ideas2it.employee.util.EmployeeUtil;

/**
 * @description EmployeeService used to hold PersonalDetails,Address,Employee
 * We can view, remove, add, update operations in employee data
 * Meanwhile validating employee data
 * @author GAYATHIRI
 * @version 1.2
 */
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeUtil employeeUtil = new EmployeeUtil();
    EmployeeDaoImpl employeeDAO = new EmployeeDaoImpl();

    /**
     * InsertEmployee is used to inserting the data and getting the values from user
     * Add all  employee details in the employeeMap
     * @param employeeId int - property in employee
     * @param companyName String -  property in employee
     * @param salary long - property in employee
     //* @param pinCode int - property in address
     * @param name String - property in Personal details
    // * @param state String - property in address
     * @param phoneNumber long - property in Personal details
     * @param dateOfBirth String - property in Personal details
     //* @param city String -  property in address
     * @param emailId String -  property in Personal details
    // * @param district String -  property in address
     //* @param street string -  property in address
     * @return String - to return message status of the employee details
     */
    @Override
    public int insertEmployee(String companyName, double salary, String designation, int experience, 
                             String name, long phoneNumber, String dateOfBirth, String emailId, Address currentAddress, Address permanentAddress) {
       String mobileNumber = Long.toString(phoneNumber);
       PersonalDetails personalDetails = new PersonalDetails(name, emailId, dateOfBirth, mobileNumber);
       List <Address> address = new ArrayList <Address>();
       address.add(currentAddress);
       address.add(permanentAddress);
       personalDetails.setAddressList(address);
       System.out.println(personalDetails);
       Employee employee = new Employee(companyName, salary, experience, designation);
       employee.setPersonalDetails(personalDetails);
       int countInsertedRow = employeeDAO.insertEmployee(employee.getSalary(), employee.getCompanyName(),
               employee.getDesignation(), employee.getExperience(), personalDetails.getName(), personalDetails.getPhoneNumber(), personalDetails.getEmailId(), 
               personalDetails.getDateOfBirth(), currentAddress, permanentAddress);
       //if (countInsertedRow != 0) {
          // countInsertedRow = employeeDAO.insertPersonalDetails(employeeId, personalDetails.getName(),
               //     personalDetails.getPhoneNumber(), personalDetails.getEmailId(), personalDetails.getDateOfBirth());
           // if (countInsertedRow != 0) {
             //   countInsertedRow = employeeDAO.insertAddress(employeeId, );
               // if (countInsertedRow != 0) {
                    //return "EMPLOYEE DATA ADDED SUCCESSFULLY";
               // } else {
              //      return "INVALID ADDRESS DATA";
               // }
           // } else {
               // return "INVALID PERSONAL DATA";
         //  }
      //  } else {
           // return "INVALID EMPLOYEE DATA";
      //  }
        return countInsertedRow;
    }

    /**
     * ViewEmployee is used show the employee details 
     * Values in the EmployeeMap are displayed 
     * @return employeeMap Map <Integer,Employee> - to print employee details
     */
    @Override
    public List <Employee> viewEmployee() {
        return employeeDAO.viewEmployee();
    }


    /**
     * ViewsingleData method  used to display the employee data
     * It prints a row from a EmployeeMap
     * @param employeeId int - to display the employee data
     * @return List<HashMap<String, Object>> - to print the employee details
     
    @Override
    public List<HashMap<String, Object>> viewSingleEmployee(int employeeId) {
        return employeeDAO.viewEmployee();
    }

    /**
     * DeleteData method used to delete the employee data
     * @param employeeId int - to check employeedata is present or not
     * @return List<Integer>  - to print delted or not
     */
    @Override
    public List<Integer> deleteEmployee(int employeeId, String addressType) {
        List<Integer> employeeList = new ArrayList<Integer>();
        employeeList.add(employeeDAO.deleteAddress(addressType));
        //employeeList.add(employeeDAO.deleteEmployee(employeeId));
        return employeeList;
    }

    /**
     * AddAddressValues used to set the address details in Address
     * @param street String - property in Address
     * @param city String - property in Address
     * @param state String - property in Address
     * @param district String - property in Address
     * @param pinCode int - property in Address
     * @return AddressValues Address - return the address details  to the getAddressValues
     */
    @Override
    public Address addAddressValues(String street, String city, String district, String state, int pinCode, String addressType) {
        //PersonalDetails personalDetails = new PersonalDetails();
        Address addressValues = new Address(street, city, district, pinCode, state, addressType);
        //personalDetails.setAddressList(address);
        return addressValues;
    }

    /**
     * CheckEmployeeData is used  for duplication check
     * @param emailId String - validate emailId
     * @param  employeeId int
     * @param phoneNumber long
     * @return employeeList List <Integer> 
     
    @Override
    public List<Integer> checkEmployeeData(int employeeId, long phoneNumber, String emailId) {
        return employeeDAO.isDuplicate(employeeId, phoneNumber, emailId);
    }*/

    /**
     * UpdatePhoneNumber to change the value of phone number in employeeMap
     * @param employeeId int - to get the personal details object
     * @param phoneNumber long - check for validation and duplication
     
    @Override
    public String updatePersonalDetails(int employeeId, long phoneNumber, String emailId) {
        List<Integer> employeeList = new ArrayList<Integer>();
        employeeList = checkEmployeeData(employeeId, phoneNumber, emailId);
        if (employeeList.get(0) != 0 && employeeList.get(1) == 0 && employeeList.get(2) == 0) {
            employeeDAO.updatePersonalDetails(employeeId, phoneNumber, emailId);
            return "UPDATED SUCCESSFULLY";
        } else {
            return "ALREADY EXIXTS  DUPLICATE VALUE";
        }
    }*/

    /**
     * CheckEmailId is used  for validation and duplication check
     * @param emailId String - validate emailId
     * @return emailId String - used to check whether it is a proper emailId or not
     */
    @Override
    public String checkEmailId(String emailId) {
        return employeeUtil.checkEmailId(emailId);
    }

    /**
     * CheckphoneNumber is used  for validation and duplication check
     * @param phoneNumber long - validate phoneNumber
     * @return phoneNumber long - used to check whether it is a proper phoneNumber or not
     */
    @Override
    public long checkPhoneNumber(long phoneNumber) {
        return employeeUtil.checkPhoneNumber(phoneNumber);
    }

    /**
     * CheckDateOfBirth is used  for validation 
     //* @param DateOfBirth String - validate DateOfBirth
     * @return DateOfBirth String - used to check whether it is a proper DateOfBirth or not
     */
    @Override
    public String checkDateOfBirth(String dateOfBirth) {
        return employeeUtil.checkDateOfBirth(dateOfBirth);
    }
}

