/**
* Author  : Vedant.Raturi
* Date    : Sep 25, 2025
* Time    : 4:09:16 PM
* Project : hibernate-web
*/

package com.coforge.training.hibernateweb.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    /*
     * @ElementCollection
     * Tells Hibernate this is not a relationship to another entity, 
     * but a collection of simple values (like List<String>).
     * Hibernate will automatically create a separate table to store these values.
  */

 /*
  * @CollectionTable
  * Specifies the name of that separate table (user_skills).
  * joinColumns = @JoinColumn(name = "user_id") defines the foreign key column 
  * that links each skill row back to the users table’s primary key.
  */
    // Simple List of Strings
    @ElementCollection
    @CollectionTable(name = "user_skills", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "skill")
    private List<String> skills = new ArrayList<>();

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

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
    
    
}

