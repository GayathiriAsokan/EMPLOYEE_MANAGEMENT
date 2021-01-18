/**
 * SessionManagement is used to get session factory
 * SessionFactory is used for interaction with database in hibernate 
 */
package sessionManagement;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 * @description used to get the session factory
 * @author GAYATHIRI
 */
public class SessionManagement {

	public static  SessionFactory sessionFactory;
	/**
	 * SessionFactory is used to get session factory in hibernate 
	 * @return SessionFactory
	 */
	public static void  initializeSessionFactory(){
			try {	
				Configuration configuration = new Configuration();
				configuration.configure("resources/properties/hibernate.cfg.xml");
				sessionFactory = configuration.buildSessionFactory();
			} catch (Exception e) {
				System.out.println("Could not load the connection" + e.getMessage());
				e.printStackTrace();
			}
	}	
	public static SessionFactory  getSessionFactory(){
		return sessionFactory;
	}
	
}
