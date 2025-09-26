package com.coforge.training.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.coforge.training.hibernatedemo.model.Employee;



/**
 * Hello world!
 *Hibernate Demo Application to save Employee Object using Hibernate ORM Tool
 */
public class EmployeeApp 
{
    public static void main( String[] args )
    {	
    	
    	//Configure hibernate app
        Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
        System.out.println("Configuration Object Created");
        
        //It is a factory of sessions
        SessionFactory factory=cfg.buildSessionFactory();
        System.out.println("SessionFactory Object Created");
        
        //Create physical connection with db
        Session session=factory.openSession();
        System.out.println("Session Object Created");
       
        //Create Transaction Object to handle Transactions
        Transaction tx=session.beginTransaction();
        System.out.println("Transaction Object Created");
        
        //Create Employee Object
        Employee emp=new Employee(106,"V","R",45000,"SDE","raturi@gmail.com");
       
        
        
        session.save(emp);  //Save Employee Object to DB
        
        
        tx.commit();
        System.out.println("Employee Object Saved");
        session.close();
        
        
        
        
        
    }
}
