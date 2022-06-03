package edu.kh.JDBC.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample2 {

	public static void main(String[] args) {

		Connection cont = null;
		Statement state = null;
		ResultSet result = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String type = "jdbc:oracle:thin:@"; 
			
			String ip = "127.0.0.1";
			String port = ":1521";
			String sid = ":xe";
			String id = "ldh";
			String pw = "ldh1234";
			
			cont = DriverManager.getConnection(type+ip+port+sid,id,pw);
			state = cont.createStatement();
			
			String query = "SELECT EMP_NAME,SALARY,DEPT_TITLE,JOB_NAME FROM EMPLOYEE "
							+ "JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)"
							+ "JOIN JOB USING(JOB_CODE)"
							+ "WHERE SALARY >= 2500000"
							+ "ORDER BY JOB_CODE ASC";
			
			result = state.executeQuery(query);
			
			int i = 1;
			int sum = 0;
			
			while(result.next()) {
				String name = result.getString("EMP_NAME");
				int salary = result.getInt("SALARY");
				String deptTitle = result.getString("DEPT_TITLE");
				String jobName = result.getString("JOB_NAME");
				
				System.out.printf( "%2d  사원명 : %s   급여 : %7d원  부서명 : %-5s	직책 : %s   \n",
									i,name,salary,deptTitle,jobName);
				i++;
				sum += salary;
			}
			
			System.out.println("\n급여 합계 : " + sum + "원");
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				if(result != null) result.close();
				if(state != null) state.close();
				if(cont != null) cont.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
