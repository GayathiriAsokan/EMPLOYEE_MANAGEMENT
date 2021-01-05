/**
 * Provide the class necessary to create a dao class
 * To communicate with service and model classes
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.Connector;
import com.ideas2it.project.model.Project;

/**
 * ProjectDao made jdbc connectivity for the employeeApplication
 * Using database we can insert ,update,select,delete data
 * @version 1.0
 * @author GAYATHIRI
 */ 
public class ProjectDao {
	
    Connector connector = new Connector();

    /** 
     * InsertProject is used to insert the values using Insert query
     * @param employeeId int 
     * @param projectName String
     * @param technology String
     * @param projectManager String 
     * @param projectId int 
     * @param projectType String 
     * @return rowCount int - to find whether the row inserted or not
     */
    public int insertProject(int projectId, String projectName, String technology, 
                             String projectManager, String projectType) {
        int rowCount = 0;
        Connection connection = connector.getConnection();
        try {
            PreparedStatement preparedStatement = null;
			         preparedStatement = connection.prepareStatement("insert into project Values(?,?,?,?,?)");
            preparedStatement.setInt(1, projectId);
			         preparedStatement.setString(2, projectName);
            preparedStatement.setString(3, technology);
            preparedStatement.setString(4, projectManager);
            preparedStatement.setString(5, projectManager);
            rowCount = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
			         System.out.println("Could not load the insert operation" + e.getMessage());
			         e.printStackTrace();
		      } finally {
            connector.closeConnection(connection);
        }
        return rowCount;
    } 
    
    /** 
     * InsertProjectEmployee is used to insert the values using Insert query
     * @param employeeId int 
     * @param projectId int
     * @return rowCount int - to find whether the row inserted or not
     */
    public int insertProjectEmployee(int projectId, int employeeId) {
        int rowCount = 0;
        Connection connection = connector.getConnection();
        try {
            PreparedStatement preparedStatement = null;
			         preparedStatement = connection.prepareStatement("insert into project_employee Values(?,?)");
            preparedStatement.setInt(1, projectId);
			         preparedStatement.setInt(2, employeeId);
            rowCount = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
			         System.out.println("Could not load the insert operation" + e.getMessage());
			         e.printStackTrace();
		      } finally {
            connector.closeConnection(connection);
        }
        return rowCount;
    } 
    
    /**
     * UpdateProject is used to change the updateProject values of employeeId, projectId
     * @param  employeeId int 
     * @param projectId int 
     * @return updateCount int - to return the count of modification in a project_employee table
     */
    public int updateProject(int employeeId, int projectId) {
        Connection connection = connector.getConnection();
        int updateCount = 0;
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(" update project_employee set employee_id = ? where project_id = ?");
			         preparedStatement.setInt(1, employeeId);
            preparedStatement.setInt(2, projectId);
            updateCount = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
			         System.out.println("Could not load the update operation" + e.getMessage());
			         e.printStackTrace();
		      } finally {
            connector.closeConnection(connection);
        }
        return updateCount;
    } 
    
    /**
     * IsProjectIdExist used to check whether employee id present or not
     * @param projectId int
     * @return rowCount - to verify project id is present or not
     */
    public int isProjectIdExist(int projectId) {
        Connection connection = connector.getConnection();
        int rowCount = 0;
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("select count(project_id) from project_employee where project_id = ?");
            preparedStatement.setInt(1, projectId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            rowCount = resultSet.getInt(1);
            preparedStatement.close();
        } catch (Exception e) {
			         System.out.println("Could not load the project Id exist operation" + e.getMessage());
			         e.printStackTrace();
		      } finally {
            connector.closeConnection(connection);
        }
        return rowCount;
    }
    
    /**
     * deleteProject is used to delete entries in employeId projectId
     * @param employeId int 
     * @return countDelete int - return delete count in project_employee
     */
    public int deleteProject(int employeeId, int projectId) {
        Connection connection = connector.getConnection();
        int countDelete = 0; 
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("delete from project_employee where project_id = ?  and employee_id = ?");
            preparedStatement.setInt(1, projectId);
			         preparedStatement.setInt(2, employeeId);
            countDelete = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
			         System.out.println("Could not load the delete operation" + e.getMessage());
			         e.printStackTrace();
		      } finally {
            connector.closeConnection(connection);
        }
        return countDelete;  
    }

    /**
     * ViewProject is used to view the Project details using select query
     * @param projectId int 
     * @param viewFlag boolean
     * @return projectList List <HashMap <String,Object>> 
     */ 
    public List <HashMap <String,Object>> viewProject(int projectId, boolean viewFlag) {
        List <HashMap <String,Object>> projectList = new ArrayList <HashMap <String, Object>>();
        Connection connection = connector.getConnection();
        StringBuilder viewQuery = new StringBuilder("select project.project_id,project.project_name,project.project_type,")
        .append("project.technology,project.project_manager,projectemp.employee_id from project inner join project_employee")
        .append(" as projectemp on project.project_id = projectemp.project_id");
        if (viewFlag) {
            viewQuery.append(" where project.project_id = ?");
        }
        try {
            PreparedStatement preparedStatement = null;
            String viewProject = viewQuery.toString(); 
			         preparedStatement = connection.prepareStatement(viewProject);
            if (viewFlag) {
                preparedStatement.setInt(1, projectId);
            }   
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HashMap <String, Object> projectMap = new HashMap <String, Object> ();  
                projectMap.put("ProjectName", resultSet.getString("project_name"));
                projectMap.put("Projecttype", resultSet.getString("project_type"));
                projectMap.put("Technology", resultSet.getString("technology"));
                projectMap.put("ProjectManager", resultSet.getString("project_manager"));
                projectMap.put("ProjectId", resultSet.getInt("project_id"));
                projectMap.put("EmployeeId", resultSet.getInt("employee_id"));
                if (resultSet.next()) {
                    projectMap.put("New EmployeeId", resultSet.getInt("employee_id"));
                }
                projectList.add(projectMap);
            }
            preparedStatement.close();
        } catch (Exception e) {
			         System.out.println("Could not load the view operation" + e.getMessage());
			         e.printStackTrace();
		      } finally {
            connector.closeConnection(connection);
        }
        return projectList;
    }
}
  
