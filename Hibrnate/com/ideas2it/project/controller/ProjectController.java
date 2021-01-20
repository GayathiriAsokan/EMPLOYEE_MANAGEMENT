/**
 * Provide the class necessary to create an controller class
 * To communicate with user and the service
 * Used for view the employee details
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.project.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.project.service.ProjectServiceImpl;

/**
 * @description ProjectController implements an application that is used to hold ProjectService
 * Displays Project details by adding,viewing,deleting,updating them
 * @author GAYATHIRI
 * @version 1.2
 */
public class ProjectController {
	Scanner scanner = new Scanner(System.in);
	ProjectServiceImpl projectService = new ProjectServiceImpl();

	/**
	 * In this method we can view, remove, add, update project data
	 */
	public void getProjectDetails() {
		try {
			boolean checkCase = true;
			do {
				System.out.println("\n1.INSERT \n2.UPDATE \n3.VIEW LIST \n4.VIEW \n5.Employee Project Management\n6.EXIT");
				System.out.println("Enter The Option");
				int pickCase = scanner.nextInt();
				switch (pickCase) {
				case 1:
					System.out.println("THE DATA YOU WANT TO INSERT");
					addProject();
					break;
				case 2:
					System.out.println("UPDATE DATA");
					System.out.println("ENTER PROJECT ID");
					int projectId = scanner.nextInt();
					String delayDate = "Enter Your Actual End Date in the format yyyy/MM/dd";
					String actualEndDate = ValidateDate(delayDate);
					System.out.println("Enter Your Technology");
					String technology = scanner.next();
					System.out.println(projectService.updateProject(projectId, actualEndDate, technology));
					break;
				case 3:
					System.out.println("VIEW THE  LIST OF DATA");
					System.out.println(projectService.viewProject());
					System.out.println("\nPROJECT DATA IS PRINTED");
					break;
				case 4:
					System.out.println("VIEW THE SINGLE ROW");
					System.out.println("ENTER PROJECT ID");
					projectId = scanner.nextInt();
					System.out.println(projectService.viewSingleProject(projectId));
					break;
				case 5:
					System.out.println("Employee Project Management");
					addEmployeeToProject();
					break;
				case 6:
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
	 * AddProject is used to get the values from the user
	 */
	public void addProject() {
		try {
			System.out.println("Enter Your ProjectName");
			String projectName = scanner.next();
			System.out.println("Enter Your ProjectManager");
			String projectManager = scanner.next();
			System.out.println("Enter Your ProjectType");
			String projectType = scanner.next();
			System.out.println("Enter Your Technology");
			String technology = scanner.next();
			String date = "Enter Your Start Date in the format yyyy/MM/dd";
			String startDate = ValidateDate(date);
			String  dateEnd =  "Enter Your End Date in the format yyyy/MM/dd";
			String endDate = ValidateDate(dateEnd);
			String  actualdateEnd =  "Enter Your End Date in the format yyyy/MM/dd";
			String actualEndDate = ValidateDate(actualdateEnd);
			String messageStatus = projectService.insertProject(projectName, projectManager, projectType, technology, startDate, endDate, actualEndDate);
			System.out.println(messageStatus);
		} catch (InputMismatchException e) {
			System.out.println("PLEASE GIVE A VALID INPUT");
		}
	}

	/**
	 * CheckDateOfBirth user need to enter dateOfBirth  repeatedly until a valid dateofbirth
	 * @return dateOfBirth String - to set the value in employeeMap
	 */
	public String ValidateDate(String date) {
		System.out.println(date);
		String dateValue = scanner.next();
		if (!(projectService.isDateValid(dateValue))) {
			System.out.println("NOT A VALID DATE ");
			ValidateDate(date);
		}
		return dateValue;
	}

	/**
	 * AddEmployeeToProject is used to add employee and project Details
	 */
	public void addEmployeeToProject() {
		List  <Integer> listId = new ArrayList <Integer> ();
		System.out.println("THE DATA YOU WANT TO INSERT");
		System.out.println("Enter Your EmployeeId");
		int employeeId = scanner.nextInt();
		System.out.println("ENTER  PROJECT ID");
		int projectId = scanner.nextInt();
		listId.add(employeeId);
		String employeeIdString = "DO You Want To Add more Employee \n 1.YES \n 2.NO";
		System.out.println(employeeIdString);
		int addEmployee = scanner.nextInt();
		while (addEmployee == 1) {
			System.out.println("Enter Your EmployeeId");
			employeeId = scanner.nextInt();
			listId.add(employeeId);
			System.out.println(employeeIdString);
			addEmployee = scanner.nextInt();
		}
		projectService.addProjectEmployee(listId, projectId);
	}
}