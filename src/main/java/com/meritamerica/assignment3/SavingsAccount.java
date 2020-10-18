package com.meritamerica.assignment3;

import java.text.ParseException;

public class SavingsAccount extends BankAccount {

	/*
	 * Constructor:
	 */

	public SavingsAccount(double balance) {
		super(balance);
	}

	/*
	 * Class methods:
	 */

	public double getInterestRate() {
		return 0.01;
	}

	public SavingsAccount readFromString(String accountData) throws ParseException {
		return null;
	}

}