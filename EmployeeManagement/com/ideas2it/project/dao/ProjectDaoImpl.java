/**
 * Provide the class necessary to create a dao class
 * To communicate with service and model classes
 *
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.project.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ProjectDao made jdbc connectivity for the employeeApplication
 * Using database we can insert ,update,select,delete data
 * @version 1.0
 * @author GAYATHIRI
 */
public class ProjectDaoImpl implements ProjectDao{


    /**
     * InsertProject is used to insert the values using Insert query
     * @param projectName String
     * @param technology String
     * @param projectManager String 
     * @param projectId int 
     * @param projectType String 
     * @return rowCount int - to find whether the row inserted or not
     */
    @Override
    public int insertProject(int projectId, String projectName, String technology,
                             String projectManager, String projectType) {
        int rowCount = 0;

        return rowCount;
    }

    /**
     * InsertProjectEmployee is used to insert the values using Insert query
     * @param employeeId int 
     * @param projectId int
     * @return rowCount int - to find whether the row inserted or not
     */
    @Override
    public int insertProjectEmployee(int projectId, int employeeId) {
        int rowCount = 0;

        return rowCount;
    }

    /**
     * UpdateProject is used to change the updateProject values of employeeId, projectId
     * @param  employeeId int 
     * @param projectId int 
     * @return updateCount int - to return the count of modification in a project_employee table
     */
    @Override
    public int updateProject(int employeeId, int projectId) {
     int updateCount = 0;
        return updateCount;
    }

    /**
     * IsProjectIdExist used to check whether employee id present or not
     * @param projectId int
     * @return rowCount - to verify project id is present or not
     */
    @Override
    public int isProjectIdExist(int projectId) {
        int rowCount = 0;
        return rowCount;
    }

    /**
     * deleteProject is used to delete entries in employeId projectId
     * @return countDelete int - return delete count in project_employee
     */
    @Override
    public int deleteProject(int employeeId, int projectId) {
        int countDelete = 0;
        return countDelete;
    }

    /**
     * ViewProject is used to view the Project details using select query
     * @param projectId int 
     * @param viewFlag boolean
     * @return projectList List <HashMap <String,Object>> 
     */
    @Override
    public List<HashMap<String, Object>> viewProject(int projectId, boolean viewFlag) {
        List<HashMap<String, Object>> projectList = new ArrayList<HashMap<String, Object>>();

        return projectList;
    }
}
  
