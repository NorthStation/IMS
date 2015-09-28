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
 * DBConnection���������ݿ�
 * @author Administrator
 *
 */
public class DBConnection {
	//���ݿ��û���
	private static String user;
	//���ݿ��������
	private static String password;
	//���ݿ���������
	private static String driver;
	//���ݿ��������ַ
	private static String url;
	//����properties����
	private static Properties pro = new Properties();
	
	/*//��������
	static {
		try {
			//��ȡ�����ļ������·��
			String path = DBConnection.class.getResource("").getPath();
			//����������
			InputStream is = new FileInputStream(path + "config.properties");
			//����������
			pro.load(is);
			//��ȡ��Ӧvalueֵ
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			
			//����������
			Class.forName(driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}*/
	//��������
	static {
		//��ȡ��Ӧvalueֵ
		user = "ims";
		password = "admin";
		driver = "oracle.jdbc.OracleDriver";
		url = "jdbc:oracle:thin:@localhost:1521:orcl";
		
		//����������
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//��ȡ���ݿ�����
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,user,password);
	}
	
	//�ر���Դ
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
