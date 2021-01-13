/**
 * Provide the interface necessary to create a ProjectServiceImpl
 * To communicate with ProjectService class
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.project.service;

import java.util.HashMap;
import java.util.List;

import com.ideas2it.project.model.Project;

/**
 * @description ProjectServiceImpl communicate with ProjectService class
 * @author GAYATHIRI
 * @version 1.2
 */
public interface ProjectService {
    public String insertProject(String projectName, String projectManager,
                                String projectType, String technology);

    public List<Project> viewProject();

    public Project viewSingleProject(int projectId);

	/*
	 * public String deleteProject(int projectId, int employeeId);
	 * 
	 * public String updateProject(int projectId, int employeeId);
	 * 
	 * public int isProjectIdExist(int projectId);
	 */
}

