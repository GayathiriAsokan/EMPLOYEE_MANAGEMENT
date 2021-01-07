package com.ideas2it;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManagement {
        public SessionFactory getSessionFactory(){
            Configuration configuration = new Configuration();
            configuration.configure("resources/hibernate.cfg.xml");
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            return sessionFactory;
        }
}
