/**
 * Provide the class necessary to create view class
 * To communicate with user
 * Used to view the project details
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.project.view;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.project.controller.ProjectController;

/**
 * @description ProjectView implements an application that is used to hold Projectcontroller
 * Displays employee details by adding,viewing,deleting,updating them
 * @author GAYATHIRI
 * @version 1.0
 */
public class ProjectView {
    Scanner scanner = new Scanner(System.in);
    ProjectController projectController = new ProjectController();

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
                    projectController.addProject();
                    break;
                case 2:
                    System.out.println("DELETE THE DATA");
                    System.out.println(projectController.deleteProject());
                    break;
                case 3:
                    System.out.println("UPDATE THE DATA");
                    System.out.println(projectController.updateProject());
                    break;
                case 4:
                    System.out.println("VIEW THE  LIST OF DATA");
                    List<HashMap<String, Object>> projectList = projectController.viewProject();
                    System.out.println("ProjectId \t EmployeeId \t ProjectName");
                    for (int listIndex = 0; listIndex < projectList.size(); listIndex++) {
                        HashMap<String, Object> projectMap = projectList.get(listIndex);
                        System.out.println(projectMap.get("ProjectId") + "\t" + projectMap.get("EmployeeId") + "\t"
                                + projectMap.get("ProjectName") + "\t");
                    }
                    System.out.println();
                    System.out.println("\nPROJECT DATA IS PRINTED");
                    break;
                case 5:
                    System.out.println("VIEW THE SINGLE ROW");
                    System.out.println(projectController.viewSingleProject());
                    break;
                case 6:
                    checkCase = false;
                    break;
                default:
            }
        } while (checkCase);
    }
}

