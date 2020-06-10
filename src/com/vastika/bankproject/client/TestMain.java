package com.vastika.bankproject.client;

import java.util.Scanner;

import com.vastika.bankproject.dao.AccountDao;
import com.vastika.bankproject.dao.TransactionDao;
import com.vastika.bankproject.impl.AccountDaoImpl;
import com.vastika.bankproject.impl.TransactionDaoImpl;
import com.vastika.bankproject.model.Account;
import com.vastika.bankproject.model.Transaction;

public class TestMain {
	public static void main(String[] args) {
		AccountDao ad = new AccountDaoImpl();
		TransactionDao bd = new TransactionDaoImpl();
		Scanner sc = new Scanner(System.in);
		

		String decision = "";
		do {

			System.out.println("Which operation do you want to do? ");
			String choice = sc.next();

			switch (choice) {
			case "create":
				System.out.println("Enter Account Name: ");
				String acc_name = sc.next();
				Account acc = new Account();

				System.out.println("Enter Address: ");
				String add = sc.next();

				System.out.println("Enter Mobile Number: ");
				int mbl = sc.nextInt();

				acc.setAccount_name(acc_name);
				acc.setAddress(add);
				acc.setMobile_no(mbl);

				int saved = ad.openAccount(acc);
				if (saved >= 1) {
					System.out.println("account info is successfully saved into database: ");
				} else {
					System.out.println("Error.......!!");
				}
				break;
			case "deposit":
				Transaction tranc = new Transaction();

				System.out.println("Enter a account id: ");
				int acc_id = sc.nextInt();

				System.out.println("Enter a deposit amount");
				double dep_amt = sc.nextDouble();

				tranc.setAccount_info_id(acc_id);

				tranc.setDeposite_amount(dep_amt);

				tranc.setWithdraw_amount(0);

				tranc.depositFund(dep_amt);
				
				bd.insertOrUpdateDepositFund(tranc);

				break;
				
			case "Withdraw":
				Transaction trn = new Transaction();

				System.out.println("Enter a account id: ");
				int account_id = sc.nextInt();

				System.out.println("Enter a Withdraw amount");
				double withdraw_amount = sc.nextDouble();

				trn.setAccount_info_id(account_id);
				trn.setDeposite_amount(0);
				trn.setWithdraw_amount(withdraw_amount);

				

				trn.withdraw(withdraw_amount);
				bd.updateBalance(trn);
				//bd.insert(trn);
				
				
				break;

			default:
				System.out.println("Wrong choice!!");
			}

			System.out.println("Do you want to do more operation?");
			decision = sc.next();

		} while (decision.equalsIgnoreCase("yes"));
		System.out.println("Try again later....... Thank you!");
	}

}
