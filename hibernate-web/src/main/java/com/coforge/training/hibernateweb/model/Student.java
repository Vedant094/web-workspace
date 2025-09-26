/**
* Author  : Vedant.Raturi
* Date    : Sep 25, 2025
* Time    : 10:26:30 AM
* Project : hibernate-web
*/


//This class represents a Student entity in the system using Hibernate ORM 
 //* with XML configuration.



package com.coforge.training.hibernateweb.model;

public class Student {
	private int id;
    private String name;
    private String email;
    private String password;
    private String course;
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
    
    
}
