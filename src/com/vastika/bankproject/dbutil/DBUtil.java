package com.vastika.bankproject.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static final String URL = "jdbc:mysql://localhost:3306/bank_db";
	public static final String USER_NAME = "root";
	public static final String password = "Mysql4B@b!";
	public static final  String DRIVER_NAME = "com.mysql.jdbc.Driver";

	public static Connection getConnection()  throws SQLException{
		return DriverManager.getConnection(URL, USER_NAME, password);
	}
}
