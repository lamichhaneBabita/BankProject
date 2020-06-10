package com.vastika.bankproject.jdbctbl;

import java.sql.Connection;
import java.sql.Statement;

import com.vastika.bankproject.dbutil.DBUtil;

public class CreateBankTbl {
//public static final String SQL = "create table account_info_tbl(id int not null auto_increment, account_name varchar(50), address varchar(50), mobile_no int, primary key(id))";	
	public static final String SQL = "create table account_balance_tbl(account_info_id int not null, deposit_amount double, withdraw_amount double, balance double, foreign key(account_info_id) references account_info_tbl(id))";	

	public static void main(String[] args) {
		try(Connection con = DBUtil.getConnection();
				Statement st = con.createStatement();){
			st.executeUpdate(SQL);
			System.out.println("Table Created");
		}catch (Exception e) {
			e.printStackTrace();
		}
					
				
	}

}
