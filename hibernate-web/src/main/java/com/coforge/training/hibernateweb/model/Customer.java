/**
* Author  : Vedant.Raturi
* Date    : Sep 25, 2025
* Time    : 4:13:19 PM
* Project : hibernate-web
*/

/*
 * The Hibernate Component (or Embedded) mapping 
 * It is used to represent a value type that is a part of an entity and 
 * does not have its own identity.
 * 
 * The @Embeddable annotation in Hibernate is used to indicate that a class 
 * should be embedded within another entity.
 */
package com.coforge.training.hibernateweb.model;

public class Customer {
	private String name;
    private String email;
    private String address;
    
    
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
	
	}

