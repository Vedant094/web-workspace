/**
* Author  : Vedant.Raturi
* Date    : Sep 25, 2025
* Time    : 4:51:02 PM
* Project : hibernate-web
*/

package com.coforge.training.hibernateweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.coforge.training.hibernateweb.model.Account;
import com.coforge.training.hibernateweb.model.CurrentAccount;
import com.coforge.training.hibernateweb.model.SavingsAccount;

public class AccountDAO {
	private static SessionFactory sessionFactory;

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(SavingsAccount.class)
                .addAnnotatedClass(CurrentAccount.class)
                .buildMetadata()
                .buildSessionFactory();
    }

    public void save(Account account) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(account);
            tx.commit();
        }
    }
    
    public List<Account> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Account", Account.class).list();
        }
    }
}
