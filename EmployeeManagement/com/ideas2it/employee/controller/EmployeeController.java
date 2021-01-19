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
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.service.EmployeeServiceImpl;

/**
 * @description EmployeeController implements an application that is used to hold EmployeeService
 * Displays employee details by adding,viewing,deleting,updating them
 * @author GAYATHIRI
 * @version 1.2
 */
public class EmployeeController {
	Scanner scanner = new Scanner(System.in);
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
	List <HashMap <String, Object>> employeeListValues = new ArrayList <HashMap <String, Object>>();

	/**
	 * In this method we can view, remove, add, update employee data
	 */
	public void getEmployeeDetails() {
		boolean checkCase = true;
		try {
			do {
				System.out.println("\n1.INSERT \n2.DELETE \n3.UPDATE \n4.VIEW LIST \n5.VIEW \n6.PROJECT EMPLOYEE MANAGEMENT \n7.EXIT");
				System.out.println("Enter The Option");
				int pickCase = scanner.nextInt();
				switch (pickCase) {
				case 1:
					System.out.println("THE DATA YOU WANT TO INSERT");
					addEmployee();
					break;
				case 2:
					System.out.println(" DELETE THE DATA \n ENTER EMPLOYEE ID");
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
					System.out.println("VIEW THE LIST OF DATA" + employeeService.getAllEmployee() + " \nDATA FROM TABLE IS PRINTED");
					break;
				case 5:
					System.out.println("VIEW THE SINGLE ROW");
					System.out.println("ENTER EMPLOYEE ID");
					employeeId = scanner.nextInt();
					System.out.println("\n" + employeeService.getEmployee(employeeId));
					break;
				case 6:
					System.out.println("EMPLOYEE PROJECT MANAGEMENT");
					addEmployeeToProject();
				case 7:
					checkCase = false;
					break;
				default:
				}
			} while (checkCase);
		} catch (InputMismatchException e) {
			System.out.println("PLEASE GIVE A VALID INPUT");
		}
	}

	/**
	 * AddEmployee is used to get the values from the user
	 */
	public void addEmployee() {
		try {
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
			long phoneNumber = ValidatePhoneNumber();
			String dateOfBirth = ValidateDateOfBirth();
			String emailId = ValidateEmailId();
			List <Integer> employeeList = employeeService.validateEmployeeData(phoneNumber, emailId);
			if (employeeList.get(0) != 0 && employeeList.get(1) != 0) {
				System.out.println("DUPLICATE PHONE NUMBER AND EMAILID");
			} else if (employeeList.get(1) != 0) {
				System.out.println("DUPLICATE EMAILID"); 
			} else if (employeeList.get(0) != 0) {
				System.out.println("DUPLICATE PHONE NUMBER");
			} else {
				HashMap <String, Object> currentAddressMap = getAddressValues("currentAddress");
				HashMap <String, Object> permanentAddressMap = new HashMap <String, Object> ();
				System.out.println("IS CURRENT ADDRESS IS SAME AS PERMANENT ADDRESS \n 1.YES  2.NO");
				int addresscase = scanner.nextInt();
				if (addresscase == 2) {
					permanentAddressMap = getAddressValues("permanentAddress");
				} else {
					permanentAddressMap.putAll(currentAddressMap);
					permanentAddressMap.put("AddressType", "permanentAddress");
				}
				int messageStatus = employeeService.insertEmployee(companyName, salary, designation, experience, 
						name, phoneNumber, dateOfBirth, emailId, currentAddressMap, permanentAddressMap);
				System.out.println(messageStatus);
			}
		} catch (InputMismatchException e) {
			System.out.println(" PLEASE GIVE THE VALID INPUT");
		}
	}

