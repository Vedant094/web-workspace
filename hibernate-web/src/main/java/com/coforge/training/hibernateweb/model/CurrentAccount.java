/**
* Author  : Vedant.Raturi
* Date    : Sep 25, 2025
* Time    : 4:47:24 PM
* Project : hibernate-web
*/

package com.coforge.training.hibernateweb.model;

public class CurrentAccount extends Account {
	private double overdraftLimit;

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	
}
