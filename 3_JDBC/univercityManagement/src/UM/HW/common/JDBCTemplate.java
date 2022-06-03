package UM.HW.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	private static Connection cont;
	
	public static Connection getConnection(){
		try {
			if(cont == null || cont.isClosed()) {
				Properties pt = new Properties();
				pt.loadFromXML(new FileInputStream("driver.xml"));
				Class.forName(pt.getProperty("driver"));
				cont = DriverManager.getConnection(pt.getProperty("url"),pt.getProperty("up"),pt.getProperty("up"));
				cont.setAutoCommit(false);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	return cont;	
	}
	
	public static void close(Connection cont) {
		try {
			if(cont != null && !cont.isClosed()) cont.isClosed();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement state) {
		try {
			if(state != null && !state.isClosed()) state.close();
			
		}catch (Exception e) {
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

	public static void commit(Connection cont) {
		try {
			if(cont != null && !cont.isClosed()) cont.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection cont) {
		try {
			if(cont != null && !cont.isClosed()) cont.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

	

