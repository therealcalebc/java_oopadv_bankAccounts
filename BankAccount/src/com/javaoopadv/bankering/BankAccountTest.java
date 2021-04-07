/**
 * 
 */
package com.javaoopadv.bankering;

/**
 * @author ccomstock
 *
 */
public class BankAccountTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BankAccount bA1 = new BankAccount();
		BankAccount bA2 = new BankAccount();
		System.out.printf("\ncreated %d BankAccounts, bA1 & bA2", BankAccount.getCreatedCount());
		bA1.deposit(AccountType.CHECKING, 100);
		bA1.deposit(AccountType.SAVINGS, 1000);
		bA2.deposit(AccountType.CHECKING, 200);
		bA2.deposit(AccountType.SAVINGS, 2000);
		System.out.println("\nmade initial deposits to both accounts...\n");
		System.out.println("bA1 details:");
		bA1.displayAccountDetails();
		System.out.println("bA2 details:");
		bA2.displayAccountDetails();
		if(bA1.withdraw(AccountType.CHECKING, 200))
			System.out.print("\nwithdrew 200 from bA1 checking");
		else System.out.print("\ncould not withdraw 200 from bA1 checking, ");
		System.out.printf("the current balance is %.2f\n", bA1.getCheckingBalance());
		if(bA2.withdraw(AccountType.SAVINGS, 500))
			System.out.print("\nwithdrew 500 from bA2 savings");
		else System.out.print("\ncould not withdraw 500 from bA2 savings, ");
		System.out.printf("the current balance is %.2f\n", bA2.getSavingsBalance());
		System.out.println("\nthe current total balance in all accounts is " 
								+ String.format("%.2f", BankAccount.getGlobalBalance()));
	}

}
