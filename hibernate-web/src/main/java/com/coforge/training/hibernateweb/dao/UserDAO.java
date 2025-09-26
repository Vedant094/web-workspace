/**
* Author  : Vedant.Raturi
* Date    : Sep 25, 2025
* Time    : 4:10:42 PM
* Project : hibernate-web
*/

package com.coforge.training.hibernateweb.dao;

import java.util.List;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.*;

import com.coforge.training.hibernateweb.model.User;


public class UserDAO {
	private static SessionFactory sessionFactory;
	static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(User.class)
                .buildMetadata()
                .buildSessionFactory();
    }

    public void save(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
        }
    }

    public List<User> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                "select distinct u from User u left join fetch u.skills",
                User.class
            ).list();
        }
    }
}
