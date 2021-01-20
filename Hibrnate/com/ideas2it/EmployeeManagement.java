/**
 * Provide the class necessary to create an Main class
 * To communicate with Employee controller and ProjectController 
 * Common main class for employee and project
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it;

import java.util.Scanner;

import com.ideas2it.employee.controller.EmployeeController;
import com.ideas2it.project.controller.ProjectController;
/**
 * @description EmployeeApplication common main class for employee and project 
 * Used to hold Employee controller and ProjectController
 * @author GAYATHIRI
 * @version 1.0
 */
public class EmployeeManagement {

	/**
	 * Used for insert delete  operations in employee and project
	 * @param args - Application startup arguments
	 */
	public static void main(String [] args) {
		ProjectController projectController = new ProjectController();
		EmployeeController employeeController = new EmployeeController();
		boolean exitFlag = true;
		Scanner scanner = new Scanner(System.in);
			do {
				System.out.println("\nEMPLOYEE MANAGEMENT");
				System.out.println("\n1.EMPLOYEE DETAILS \n2.PROJECT DETAILS \n3.Exit");
				System.out.println("\nENTER THE OPTION YOU WANT TO USE");
				int userOption = scanner.nextInt();
				if (userOption == 1) {
					System.out.println("\nEMPLOYEE DETAILS");
					employeeController.getEmployeeDetails();
				} else if (userOption == 2) {
					System.out.println("\nPROJECT DETAILS");
					projectController.getProjectDetails();
				} else if (userOption == 3) {
					System.out.println("\nEXIT EMPLOYEE  MANAGEMENT");
					exitFlag = false;
				} else {
					System.out.println("INVALID CASE");
				}
			} while (exitFlag); 
	}
}
