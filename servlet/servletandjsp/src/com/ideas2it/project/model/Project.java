/**
 * Provide the class necessary to create an model class
 * To communicate with service class
 *
 * @since 1.0
 */
package com.ideas2it.project.model;

import java.util.HashSet;
import java.util.Set;

import com.ideas2it.employee.model.Employee;
//import com.ideas2it.util.Validator;

/**
 * @description Project Model class is a model class
 * It is used to hold the user Project details such as projectId, projectName, Technology,
   projectManager,projectType, startDate, endDate,  actualEndDate, Employee Set
 * @version 1.0
 */
public class Project {
	//Validator validator = new Validator();
	private int projectId;
	private String projectName;
	private String technology;
	private String projectManager;
	private String projectType;
	private String startDate;
	private String endDate;
	private String actualEndDate;
	private Set <Employee>  employeeSet = new HashSet <Employee>();

	/**
	 * Default Constructor which creates an empty object of Address
	 */
	public Project() {
	}

	/**
	 * Parameterized constructor with parameters projectName, projectManager, projectType, startDate, endDate
	 * Asigning values using this keyword    
	 */
	public Project(String projectName, String projectManager, String projectType, String technology, String startDate, String endDate, String actualEndDate) {
		this.projectName = projectName;
		this.technology = technology;
		this.projectManager = projectManager;
		this.projectType = projectType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.actualEndDate = actualEndDate;
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

	public Set<Employee> getEmployeeSet() { 
		return employeeSet;
	}
	public void setEmployeeSet(Set<Employee> employeeSet) { 
		this.employeeSet = employeeSet; 
	}

	public  Set<Integer>  getEmployeeId(){
		Set<Employee> employee =  new HashSet  <Employee> ();
		Set<Integer> employeeId =  new HashSet  <Integer> ();
		employee.addAll(getEmployeeSet());
		for (Employee emp : employee) {
			employeeId.add(emp.getEmployeeId());	
		}
		return employeeId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(String actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	@Override
	public String toString() {
		return "\n Project: ProjectId : " + getProjectId() + "\n ProjectName  : " + getProjectName() +
				"\n Technology  : " + getTechnology() + "\n ProjectManager : " + getProjectManager() + "\n ProjectType : "
				+ getProjectType()+  "\n EndDate : " +  getEndDate() +  "\n StartDate : " + getStartDate() + "\n ActualEndDate : " + 
				getActualEndDate() + " " + getEmployeeId();// + "\n PROJECT STATUS " + validator.projectStatus (endDate, actualEndDate);
	}

}
