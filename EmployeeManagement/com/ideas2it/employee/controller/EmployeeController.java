/**
 * Provide the class necessary to create an controller class
 * To communicate with user and the service 
 * Used to view the employee details
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.employee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ideas2it.EmployeeManagement;
import com.ideas2it.employee.dao.EmployeeDao;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.service.EmployeeService;

/**
 * @description EmployeeController implements an application that is used to hold EmployeeService
 * Displays employee details by adding,viewing,deleting,updating them 
 * @author GAYATHIRI
 * @version 1.2
 */
public class EmployeeController {	
    Scanner scanner = new Scanner(System.in);
    EmployeeService employeeService = new EmployeeService();

    /**
     * In this method we can view, remove, add, update employee data
     */
    public void employeeDetails() {
        boolean checkCase = true;
        do {
            System.out.println("\n1.INSERT \n2.DELETE  \n3.UPDATE \n4.VIEW LIST \n5.VIEW\n6.EXIT");
            System.out.println("Enter The Option");
            int pickCase = scanner.nextInt();
            switch (pickCase) {
                case 1:
                    System.out.println("THE DATA YOU WANT TO INSERT");
                    addEmployee();
                    break;
                case 2:
                    System.out.println("DELETE THE DATA");
                    System.out.println("ENTER EMPLOYEE ID");
                    int employeeId = scanner.nextInt();
		                  System.out.println("ENTER YOUR ADDRESS  TYPE");
                    String addressType = scanner.next();
                    System.out.println(employeeService.deleteEmployee(employeeId, addressType) + "\n DELETED SUCCESSFULLY");
                    break;
                case 3:
                    System.out.println("UPDATE THE DATA");
                    updateEmployee();
                    break;
                case 4:
                    System.out.println("VIEW THE LIST OF DATA");
                    List <HashMap <String, Object>> employeeList = employeeService.viewEmployee();
                    System.out.println(" EmployeeId \t Name \t PhoneNumber \t Salary \t EmailId \t State"); 
                    for (int listIndex = 0; listIndex < employeeList.size(); listIndex ++) {
                        HashMap <String, Object> employeeMap = employeeList.get(listIndex); 
                        System.out.println(employeeMap.get("EmployeeId") + "\t\t" + employeeMap.get("Name") + "\t" + 
                                         employeeMap.get("PhoneNumber") + "\t\t" + employeeMap.get("Salary") + "\t" +
                                         employeeMap.get("EmailId")  + "\t\t" +employeeMap.get("State"));
                    } 
                    System.out.println("\nDATA FROM MAP IS PRINTED");
                    break;
                case 5:
                    System.out.println("VIEW THE SINGLE ROW");
                    System.out.println("ENTER EMPLOYEE ID");
                    employeeId = scanner.nextInt();
                    System.out.println("\n" + employeeService.viewSingleEmployee(employeeId));
                    break;
                case 6:
                    checkCase = false;
                    break; 
                default:
            }     
        } while (checkCase);
    }

    /**
     * AddEmployee is used to get the values from the user
     */
    public void addEmployee() {
        System.out.println("Enter Your Emloyeeid");
		      int employeeId = scanner.nextInt();
        System.out.println("Enter Your Projectid");
		      int projectId = scanner.nextInt();
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
        List <Integer> employeeList = employeeService.checkEmployeeData(employeeId, phoneNumber, emailId);
        if (employeeList.get(0) > 0 ) {
              System.out.println( "Duplicate EmployeeId");
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

