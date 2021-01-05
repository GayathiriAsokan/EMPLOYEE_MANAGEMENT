/**
 * Provide the class necessary to create an controller class
 * To communicate with user and the service 
 * Used for view the employee details
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ideas2it.employee.dao.EmployeeDao;
import com.ideas2it.project.service.ProjectService;

/**
 * @description ProjectController implements an application that is used to hold ProjectService
 * Displays Project details by adding,viewing,deleting,updating them 
 * @author GAYATHIRI
 * @version 1.2
 */
public class ProjectController {	
    Scanner scanner = new Scanner(System.in);
    ProjectService projectService = new ProjectService();

    /**
     * In this method we can view, remove, add, update employee data
     */
    public void projectDetails() {
        boolean checkCase = true;
        do {
            System.out.println("\n1.INSERT \n2.DELETE  \n3.UPDATE \n4.VIEW LIST \n5.VIEW\n6.EXIT");
            System.out.println("Enter The Option");
            int pickCase = scanner.nextInt();
            switch (pickCase) {
                case 1:
                    System.out.println("THE DATA YOU WANT TO INSERT");
                    addProject();
                    break;
                case 2:
                    System.out.println("DELETE THE DATA");
                    System.out.println("ENTER  PROJECT ID");
		                  int projectId = scanner.nextInt();
                    System.out.println("ENTER YOUR EMPLOYEEID");
		                  int employeeId = scanner.nextInt();
                    String MessageDeleteStatus = projectService.deleteProject(projectId, employeeId);
                    System.out.println(MessageDeleteStatus);
                    break;
                case 3:
                    System.out.println("UPDATE THE DATA");
                    System.out.println("ENTER  PROJECT ID");
		                  projectId = scanner.nextInt();
                    System.out.println("ENTER YOUR EMPLOYEEID");
		                  employeeId = scanner.nextInt();
                    String MessageUpdateStatus = projectService.updateProject(projectId, employeeId);
                    System.out.println(MessageUpdateStatus);
                    break;
                case 4:
                    System.out.println("VIEW THE  LIST OF DATA");
                    List <HashMap <String, Object>> projectList = projectService.viewProject();
                    System.out.println("ProjectId \t EmployeeId \t ProjectName"); 
                    for (int listIndex = 0; listIndex < projectList.size(); listIndex ++) {
                        HashMap <String, Object> projectMap = projectList.get(listIndex); 
                        System.out.println( projectMap.get("ProjectId") + "\t" + projectMap.get("EmployeeId") + "\t" 
                                           + projectMap.get("ProjectName") + "\t");
                    }
                    System.out.println();
                    System.out.println("\nPROJECT DATA IS PRINTED");
                    break;
                case 5:
                    System.out.println("VIEW THE SINGLE ROW");
                    System.out.println("ENTER PROJECT ID");
                    projectId = scanner.nextInt();
                    System.out.println(projectService.viewSingleProject(projectId));
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
    public void addProject() {
        System.out.println("Enter Your Emloyeeid");
		      int employeeId = scanner.nextInt();
        System.out.println("Enter Your Projectid");
		      int projectId = scanner.nextInt();
        System.out.println("Enter Your ProjectName");
        String projectName = scanner.next();
        System.out.println("Enter Your ProjectManager");
        String projectManager = scanner.next();
        System.out.println("Enter Your ProjectType");
        String projectType = scanner.next();
        System.out.println("Enter Your Technology");
        String technology = scanner.next();
        String messageStatus = projectService.insertProject(employeeId, projectId, projectName, projectManager, projectType, technology);
        System.out.println(messageStatus);
    }
}     
    
