/**
 * Provide the class necessary to create an controller class
 * To communicate with user and the service
 * Used for view the employee details
 *
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
     * DeleteData method used to delete the employee data
     */
    public String deleteProject() {
        System.out.println("DELETE THE DATA");
        System.out.println("ENTER  PROJECT ID");
        int projectId = scanner.nextInt();
        System.out.println("ENTER YOUR EMPLOYEEID");
        int employeeId = scanner.nextInt();
        return projectService.deleteProject(projectId, employeeId);
    }

    /**
     * UpdateEmployee is used to change the value from employee details
     */
    public String updateProject() {
        System.out.println("ENTER  PROJECT ID");
        int projectId = scanner.nextInt();
        System.out.println("ENTER YOUR EMPLOYEE ID");
        int employeeId = scanner.nextInt();
        return projectService.updateProject(projectId, employeeId);
    }

    /**
     * ViewProject is used show the employee details
     * Values in the projectMap are displayed
     * @return projectMap Map <Integer,Project> - to print Project details
     */
    public List<HashMap<String, Object>> viewProject() {
        return  projectService.viewProject();
    }

    /**
     * ViewsingleData method  used to display the employee data
     * It prints a row from a EmployeeMap
     * @return boolean - to print the employee details
     */
    public List<HashMap<String, Object>> viewSingleProject() {
        System.out.println("ENTER  PROJECT ID");
        int projectId = scanner.nextInt();
        return projectService.viewSingleProject(projectId);
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
    
