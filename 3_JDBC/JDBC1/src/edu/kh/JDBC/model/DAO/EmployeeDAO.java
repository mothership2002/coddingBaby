package edu.kh.JDBC.model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.JDBC.model.vo.Employee;

public class EmployeeDAO {
	
	private Connection cont;
	private Statement state;
	private PreparedStatement prestate;
	private ResultSet reset;
	
	//1
	public List<Employee> selectAll() {
		
		List<Employee> empList = new ArrayList<Employee>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			cont = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","ldh","ldh1234");
												//		type		ip		port sid  id	password
			String query = "SELECT * FROM EMPLOYEE2 ORDER BY EMP_ID";
			
			state = cont.createStatement();
			reset = state.executeQuery(query);
			
			while(reset.next()) {
				int empID = reset.getInt("EMP_ID");
				String empName = reset.getString("EMP_NAME");
				String empNo = reset.getString("EMP_NO");
				String email = reset.getString("EMAIL");
				String phone = reset.getString("PHONE");
				String deptCode = reset.getString("DEPT_CODE");
				String jobCode = reset.getString("JOB_CODE");
				String salLevel = reset.getString("SAL_LEVEL");
				int salary = reset.getInt("SALARY");
				double bonus = reset.getDouble("BONUS");
				int managerID = reset.getInt("MANAGER_ID");
				Date hireDate = reset.getDate("HIRE_DATE");
				Date entDate = reset.getDate("ENT_DATE");
				char entYN = reset.getString("ENT_YN").charAt(0);
				
				Employee emp = new Employee
						(empID, empName, empNo, email, 
								phone, deptCode, jobCode, 
								salLevel, salary, bonus, managerID, 
								hireDate, entDate, entYN);
				empList.add(emp);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
				try {
					if(reset != null) reset.close();
					if(state != null) state.close();
					if(cont != null) cont.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return empList;
	}
	
	//2
	public Employee selectOne(int input) {
		
		Employee emp = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			cont = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","ldh","ldh1234");
												//		type		ip		port sid  id	password
			String query = "SELECT * FROM EMPLOYEE2 WHERE EMP_ID = "+ input;
			
			state = cont.createStatement();
			reset = state.executeQuery(query);
			
			if(reset.next()) {
				int empID = reset.getInt("EMP_ID");
				String empName = reset.getString("EMP_NAME");
				String empNo = reset.getString("EMP_NO");
				String email = reset.getString("EMAIL");
				String phone = reset.getString("PHONE");
				String deptCode = reset.getString("DEPT_CODE");
				String jobCode = reset.getString("JOB_CODE");
				String salLevel = reset.getString("SAL_LEVEL");
				int salary = reset.getInt("SALARY");
				double bonus = reset.getDouble("BONUS");
				int managerID = reset.getInt("MANAGER_ID");
				Date hireDate = reset.getDate("HIRE_DATE");
				Date entDate = reset.getDate("ENT_DATE");
				char entYN = reset.getString("ENT_YN").charAt(0);
				
				emp = new Employee
						(empID, empName, empNo, email, 
								phone, deptCode, jobCode, 
								salLevel, salary, bonus, managerID, 
								hireDate, entDate, entYN);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
				try {
					if(reset != null) reset.close();
					if(state != null) state.close();
					if(cont != null) cont.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return emp;
	}

	//6
	public List<Employee> salaryOver(int input) {
		
		List<Employee> salaryOverList = new ArrayList<Employee>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			cont = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","ldh","ldh1234");
												//		type		ip		port sid  id	password
			String query = "SELECT * FROM EMPLOYEE2 WHERE SALARY >= " + input;
			
			state = cont.createStatement();
			reset = state.executeQuery(query);
			
					
			while(reset.next()) {
				int empID = reset.getInt("EMP_ID");
				String empName = reset.getString("EMP_NAME");
				String empNo = reset.getString("EMP_NO");
				String email = reset.getString("EMAIL");
				String phone = reset.getString("PHONE");
				String deptCode = reset.getString("DEPT_CODE");
				String jobCode = reset.getString("JOB_CODE");
				String salLevel = reset.getString("SAL_LEVEL");
				int salary = reset.getInt("SALARY");
				double bonus = reset.getDouble("BONUS");
				int managerID = reset.getInt("MANAGER_ID");
				Date hireDate = reset.getDate("HIRE_DATE");
				Date entDate = reset.getDate("ENT_DATE");
				char entYN = reset.getString("ENT_YN").charAt(0);
				
				Employee emp = new Employee
						(empID, empName, empNo, email, 
								phone, deptCode, jobCode, 
								salLevel, salary, bonus, managerID, 
								hireDate, entDate, entYN);
				salaryOverList.add(emp);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
				try {
					if(reset != null) reset.close();
					if(state != null) state.close();
					if(cont != null) cont.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return salaryOverList;
	}


	//4
	public int insertEmployee(Employee insertEmployee) {
		
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			cont = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","ldh","ldh1234");
												//		type		ip		port sid  id	password

			cont.setAutoCommit(false);
			
			String query =  "INSERT INTO EMPLOYEE2 VALUES(?, ?, ?, ?, ?, ?, ?, 'S5', ?, ?, 200, SYSDATE, NULL, 'N')";
			
			prestate = cont.prepareStatement(query);
			
			prestate.setInt(1,insertEmployee.getEmpID());
			prestate.setString(2,insertEmployee.getEmpName());
			prestate.setString(3,insertEmployee.getEmpNo());
			prestate.setString(4,insertEmployee.getEmail());
			prestate.setString(5,insertEmployee.getPhone());
			prestate.setString(6,insertEmployee.getDeptCode());
			prestate.setString(7,insertEmployee.getJobCode());
			prestate.setInt(8,insertEmployee.getSalary());
			prestate.setDouble(9,insertEmployee.getBonus());
			
			result = prestate.executeUpdate();
			
			if(result>0) cont.commit();
			else		 cont.rollback();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(prestate != null) prestate.close();
				if(cont != null) cont.close(); //얘가 커밋해버림
			}catch(SQLException e ) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	
	//5
	public int deleteEmployee(int empID) {
		
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			cont = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","ldh","ldh1234");
												//		type		ip		port sid  id	password
			cont.setAutoCommit(false);
			
			String query =  "DELETE FROM EMPLOYEE2 WHERE EMP_ID = ? ";
			
			prestate = cont.prepareStatement(query);
			prestate.setInt(1,empID);
			
			result = prestate.executeUpdate();
			
			if(result>0) cont.commit();
			else		 cont.rollback();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(prestate != null) prestate.close();
				if(cont != null) cont.close();
			}catch(SQLException e ) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateEmployee(Employee update) {
		
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			cont = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","ldh","ldh1234");
			cont.setAutoCommit(false);
			
//			String sql = "UPDATE EMPLOYEE2 SET EMAIL = ?,"
//					+ "PHONE = ?,"
//					+ "SALARY = ? "
//					+ "WHERE EMP_ID = ?" ;
			
			String sql = "UPDATE EMPLOYEE2 SET EMAIL = '"+ update.getEmail()
						+ "',PHONE = '" + update.getPhone()
						+ "',SALARY = " + update.getSalary()
						+ " WHERE EMP_ID = " + update.getEmpID();

			state = cont.createStatement();
			
//			prestate = cont.prepareStatement(sql);
//			prestate.setString(1,update.getEmail());
//			prestate.setString(2,update.getPhone());
//			prestate.setInt(3,update.getSalary());
//			prestate.setInt(4,update.getEmpID());
			
			result = state.executeUpdate(sql);
			
//			result = prestate.executeUpdate();
			
			if(result>0) cont.commit();
			else		 cont.rollback();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				
				if(prestate != null) prestate.close();
				if(cont != null) cont.close();
				
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateBonus(Employee updateBn) {
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			cont = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","ldh","ldh1234");
												//		type		ip		port sid  id	password
			cont.setAutoCommit(false);
			
//			String query =  "UPDATE EMPLOYEE2 SET BONUS = " + updateBn.getBonus()
//							+" WHERE DEPT_CODE = '"+updateBn.getDeptCode()+"'";
//			state = cont.createStatement();

			String query = "UPDATE EMPLOYEE2 SET BONUS = ? WHERE DEPT_CODE = ?";
			prestate = cont.prepareStatement(query);
			prestate.setDouble(1, updateBn.getBonus());
			prestate.setString(2, updateBn.getDeptCode());
//			result = state.executeUpdate(query);
			result = prestate.executeUpdate();
			
			if(result>0) cont.commit();
			else		 cont.rollback();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(prestate != null) prestate.close();
				if(cont != null) cont.close();
			}catch(SQLException e ) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
}
