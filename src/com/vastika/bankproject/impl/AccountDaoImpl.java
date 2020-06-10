package com.vastika.bankproject.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vastika.bankproject.dao.AccountDao;
import com.vastika.bankproject.dbutil.*;
import com.vastika.bankproject.model.Account;

public class AccountDaoImpl implements AccountDao {

	public static final String INSERT_SQL = "insert into account_info_tbl(account_name, address, mobile_no) values(?,?,?)";

	@Override
	public int openAccount(Account account) {
		int saved =0;
		try (PreparedStatement ps = DBUtil.getConnection().prepareStatement(INSERT_SQL)) {
			ps.setString(1, account.getAccount_name());
			ps.setString(2, account.getAddress());
			ps.setInt(3, account.getMobile_no());
			saved = ps.executeUpdate();
			System.out.println("Data Inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return saved;
	}
}