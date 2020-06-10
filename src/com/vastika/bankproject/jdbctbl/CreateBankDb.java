package com.vastika.bankproject.jdbctbl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateBankDb {
	public static final String URL = "jdbc:mysql://localhost:3306/";
	public static final String User_Name = "root";
	public static final String Password = "Mysql4B@b!";
	public static final  String Driver_Name = "com.mysql.jdbc.Driver";
	public static final String SQL = "create database bank_db";	
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		Statement st = null;
		
		try {
			Class.forName(Driver_Name);
			con = DriverManager.getConnection(URL, User_Name, Password);
			st = con.createStatement();
			st.executeUpdate(SQL);
			System.out.println("Database created");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try {
				con.close();
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
		}
	}

}
