package edu.kh.JDBC.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class JDBCExample1 {

	public static void main(String[] args) {
		
		// JDBC 객체 참조 변수 선언 java.sql
		
		Connection conn = null;
		// DB 연결 정보를 담은 객체
		Statement stmt = null;
		ResultSet rs = null;
		
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String type = "jdbc:oracle:thin:@"; 
			
			String ip = "127.0.0.1";
			String port = ":1521";
			String sdi = ":xe";
			String user = "ldh";
			String pw = "ldh1234";
			
			conn = DriverManager.getConnection(type + ip + port + sdi, user, pw);
			
			String sql = "SELECT EMP_ID,EMP_NAME,SALARY,DEPT_CODE FROM EMPLOYEE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				String deptCode = rs.getString("DEPT_CODE");
				
				System.out.printf("사번 : %d   이름 : %s    급여 : %7d    부서코드 : %s\n",
						empId,empName,salary,deptCode);
			}
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			System.out.println("OJDBC 라이브러리 미등록 또는 경로 불일치");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)	 rs.close(); 		//NullPointException 을 위한 if문
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
