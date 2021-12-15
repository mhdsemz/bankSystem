package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BaseDao {
    static SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml").buildSessionFactory();
}
