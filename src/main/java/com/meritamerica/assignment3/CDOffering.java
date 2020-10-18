package com.meritamerica.assignment3;

public class CDOffering {
	
	/*
	 * Instance Variables:
	 */
	
	private double interestRate;
	private int term;
	
	/*
	 * Constructor:
	 */
	
	CDOffering(int term, double interestRate) {
		this.interestRate = interestRate;
		this.term = term;
	}
	
	/*
	 * Methods:
	 */
	
	int getTerm() {
		return this.term;
	}
	double getInterestRate() {
		return this.interestRate;
	}
	
	static CDOffering readFromString(String cdOfferingDataString){
		return null;
	}

}