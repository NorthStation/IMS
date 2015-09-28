package com.lms.zx.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * DBConnection：连接数据库
 * @author Administrator
 *
 */
public class DBConnection {
	//数据库用户名
	private static String user;
	//数据库访问密码
	private static String password;
	//数据库驱动类名
	private static String driver;
	//数据库服务器地址
	private static String url;
	//创建properties对象
	private static Properties pro = new Properties();
	
	/*//加载驱动
	static {
		try {
			//获取配置文件的相对路径
			String path = DBConnection.class.getResource("").getPath();
			//创建输入流
			InputStream is = new FileInputStream(path + "config.properties");
			//加载输入流
			pro.load(is);
			//获取相应value值
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			
			//加载驱动类
			Class.forName(driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}*/
	//加载驱动
	static {
		//获取相应value值
		user = "ims";
		password = "admin";
		driver = "oracle.jdbc.OracleDriver";
		url = "jdbc:oracle:thin:@localhost:1521:orcl";
		
		//加载驱动类
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//获取数据库连接
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,user,password);
	}
	
	//关闭资源
	public static void close(Connection con,Statement stmt,ResultSet rs) throws SQLException {
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(con != null) con.close();
	}
	
	public static void close(Connection con,Statement stmt) throws SQLException {
		if(stmt != null) stmt.close();
		if(con != null) con.close();
	}
}
