

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ideas2it.employee.dao.EmployeeDaoImpl;

/**
 * @description used to get the session factory
 * @author GAYATHIRI
 */
public class SessionManagement {
	public static SessionFactory getSessionFactory(){
          Configuration configuration = new Configuration();
          configuration.configure("resources/properties/hibernate.cfg.xml");
          SessionFactory sessionFactory = configuration.buildSessionFactory();
          return sessionFactory;
      }
}
