/**
 * Author  : Vedant.Raturi
 * Date    : Sep 24, 2025
 * Time    : 11:57:30 AM
 * Project : hibernate-demo
 */


//Hibernate is an Object-Relational Mapping (ORM) framework for Java that simplifies the development of database applications by allowing developers to work with Java objects instead of SQL queries. It provides a way to map Java classes to database tables and Java data types to SQL data types.
// * Hibernate handles the conversion between Java objects and database records, allowing developers to focus on their application logic rather than database interactions.
// * Hibernate provides features such as lazy loading, caching, and transaction management, which can improve application performance and scalability.
// * Hibernate supports various database systems and can be integrated with other Java frameworks such as Spring and Java EE.
// * Overall, Hibernate is a powerful tool for Java developers who want to simplify database interactions and improve application performance.
// * 
// * Hibenate Program to save a Product object to the database.
package com.coforge.training.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.training.hibernatedemo.model.Product;

public class ProductApp {

	public static void main(String[] args) {

		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf=cfg.buildSessionFactory();
		Session session =sf.openSession();

		Transaction t=session.beginTransaction();
		
		Product p1=new Product();
		p1.setName("Redmi 4 pro");
		p1.setDescription("Phone by Redmi");
		p1.setPrice(21000.0f);
		session.save(p1);
		
		t.commit();
		
		System.out.println("Data Successfully Saved to Database");
		session.close();
		sf.close();

	}

}
