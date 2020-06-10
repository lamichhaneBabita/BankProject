
package com.vastika.bankproject.model;

public class Transaction {
	private int account_info_id;
	private double deposite_amount;
	private double withdraw_amount;
	private double balance;

	public int getAccount_info_id() {
		return account_info_id;
	}

	public void setAccount_info_id(int account_info_id) {
		this.account_info_id = account_info_id;
	}

	public double getDeposite_amount() {
		return deposite_amount;
	}

	public void setDeposite_amount(double deposite_amount) {
		this.deposite_amount = deposite_amount;
	}

	public double getWithdraw_amount() {
		return withdraw_amount;
	}

	public void setWithdraw_amount(double withdraw_amount) {
		this.withdraw_amount = withdraw_amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double depositFund(double amount) {
		
		// }
		return balance +=amount;

	}

	public double withdraw(double amount) {
		return balance -= amount;
	}

}
