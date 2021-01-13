/**
 * Provide the interface necessary to create ProjectDaoImpl
 * To communicate with ProjectDao
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.project.dao;

import java.util.HashMap;
import java.util.List;

import com.ideas2it.project.model.Project;

/**
 * @description ProjectDaoImpl to communicate with ProjectDao
 * @version 1.0
 * @author GAYATHIRI
 */
public interface ProjectDao {
    public int insertProject(String projectName, String technology,
                             String projectManager, String projectType);

    public List<Project> viewProject();
    
    public Project projectViewById(int projectId);

}

