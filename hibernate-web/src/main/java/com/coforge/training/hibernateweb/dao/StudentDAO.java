/**
* Author  : Vedant.Raturi
* Date    : Sep 25, 2025
* Time    : 10:39:14 AM
* Project : hibernate-web
*/

//// This class is a Data Access Object (DAO) for managing Student entities in the 
// * system using Hibernate ORM with XML configuration.
// * This layer interacts with the database to perform CRUD operations.


package com.coforge.training.hibernateweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.training.hibernateweb.model.Student;

public class StudentDAO {
	private static SessionFactory factory;

    static {
        // Load hibernate.cfg.xml and build SessionFactory
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public static int register(Student s) {
        Transaction tx = null;
        int id = 0;

        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();

            // Use persist() instead of save()
            session.persist(s);

            // Commit transaction
            tx.commit();

            // After commit, Hibernate assigns the generated ID
            id = s.getId();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

        return id;
    }
    
 // ✅ Fetch all students - HQL query (Hibernate Query Language)(Object Oriented Query Language)
    public List<Student> getAll() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Student", Student.class).list();
        }
    }
}
