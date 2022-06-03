package edu.kh.jdbc.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


public class JDBCTemplate {
	//커넥션,jdbc자원 반환, tcl언어 등 반복적 사용 코드 범용 클래스
	
	/*
	 * getConnection()
	 * close(Connection,Statement,Resultset)
	 * commit(connection)
	 * rollback(connection)
	 */
	
	private static Connection conn;

	public static Connection getConnection() {
		try {
			if(conn == null||conn.isClosed()) {
				
				Properties prop = new Properties();
				prop.loadFromXML(new FileInputStream("driver.xml"));
				
				Class.forName(prop.getProperty("driver"));
				
				conn = DriverManager.getConnection(prop.getProperty("url"),
						prop.getProperty("user"),
						prop.getProperty("password"));
				
				conn.setAutoCommit(false);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) conn.isClosed();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) stmt.isClosed();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) rs.isClosed();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
