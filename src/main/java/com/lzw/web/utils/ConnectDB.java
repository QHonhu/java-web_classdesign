package com.lzw.web.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static String driverName ;
	private static String url;
	private static String username ;
	private static String password ;
	
	static{
		driverName = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/imooc?characterEncoding=utf-8";
		username = "root";
		password = "";
	}
	
	public static Connection open()
	{
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载驱动失败");
		}
		try {
			return DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection conn)
	{
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
