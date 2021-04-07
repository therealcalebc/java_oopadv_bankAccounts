/**
 * 
 */
package com.javaoopadv.bankering;

/**
 * @author ccomstock
 *
 */
public class BankAccount {
	private String _accountNumber;
	private double _checkingBalance;
	private double _savingsBalance;
	private static int _createdCount = 0;
	private static double _globalBalance = 0.0;
	
	public BankAccount() {
		_accountNumber = generateAccountNumber();
		_checkingBalance = 0.0;
		_savingsBalance = 0.0;
		_createdCount++;
	}
	
	public void displayAccountDetails() {
		System.out.println("Account Number: " + _accountNumber);
		System.out.printf("Checking Balance: %.2f\n", _checkingBalance);
		System.out.printf("Savings Balance: %.2f\n", _savingsBalance);
	}
	
	public double getCheckingBalance() { return _checkingBalance; }
	public double getSavingsBalance() { return _savingsBalance; }
	
	public boolean deposit(AccountType type, double amount) {
		if(type == AccountType.CHECKING)
			_checkingBalance += amount;
		else if(type == AccountType.SAVINGS)
			_savingsBalance += amount;
		else return false;
		_globalBalance += amount;
		return true;
	}
	
	public boolean withdraw(AccountType type, double amount) {
		if(type == AccountType.CHECKING) {
			if(_checkingBalance > amount) {
				_checkingBalance -= amount;
				_globalBalance -= amount;
				return true;
			}
			else return false;
		}
		else if(type == AccountType.SAVINGS) {
			if(_savingsBalance > amount) {
				_savingsBalance -= amount;
				_globalBalance -= amount;
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	public static int getCreatedCount() { return _createdCount; }
	public static double getGlobalBalance() { return _globalBalance; }

	private static String generateAccountNumber() { 
		int hi = (int)(Math.floor(Math.random() * 89998) + 10001);
		int lo = (int)(Math.floor(Math.random() * 89998) + 10001);
		return Integer.toString(hi) + Integer.toString(lo);
	}
	
}
