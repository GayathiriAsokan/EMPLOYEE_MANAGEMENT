/**
 * Provide the class necessary to create view class
 * To communicate with user
 * Used to view the employee details
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.employee.view;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.employee.controller.EmployeeController;

/**
 * @description EmployeeView implements an application that is used to hold Employeecontroller
 * Displays employee details by adding,viewing,deleting,updating them
 * @author GAYATHIRI
 * @version 1.0
 */
public class EmployeeView {
    Scanner scanner = new Scanner(System.in);
    EmployeeController employeeController = new EmployeeController();

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
                    employeeController.addEmployee();
                    break;
                case 2:
                    System.out.println("DELETE THE DATA");
                    System.out.println(employeeController.deleteEmployee() + "\n DELETED SUCCESSFULLY");
                    break;
                case 3:
                    System.out.println("UPDATE THE DATA");
                    employeeController.updateEmployee();
                    break;
                case 4:
                    System.out.println("VIEW THE LIST OF DATA");
                    List<HashMap<String, Object>> employeeList = employeeController.viewEmployee();
                    System.out.println(" EmployeeId \t Name \t PhoneNumber \t Salary \t EmailId \t State");
                    for (int listIndex = 0; listIndex < employeeList.size(); listIndex++) {
                        HashMap<String, Object> employeeMap = employeeList.get(listIndex);
                        System.out.println(employeeMap.get("EmployeeId") + "\t\t" + employeeMap.get("Name") + "\t" +
                                employeeMap.get("PhoneNumber") + "\t\t" + employeeMap.get("Salary") + "\t" +
                                employeeMap.get("EmailId") + "\t\t" + employeeMap.get("State"));
                    }
                    System.out.println("\nDATA FROM MAP IS PRINTED");
                    break;
                case 5:
                    System.out.println("VIEW THE SINGLE ROW");
                    System.out.println("\n" + employeeController.viewSingleEmployee());
                    break;
                case 6:
                    checkCase = false;
                    break;
                default:
            }
        } while (checkCase);
    }
}

