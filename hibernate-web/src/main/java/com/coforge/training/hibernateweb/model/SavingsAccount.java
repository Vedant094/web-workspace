/**
* Author  : Vedant.Raturi
* Date    : Sep 25, 2025
* Time    : 4:45:49 PM
* Project : hibernate-web
*/

package com.coforge.training.hibernateweb.model;

public class SavingsAccount extends Account {
	private double interestRate;

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	
}