	/**
	 * GetAddressValues is used to get address details from user
	 * @return address  Address - return address details in this method
	 */
	public HashMap <String, Object> getAddressValues(String addressType) {
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
		HashMap <String, Object> employeeMap = new HashMap <String, Object> ();
		employeeMap.put("Street", street);
		employeeMap.put("City", city);
		employeeMap.put("District", district);
		employeeMap.put("PinCode", pinCode);
		employeeMap.put("State", state);
		employeeMap.put("AddressType", addressType);
		employeeListValues.add(employeeMap);
		//employeeService.addAddressValues(street, city, district, state, pinCode, addressType);
		return employeeMap;
	}

	/**
	 * UpdateEmployee is used to change the value from employee details
	 */
	public void updateEmployee() {
		try {
			System.out.println("Enter Your EmployeeId");
			int employeeId = scanner.nextInt();
			long phoneNumber = ValidatePhoneNumber();
			String emailId = ValidateEmailId();
			List <Integer> employeeList = employeeService.validateEmployeeData(phoneNumber, emailId);
			if (employeeList.get(0) != 0 && employeeList.get(1) != 0) {
				System.out.println("DUPLICATE PHONE NUMBER AND EMAILID");
			} else if (employeeList.get(1) != 0) {
				System.out.println("DUPLICATE EMAILID"); 
			} else if (employeeList.get(0) != 0) {
				System.out.println("DUPLICATE PHONE NUMBER");
			} else {
				System.out.println(employeeService.updatePersonalDetails(employeeId, phoneNumber, emailId));
			}
		} catch (InputMismatchException e) {
			System.out.println(" PLEASE GIVE THE VALID INPUT");
		}	
	}

	/**
	 * CheckValidationMobile user need to enter phone number repeatedly until a valid phone number
	 * @return phoneNumber long - to set the value in employeeMap
	 */
	public long ValidatePhoneNumber() {
		System.out.println("Enter Your Phonenumber");
		long phoneNumber = scanner.nextLong();
		System.out.println(employeeService.isPhoneNumberValid(phoneNumber));
		if (!(employeeService.isPhoneNumberValid(phoneNumber))) {
			System.out.println("Not a valid phone number kindly change phone number");
			ValidatePhoneNumber();
		}
		return phoneNumber;
	}

	/**
	 * This method checkValidateEmail user need to enter emailId repeatedly until a valid emailId
	 * @return emailId String - to set the value in employeeMap
	 */
	public String ValidateEmailId() {
		System.out.println("Enter Your Emailid");
		String emailId = scanner.next();
		if (!(employeeService.isEmailIdValid(emailId))) {
			System.out.println("Not a valid email kindly change emailId");
			ValidateEmailId();
		}
		return emailId;
	}

	/**
	 * CheckDateOfBirth user need to enter dateOfBirth  repeatedly until a valid dateofbirth
	 * @return dateOfBirth String - to set the value in employeeMap
	 */
	public String ValidateDateOfBirth() {
		System.out.println("Enter Your Date of birth in the format yyyy/MM/dd");
		String dateOfBirth = scanner.next();
		if (!(employeeService.isDateOfBirthValid(dateOfBirth))) {
			System.out.println("Not a Date valid  kindly change Date");
			ValidateDateOfBirth();
		}
		return dateOfBirth;
	}

	/**
	 * AddEmployeeToProject is used to add employee and project Details
	 * To insert and view the employee and project
	 */
	public void addEmployeeToProject() {
		List <Integer> listId = new ArrayList <Integer> ();
		System.out.println("THE DATA YOU WANT TO INSERT");
		System.out.println("Enter Your EmployeeId");
		int employeeId = scanner.nextInt();
		System.out.println("ENTER PROJECT ID");
		int projectId = scanner.nextInt();
		listId.add(projectId);
		String employeeIdString = "DO You Want To Add more Employee \n 1.YES \n 2.NO";
		System.out.println(employeeIdString);
		int addProject = scanner.nextInt();
		while (addProject == 1) {
			System.out.println("Enter Your EmployeeId");
			projectId = scanner.nextInt();
			listId.add(projectId);
			System.out.println(employeeIdString);
			addProject = scanner.nextInt();
		}
		employeeService.addProjectEmployee(listId, employeeId);
	}
}
