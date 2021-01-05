/**
 * Provide the class necessary to create a service class
 * To communicate with controller and model classes
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.project.dao.ProjectDao;
import com.ideas2it.project.model.Project;

/**
 * @description EmployeeService used to hold Project
 * We can view, remove, add, update operations in Project data 
 * @author GAYATHIRI
 * @version 1.2
 */
public class ProjectService {
    ProjectDao projectDao = new ProjectDao();

    /**
	    * InsertProject is used to inserting the data and getting the values from user
	    * Add all  Project details in the ProjectMap
     * @param employeeId int 
     * @param projectName  String 
     * @param projectManager String
     * @param projectId int
     * @param projectType String
     * @param technology String
	    */    
    public String insertProject( int employeeId, int projectId, String projectName, String projectManager, String projectType, 
                             String technology) {
        int countInsertedRow = projectDao.insertProject(projectId, projectName, technology, projectManager, projectType);
        if ( countInsertedRow !=0) {
            countInsertedRow = projectDao.insertProjectEmployee(employeeId, projectId); 
            if ( countInsertedRow !=0) {
                return "PROJECT DATA ADDED SUCCESSFULLY";    
            } else {
                return "INVALID PROJECT EMPLOYEE DATA"; 
            }
         } else {
         return  "INVALID EMPLOYEE DATA";
         }
    }

    /**
     * ViewProject is used show the employee details 
     * Values in the projectMap are displayed 
     * @return projectMap Map <Integer,Project> - to print Project details
     */
    public List <HashMap <String,Object>> viewProject() {
        return projectDao.viewProject(0,false);
    }
    
    /**
     * ViewsingleData method  used to display the employee data
     * It prints a row from a EmployeeMap
     * @param employeeId int - to display the employee data
     * @return boolean - to print the employee details
     */
    public List <HashMap <String,Object>> viewSingleProject(int projectId){
			     return projectDao.viewProject(projectId,true);
    }
	
    /**
     * DeleteData method used to delete the employee data
     * @param employeeId int - to check employeedata is present or not
     * @return employeeId int - to print delted or not
     */
    public String deleteProject(int projectId, int employeeId) {
        int projectIdCount = isProjectIdExist(projectId); 
        if (projectIdCount != 0) {
            projectDao.deleteProject(projectId, employeeId);
            return "DELETED SUCCCESSFULLY";
        } else {
            return "PROJECT DATA NOT EXIST";
        }
	   } 
    
    /**
     * UpdateEmployee is used to change the value from employee details
     */   
    public String updateProject(int projectId, int employeeId) {
        int projectIdCount = isProjectIdExist(projectId); 
        if (projectIdCount != 0) {
            projectDao.updateProject(projectId, employeeId);
            return "UPDATED SUCCCESSFULLY";
        } else {
            return "PROJECT DATA NOT EXIST";
        }  
    }
    
    /**
     * IsProjectIdExist checks employee data is present or not
     * @param employeeId int - to check employeedata is present or not
     * @return boolean - verify whether key is present or not
     */ 
    public int isProjectIdExist(int projectId) {
        int projectIdCount = projectDao.isProjectIdExist(projectId);
        return projectIdCount;
    }
}  
