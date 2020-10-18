package com.meritamerica.assignment3;

import java.text.ParseException;
import java.util.Date;

public class CDAccount extends BankAccount {

	/*
	 * Instance Variables:
	 */

	private CDOffering offering;

	/*
	 * Constructor:
	 */

	CDAccount(CDOffering offering, double balance) {
		super(balance);
		this.offering = offering;
	}

	/*
	 * Class methods:
	 */

	public double getInterestRate() {
		return this.offering.getInterestRate();
	}

	int getTerm() {
		return this.offering.getTerm();
	}

	public static CDAccount readFromString(String accountData) throws ParseException {
		return null;
	}

	@Override
	public boolean deposit(double amount) {
		return false;
	}

	@Override
	public boolean withdraw(double amount) {
		return false;
	}

	public double futureValue() {
		return this.getBalance() * (Math.pow(1 + this.getInterestRate(), this.getTerm()));
	}

}