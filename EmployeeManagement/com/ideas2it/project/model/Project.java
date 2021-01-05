/**
 * Provide the class necessary to create an model class
 * To communicate with service class
 * @since 1.0
 */
package com.ideas2it.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @description Project Model class is a model class
 * It is used to hold the user Project details such as projectId,projectName,Technology,projectManager,projectType 
 * @version 1.0
 */
public class Project {
    private int projectId;
    private int employeeId;
    private String projectName;
    private String technology;
    private String projectManager;
    private String projectType;
    private List <Integer> projectList = new ArrayList <Integer>();

    /**
     * Default Constructor which creates an empty object of Address
     */
    public Project() {
    }
    
    /**
     * Parameterized constructor with parameters  projectId,projectName,projectManager,projectType
     * Asigning values using this keyword    
     */
    public Project(int employeeId, int projectId, String projectName, String projectManager, String projectType, String technology) {
        this.projectId = projectId;
        this.employeeId = employeeId;
        this.projectName = projectName;
        this.technology = technology;
        this.projectManager = projectManager;
        this.projectType = projectType;
    }    

    public void setProjectType(String projectType) {
        this.projectType = projectType;   
    }

    public String getProjectType() {
    return projectType;
    }
  
    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }
    
    public String getProjectManager() {
    return projectManager;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }    
  
    public String getTechnology() {
    return technology;
    }  
    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }    
  
    public String getProjectName() {
    return projectName;
    }  
    
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }    
  
    public int getProjectId() {
    return projectId;
    }  
    
    public void setEmployeeId(int employeeId) {
        projectList.add(employeeId);
    }    
  
    public List <Integer> getEmployeeId() {
    return projectList;
    }
    
    @Override
    public String toString() {
    return "\n Project: ProjectId : " + getProjectId() + "\n EmployeeId : " + getEmployeeId()  + "\n ProjectName  : " + getProjectName() + 
    "\n Technology  : " + getTechnology() + "\n ProjectManager : " + getProjectManager() + "\n ProjectType : " + getProjectType();
    }

}
