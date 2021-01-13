package com.ideas2it.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ideas2it.project.model.Project;

import sessionManagement.SessionManagement;

public class ProjectEmployeeDaoImpl{
	
	public  void addProjectEmployee(int employee) {
		SessionFactory sessionFactory = SessionManagement.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//session.save(project);
		transaction.commit();
		session.close();
	}
}
