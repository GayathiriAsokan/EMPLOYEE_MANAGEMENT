/**
 * Provide the interface necessary to create ProjectDaoImpl
 * To communicate with ProjectDao
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.project.dao;

import java.util.HashMap;
import java.util.List;

/**
 * @description ProjectDaoImpl to communicate with ProjectDao
 * @version 1.0
 * @author GAYATHIRI
 */
public interface ProjectDao {
    public int insertProject(int projectId, String projectName, String technology,
                             String projectManager, String projectType);

    public int insertProjectEmployee(int projectId, int employeeId);

    public int updateProject(int employeeId, int projectId);

    public int isProjectIdExist(int projectId);

    public int deleteProject(int employeeId, int projectId);

    public List<HashMap<String, Object>> viewProject(int projectId, boolean viewFlag);

}

