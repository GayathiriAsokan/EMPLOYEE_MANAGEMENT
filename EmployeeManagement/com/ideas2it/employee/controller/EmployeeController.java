/**
 * Provide the class necessary to create an controller class
 * To communicate with user and the service
 * Used to view the employee details
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.employee.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.service.EmployeeServiceImpl;
import com.ideas2it.employee.service.ProjectEmployeeServiceImpl;

/**
 * @description EmployeeController implements an application that is used to hold EmployeeService
 * Displays employee details by adding,viewing,deleting,updating them
 * @author GAYATHIRI
 * @version 1.2
 */
public class EmployeeController {
	Scanner scanner = new Scanner(System.in);
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
	ProjectEmployeeServiceImpl projectEmployee = new ProjectEmployeeServiceImpl();

	/**
	 * In this method we can view, remove, add, update employee data
	 */
	public void employeeDetails() {
		boolean checkCase = true;
		try {
			do {
				System.out.println("\n1.INSERT \n2.DELETE \n3.UPDATE \n4.VIEW LIST \n5.VIEW \n6.PROJEC EMPLOYEE MANAGEMENT \n7.EXIT");
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
					System.out.println("VIEW THE LIST OF DATA" + employeeService.viewEmployee() + " \nDATA FROM MAP IS PRINTED");
					break;
				case 5:
					System.out.println("VIEW THE SINGLE ROW");
					System.out.println("ENTER EMPLOYEE ID");
					employeeId = scanner.nextInt();
					System.out.println("\n" + employeeService.viewSingleEmployee(employeeId));
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
			long phoneNumber = checkPhoneNumber();
			String dateOfBirth = checkDateOfBirth();
			String emailId = checkEmailId();
			List <Integer> employeeList = employeeService.checkEmployeeData(phoneNumber, emailId);
			if (employeeList.get(0) != 0 && employeeList.get(1) != 0) {
				System.out.println("Duplicate Phonenumber And Emailid");
			} else if (employeeList.get(1) != 0) {
				System.out.println("Duplicate Emailid"); 
			} else if (employeeList.get(0) != 0) {
				System.out.println("Duplicate Phonenumber");
			} else {
				Address currentAddress = getAddressValues("currentAddress");
				Address permanentAddress;
				System.out.println("IS CURRENT ADDRESS IS SAME AS PERMANENT ADDRESS \n 1.YES  2.NO");
				int addresscase = scanner.nextInt();
				if (addresscase == 1) {
					permanentAddress = currentAddress;
				} else {
					permanentAddress = getAddressValues("permanentAddress");
				}
				int messageStatus = employeeService.insertEmployee(companyName, salary, designation, experience, 
						name, phoneNumber, dateOfBirth, emailId, currentAddress, permanentAddress);
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
	public Address getAddressValues(String addressType) {
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
		return employeeService.addAddressValues(street, city, district, state, pinCode, addressType);
	}

	/**
	 * UpdateEmployee is used to change the value from employee details
	 */
	public void updateEmployee() {
		try {
			System.out.println("ENTER YOUR EMPLOYEEID");
			int employeeId = scanner.nextInt();
			System.out.println("ENTER PHONE NUMBER");
			long phoneNumber = scanner.nextLong();
			System.out.println("ENTER EMAILID");
			String emailId = scanner.next();
			List <Integer> employeeList = employeeService.checkEmployeeData(phoneNumber, emailId);
			if (employeeList.get(0) != 0 && employeeList.get(1) != 0) {
				System.out.println("Duplicate Phonenumber And Emailid");
			} else if (employeeList.get(1) != 0) {
				System.out.println("Duplicate Emailid"); 
			} else if (employeeList.get(0) != 0) {
				System.out.println("Duplicate Phonenumber");
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

	/**
	 * AddEmployeeToProject is used to add employee and project Details
	 * To insert and view the employee and project
	 */
	public void addEmployeeToProject() {
		try {
			boolean checkCase = true;
			do {
				System.out.println("\n1.INSERT \n2.VIEW LIST \n3.VIEW \n4.PROJECT DETAILS");
				System.out.println("Enter The Option");
				int pickCase = scanner.nextInt();
				switch (pickCase) {
				case 1:
					List  <Integer> listId = new ArrayList <Integer> ();
					System.out.println("THE DATA YOU WANT TO INSERT");
					System.out.println("Enter Your EmployeeId");
					int employeeId = scanner.nextInt();
					System.out.println("ENTER  PROJECT ID");
					int projectId = scanner.nextInt();
					listId.add(projectId);
					String employeeIdString = "DO You Want To Add more Employee \n 1.YES \n 2.NO";
					int addProject = scanner.nextInt();
					while (addProject == 1) {
						System.out.println("Enter Your EmployeeId");
						projectId = scanner.nextInt();
						listId.add(projectId);
						System.out.println(employeeIdString);
						addProject = scanner.nextInt();
					}
					projectEmployee.addProjectEmployee(listId, employeeId);
					break;
				case 2:
					System.out.println("VIEW THE  LIST  PROJECT EMPLOYEE OF DATA");
					System.out.println(projectEmployee.viewProjectEmployee() + "\nPROJECT DATA IS PRINTED");
					break;
				case 3:
					System.out.println("VIEW THE  PROJECT EMPLOYEE  DATA");
					System.out.println("ENTER  PROJECT ID");
					projectId = scanner.nextInt();
					System.out.println(projectEmployee.viewProjectEmployeeById(projectId) + "\nPROJECT DATA IS PRINTED");
					break;
				case 4:
					employeeDetails();
					checkCase = false;
					break;
				default:
				}
			} while (checkCase);
		} catch (InputMismatchException e) {
			System.out.println("PLEASE GIVE A VALID INPUT");
		}
	}
}
