package com.meritamerica.assignment3;

import java.text.ParseException;

public class CheckingAccount extends BankAccount {

	/*
	 * Constructor:
	 */

	public CheckingAccount(double balance) {
		super(balance);
	}

	/*
	 * Class methods:
	 */

	public double getInterestRate() {
		return 0.0001;
	}

	public static CheckingAccount readFromString(String accountData) throws ParseException {
		return null;
	}

}