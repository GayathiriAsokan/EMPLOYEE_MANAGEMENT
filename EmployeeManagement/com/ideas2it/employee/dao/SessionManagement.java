package com.ideas2it.employee.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Session management is used to configure sesssion factory
 */
public class SessionManagement {
        public static SessionFactory getSessionFactory(){
            Configuration configuration = new Configuration();
            configuration.configure("resources/properties/hibernate.cfg.xml");
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            return sessionFactory;
        }
}
