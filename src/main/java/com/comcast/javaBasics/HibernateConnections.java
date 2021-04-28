package com.comcast.javaBasics;

import com.comcast.genesys.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateConnections {
    public static SessionFactory staticSessionFactory;
    public static void main(String[] args) throws Exception {
        HibernateConnections.testConnectionWithConfiguration();
        Session session = staticSessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        List<User> users = criteria.list();
        System.out.println("User -> " + users.toString());
        session.getTransaction().commit();
    }

    public static void testConnectionWithConfiguration() throws Exception{
        System.out.println("Trying to create a test connection with the database.");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate_mysql.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        staticSessionFactory = configuration.buildSessionFactory(ssrb.build());
        System.out.println("Connection to mysql db successful");
    }
}