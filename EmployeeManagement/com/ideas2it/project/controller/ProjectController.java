/**
 * Provide the class necessary to create an controller class
 * To communicate with user and the service
 * Used for view the employee details
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.project.controller;

import java.util.Scanner;

import com.ideas2it.project.service.ProjectServiceImpl;
import com.ideas2it.project.service.ProjectEmployeeServiceImpl;

/**
 * @description ProjectController implements an application that is used to hold ProjectService
 * Displays Project details by adding,viewing,deleting,updating them
 * @author GAYATHIRI
 * @version 1.2
 */
public class ProjectController {
    Scanner scanner = new Scanner(System.in);
    ProjectServiceImpl projectService = new ProjectServiceImpl();
    ProjectEmployeeServiceImpl projectEmplyee = new ProjectEmployeeServiceImpl(); 

    /**
     * In this method we can view, remove, add, update employee data
     */
    public void projectDetails() {
        boolean checkCase = true;
        do {
            System.out.println("\n1.INSERT \n2.VIEW LIST \n3.VIEW\n4.Employee Project Management\n5.EXIT");
            System.out.println("Enter The Option");
            int pickCase = scanner.nextInt();
            switch (pickCase) {
                case 1:
                    System.out.println("THE DATA YOU WANT TO INSERT");
                    addProject();
                    break;
                case 2:
                    System.out.println("VIEW THE  LIST OF DATA");
                    System.out.println(projectService.viewProject());
                    System.out.println("\nPROJECT DATA IS PRINTED");
                    break;
                case 3:
                    System.out.println("VIEW THE SINGLE ROW");
                    System.out.println("ENTER PROJECT ID");
                    int projectId = scanner.nextInt();
                    System.out.println(projectService.viewSingleProject(projectId));
                    break;
                case 4:
                	System.out.println("Employee Project Management");
                	addEmployeeToProject();
                case 5:
                    checkCase = false;
                    break;
                default:
            }
        } while (checkCase);
    }

    /**
     * AddEmployee is used to get the values from the user
     */
    public void addProject() {
        System.out.println("Enter Your ProjectName");
        String projectName = scanner.next();
        System.out.println("Enter Your ProjectManager");
        String projectManager = scanner.next();
        System.out.println("Enter Your ProjectType");
        String projectType = scanner.next();
        System.out.println("Enter Your Technology");
        String technology = scanner.next();
        String messageStatus = projectService.insertProject(projectName, projectManager, projectType, technology);
        System.out.println(messageStatus);
    }
    
    public void addEmployeeToProject() {
    	 boolean checkCase = true;
         do {
             System.out.println("\n1.INSERT \n2.UPDATE \n3.VIEW LIST \n4.VIEW\n5.EXIT");
             System.out.println("Enter The Option");
             int pickCase = scanner.nextInt();
             switch (pickCase) {
                 case 1:
                     System.out.println("THE DATA YOU WANT TO INSERT");
                     System.out.println("Enter Your EmployeeId");
                     int employeeId = scanner.nextInt();
                     projectEmplyee.addProjectEmployee(employeeId);
                     break;
                 case 2:
                     System.out.println("UPDATE THE DATA");
                     System.out.println("ENTER  PROJECT ID");
                     int projectId = scanner.nextInt();
                     System.out.println("ENTER YOUR EMPLOYEEID");
                     employeeId = scanner.nextInt();
                     //String MessageUpdateStatus = projectService.updateProject(projectId, employeeId);
                     //System.out.println(MessageUpdateStatus);
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
                     checkCase = false;
                     break;
                 default:
             }
         } while (checkCase);
    }
}
