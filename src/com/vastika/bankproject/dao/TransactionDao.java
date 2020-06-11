package com.vastika.bankproject.dao;

import java.util.List;

import com.vastika.bankproject.model.Transaction;

public interface TransactionDao {
	public int insert(Transaction trc);

	public int insertOrUpdateDepositFund(Transaction trc);

	public int updateBalance(Transaction trc);

	public List<Transaction> getAllTransactionInfo();

	public int delete(int id);
}
