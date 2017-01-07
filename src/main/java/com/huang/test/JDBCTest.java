package com.huang.test;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JDBCTest {
	
	public static void main(String[] agrs){
		String driver ="com.mysql.jdbc.Driver";
    	//从配置参数中获取数据库url
    	String url = "jdbc:mysql://127.0.0.1:3306/moana_db";
    	//从配置参数中获取用户名
    	String user = "root";
    	//从配置参数中获取密码
    	String pass = "root";

    	//注册驱动
    	try {
			Class.forName(driver);
			//获取数据库连接
	    	Connection conn = (Connection) DriverManager.getConnection(url,user,pass);
	    	//创建Statement对象
	    	Statement stmt = (Statement) conn.createStatement();
	    	//执行查询
	    	ResultSet rs = stmt.executeQuery("select * from user");


	    	String s = "wongmx";
	    	
	    	System.out.print(s);
	    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
}
