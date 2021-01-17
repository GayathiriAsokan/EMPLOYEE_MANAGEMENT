/**
 * Provide the interface necessary to create ProjectDaoImpl
 * To communicate with ProjectDao
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.project.dao;

import java.util.List;

import com.ideas2it.project.model.Project;

/**
 * @description ProjectDaoImpl to communicate with ProjectDao
 * @version 1.0
 * @author GAYATHIRI
 */
public interface ProjectDao {

	/**
	 * Inserting the project values 
	 * @param projectName
	 * @param technology
	 * @param projectManager
	 * @param projectType
	 * @param startDate
	 * @param endDate
	 * @return
	 */
    public int insertProject(String projectName, String technology,
                             String projectManager, String projectType, String startDate, String endDate);
    /**
     * ViewProject is used to view all project details
     * @return List<Project>
     */
    public List<Project> viewProject();
    
    /**
     * View the project details by Id
     * @param projectId
     * @return Project
     */
    public Project projectViewById(int projectId);
    
    /**
     * UpdateProject is used to change the Actual End Date 
     * @param projectId
     * @param actualEndDate
     * @return int
     */
    public int updateProject(int projectId, String actualEndDate);
}

