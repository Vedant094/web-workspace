/**
* Author  : Vedant.Raturi
* Date    : Sep 26, 2025
* Time    : 11:02:07 AM
* Project : hibernate-web
*/

package com.coforge.training.hibernateweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.training.hibernatedemo.model.Employee;

public class ManipulationDAO {
	private static SessionFactory sessionFactory;

    static {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Employee.class);
        sessionFactory = cfg.buildSessionFactory();
    }

    // --- Save ---
    public void save(Employee emp) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(emp);
            tx.commit();
        }
    }

    // --- Update salary by ID ---
    public int updateSalaryById(Long id, Double newSalary) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();

            String hql = "update Employee e set e.salary = :salary where e.id = :id";
            int rows = session.createMutationQuery(hql)
                              .setParameter("salary", newSalary)
                              .setParameter("id", id)
                              .executeUpdate();

            tx.commit();
            return rows;
        }
    }

    // --- Delete employee by ID ---
    public int deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();

            String hql = "delete from Employee e where e.id = :id";
            int rows = session.createMutationQuery(hql)
                              .setParameter("id", id)
                              .executeUpdate();

            tx.commit();
            return rows;
        }
    }

    // --- Get employee by ID (for edit form) ---
    public Employee getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Employee.class, id);
        }
    }

}
