/**
 * Provide the class necessary to create an controller class
 * To communicate with user and the service
 * Used to view the employee details
 * @version 1.3
 * @since 1.1
 */
package com.ideas2it.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.service.EmployeeService;

/**
 * @description EmployeeController implements an application that is used to hold EmployeeService
 * Displays employee details by adding,viewing,deleting,updating them 
 * @author GAYATHIRI
 * @version 1.3
 */
public class EmployeeController {
    Scanner scanner = new Scanner(System.in);
    EmployeeService employeeService = new EmployeeService();

    /**
     * DeleteData method used to delete the employee data
     * @return List<Integer> - to print deleted count
     */
    public List<Integer> deleteEmployee() {
        System.out.println("ENTER EMPLOYEE ID");
        int employeeId = scanner.nextInt();
        System.out.println("ENTER YOUR ADDRESS  TYPE");
        String addressType = scanner.next();
        return employeeService.deleteEmployee(employeeId, addressType);
    }

    /**
     * ViewEmployee is used show the employee details
     * Values in the EmployeeMap are displayed
     * @return employeeMap Map <Integer,Employee> - to print employee details
     */
    public List<HashMap<String, Object>> viewEmployee() {
        return employeeService.viewEmployee();
    }

    /**
     * ViewsingleData method  used to display the employee data
     * It prints a row from a EmployeeMap
     * @return List<HashMap<String, Object>>  - to print the employee details
     */
    public List<HashMap<String, Object>> viewSingleEmployee() {
        System.out.println("ENTER EMPLOYEE ID");
        int employeeId = scanner.nextInt();
        return employeeService.viewSingleEmployee(employeeId);
    }

    /**
     * AddEmployee is used to get the values from the user
     */
    public void addEmployee() {
        System.out.println("Enter Your Emloyeeid");
        int employeeId = scanner.nextInt();
        System.out.println("Enter Your Companyname");
        String companyName = scanner.next();
        System.out.println("Enter Your Salary");
        long salary = scanner.nextLong();
        System.out.println("Enter Your Designatiion");
        String designation = scanner.next();
        System.out.println("Enter Your Experience(Years)");
        int experience = scanner.nextInt();
        System.out.println("Enter Your Name");
        String name = scanner.next();
        long phoneNumber = checkPhoneNumber();
        String dateOfBirth = checkDateOfBirth();
        String emailId = checkEmailId();
        List<Integer> employeeList = employeeService.checkEmployeeData(employeeId, phoneNumber, emailId);
        if (employeeList.get(0) > 0) {
            System.out.println("Duplicate EmployeeId");
        } else if (employeeList.get(1) > 0) {
            System.out.println("Duplicate Phonenumber");
        } else if (employeeList.get(2) > 0) {
            System.out.println("Duplicate Emailid");
        } else {
            Address currentAddress = getAddressValues();
            Address permanentAddress = getAddressValues();
            String messageStatus = employeeService.insertEmployee(employeeId, companyName, salary, designation, experience,
                    currentAddress, permanentAddress, name, phoneNumber, dateOfBirth, emailId);
            System.out.println(messageStatus);
        }
    }

    /**
     * GetAddressValues is used to get address details from user
     * @return address  Address - return address details in this method
     */
    public Address getAddressValues() {
        System.out.println("Enter Your Street");
        String street = scanner.next();
        System.out.println("Enter Your City");
        String city = scanner.next();
        System.out.println("Enter Your District");
        String district = scanner.next();
        System.out.println("Enter Your State");
        String state = scanner.next();
        System.out.println("Enter Your Pincode");
        int pinCode = scanner.nextInt();
        return employeeService.addAddressValues(street, city, district, state, pinCode);
    }

    /**
     * UpdateEmployee is used to change the value from employee details
     */
    public void updateEmployee() {
        System.out.println("ENTER YOUR EMPLOYEEID");
        int employeeId = scanner.nextInt();
        System.out.println("ENTER PHONE NUMBER");
        long phoneNumber = scanner.nextLong();
        System.out.println("ENTER EMAILID");
        String emailId = scanner.next();
        System.out.println(employeeService.updatePersonalDetails(employeeId, phoneNumber, emailId));
    }

    /**
     * CheckValidationMobile user need to enter phone number repeatedly until a valid phone number
     * @return phoneNumber long - to set the value in employeeMap 
     */
    public long checkPhoneNumber() {
        System.out.println("Enter Your Phonenumber");
        long phoneNumber = scanner.nextLong();
        phoneNumber = employeeService.checkPhoneNumber(phoneNumber);
        if (phoneNumber == 0) {
            checkPhoneNumber();
        }
        return phoneNumber;
    }

    /**
     * This method checkValidateEmail user need to enter emailId repeatedly until a valid emailId
     * @return emailId String - to set the value in employeeMap 
     */
    public String checkEmailId() {
        System.out.println("Enter Your Emailid");
        String emailId = scanner.next();
        emailId = employeeService.checkEmailId(emailId);
        if (emailId == null) {
            checkEmailId();
        }
        return emailId;
    }

    /**
     * CheckDateOfBirth user need to enter dateOfBirth  repeatedly until a valid dateofbirth
     * @return dateOfBirth String - to set the value in employeeMap 
     */
    public String checkDateOfBirth() {
        System.out.println("Enter Your Date of birth in the format yyyy/MM/dd");
        String dateOfBirth = scanner.next();
        dateOfBirth = employeeService.checkDateOfBirth(dateOfBirth);
        if (dateOfBirth == null) {
            checkDateOfBirth();
        }
        return dateOfBirth;
    }
}

