package com.meritamerica.assignment3;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;



public class CheckingAccount extends BankAccount {

	/*
	 * Class variables:
	 */
	
	static private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	/*
	 * Constructors:
	 */

	public CheckingAccount(double balance) {
		super(balance);
		this.interestRate = 0.0001;
	}
	
	public CheckingAccount(double balance, double interestRate) {
		super(balance,interestRate);
	}
	
	public CheckingAccount(long accountNumber, double balance, double interestRate) {
		super(accountNumber,balance,accountNumber);
	}
	
	public CheckingAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn) {
		super(accountNumber,balance,accountNumber,accountOpenedOn);
	}

	/*
	 * Class methods:
	 */

	public double getInterestRate() {
		return this.interestRate;
	}

	public static CheckingAccount readFromString(String accountData) throws ParseException {
		try {
			String[] newAccountHolder = accountData.split(",");
			Date startDate = formatter.parse(newAccountHolder[3]);

			return new CheckingAccount(Long.parseLong(newAccountHolder[0]),
				Double.parseDouble(newAccountHolder[1]),
				Double.parseDouble(newAccountHolder[2]),
				startDate);
		} catch (ParseException e) {
			throw new java.lang.NumberFormatException();
		}
	}
	
	

}