package com.vastika.bankproject.sqlquery;

public class SqlQuery {
	public static final String INSERT_SQL = "insert into account_balance_tbl(account_info_id,deposit_amount, withdraw_amount, balance) values(?,?,?,?)";
	public static final String UPDATE_SQL = "update account_balance_tbl set deposit_amount=?,  withdraw_amount=?, balance = ? where account_info_id = ?";
	public static final String SELECT_SQL = "select * from account_balance_tbl";
	public static final String SELECT_BY_ID = "select * from account_balance_tbl where account_info_id = ?";
	
	public static final String DELETE_SQL = "delete from account_balance_tbl where account_info_id=?";

}
