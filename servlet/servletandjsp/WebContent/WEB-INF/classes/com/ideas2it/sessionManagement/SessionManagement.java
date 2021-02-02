/**
 * SessionManagement is used to get session factory
 * SessionFactory is used for interaction with database in hibernate 
 */
package com.ideas2it.sessionManagement;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @description used to get the session factory
 * @author GAYATHIRI
 */
public class SessionManagement {

	private static  SessionFactory sessionFactory = null ;

	/**
	 * Default Constructor which creates an empty object
	 */
	private SessionManagement() {
	}

	/**
	 * SessionFactory is used to get session factory in hibernate 
	 * @return sessionFactory
	 */
	public static SessionFactory  getInstance(){
		try {	
			if (sessionFactory == null) {
				Configuration configuration = new Configuration();
				configuration.configure("resources/properties/hibernate.cfg.xml");
				sessionFactory = configuration.buildSessionFactory();
			}
		} catch (Exception e) {
			System.out.println("Could not load the connection" + e.getMessage());
			e.printStackTrace();
		}
		return sessionFactory;
	}	
}
