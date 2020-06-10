package com.vastika.bankproject.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static final String URL = "jdbc:mysql://localhost:3306/bank_db";
	public static final String User_Name = "root";
	public static final String Password = "Mysql4B@b!";
	public static final  String Driver_Name = "com.mysql.jdbc.Driver";

	public static Connection getConnection()  throws SQLException{
		return DriverManager.getConnection(URL, User_Name, Password);
	}
}
