/**
 * Author  : Vedant.Raturi
 * Date    : Sep 24, 2025
 * Time    : 12:34:47 PM
 * Project : hibernate-demo
 */
// Hibernate PRogarm to save Student data into Database using Annotation Configuration
package com.coforge.training.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.training.hibernatedemo.model.Student;

public class StudentApp {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf=cfg.buildSessionFactory();
		Session session =sf.openSession();

		Transaction t=session.beginTransaction();
		Student s1=new Student();

		s1.setName("S");
		s1.setBranch("MERN");
		s1.setMarks(76);
		s1.setRollNumber(67);
 

		// persist() is a JPA method to save the entity , used for annotated classes
		// it returns the generated identifier
		//used within Transactional context
		session.persist(s1); // object is in persist state
		t.commit(); //commit the transaction

		System.out.println("Data saved to Database Successfully");
		session.close();
		sf.close();

	}

}
