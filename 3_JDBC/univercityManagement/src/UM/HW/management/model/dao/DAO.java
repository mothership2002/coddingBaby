package UM.HW.management.model.dao;

import static UM.HW.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import UM.HW.management.model.vo.LogVo;
import UM.HW.management.model.vo.ValueObject;

public class DAO {
	
	private ResultSet rs;
	private Statement stmt;
	private PreparedStatement pstmt;
	private Properties prop;
	
	public DAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("SQL_DQL.xml"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<ValueObject> selectStudent(Connection cont, String departmentName) throws Exception {
		
		List<ValueObject> selectStudents = new ArrayList<ValueObject>();
		try {
			
			pstmt = cont.prepareStatement(prop.getProperty("selectStudents"));
			pstmt.setString(1, departmentName);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ValueObject vo = new ValueObject();
				vo.setStudentNo(rs.getString("STUDENT_NO"));
				vo.setStudentName(rs.getString("STUDENT_NAME"));
				vo.setStudentAge(rs.getInt("나이"));
				vo.setStudentPhone(rs.getString("STUDENT_PHN"));
				vo.setStudentEmail(rs.getString("STUDENT_EMAIL"));
				vo.setStudentAdress(rs.getString("STUDENT_ADR"));
				vo.setStudentGrade(rs.getInt("STUDENT_GRD"));
				vo.setAdmission(rs.getDate("ADMISSION"));
				selectStudents.add(vo);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return selectStudents;
	}

	public List<ValueObject> selectProfessor(Connection cont, String departmentName) throws Exception{
		
		List<ValueObject> selectProfessor = new ArrayList<ValueObject>();
		try {
			
			pstmt = cont.prepareStatement(prop.getProperty("selectProfessor"));
			pstmt.setString(1, departmentName);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ValueObject vo = new ValueObject();
				vo.setProName(rs.getString("PRO_NAME"));
				vo.setProAge(rs.getInt("나이"));
				selectProfessor.add(vo);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return selectProfessor;
		
	}
	

	public List<ValueObject> studentGrade(Connection cont, String studentName, String studentNo)throws Exception {
		List<ValueObject> studentGrade = new ArrayList<ValueObject>();
		try {
			pstmt = cont.prepareStatement(prop.getProperty("studentGrade"));
			pstmt.setString(1, studentNo);
			pstmt.setString(2, studentName);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ValueObject sr = new ValueObject();
				sr.setClassName(rs.getString("CLASS_NAME"));
				sr.setStudenRecord(rs.getDouble("CLS_GRADE"));
				studentGrade.add(sr);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return studentGrade;
	}

	public List<ValueObject> professorMessenger(Connection cont, String proDept, String proName) throws Exception{
		List<ValueObject> proMess = new ArrayList<ValueObject>();
		try {
			pstmt = cont.prepareStatement(prop.getProperty("professorMessenger"));
			pstmt.setString(1, proDept);
			pstmt.setString(2, proName);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ValueObject pm = new ValueObject();
				pm.setProEmail(rs.getString("PRO_EMAIL"));
				pm.setProPhone(rs.getString("PRO_PHN"));
				proMess.add(pm);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return proMess;
	}

	public int duplicateCheck(Connection cont, String id) throws Exception {
		int result = -10;
		try {
			pstmt = cont.prepareStatement(prop.getProperty("duplicateCheck"));
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) result = 1;
			else 		  result = 0;
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public int checkProfessor(Connection cont, LogVo check)throws Exception {
		int result = -10;
		try {
			pstmt = cont.prepareStatement(prop.getProperty("checkProfessor"));
			pstmt.setString(1, check.getAccountName());
			pstmt.setString(2, check.getAccountSSN());
			pstmt.setString(3, check.getAccountDept());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) result = 1;
			else 		  result = 0;
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public LogVo login(Connection cont, LogVo login) throws Exception {
		LogVo result = new LogVo();
		try {
			pstmt = cont.prepareStatement(prop.getProperty("login"));
			pstmt.setString(1, login.getAccountId());
			pstmt.setString(2, login.getAccountPw());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result.setAccountId(rs.getString("ACCOUNT_ID"));
				result.setAccountName(rs.getString("ACCOUNT_NAME"));
				result.setAccess_YN(rs.getString("ACCESS_YN").charAt(0));
			}
			else result = null;
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public int checkStudent(Connection cont, ValueObject check) throws Exception{
		int result = -10;
		try {
			pstmt = cont.prepareStatement(prop.getProperty("checkStudent"));
			pstmt.setString(1, check.getStudentName());
			pstmt.setString(2, check.getStudentNo());
			
			rs = pstmt.executeQuery();
			if(rs.next()) result = 1;
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public int adminCheck(Connection cont, LogVo login) throws Exception{
		int result = -10;
		try {
			pstmt = cont.prepareStatement(prop.getProperty("adminCheck"));
			pstmt.setString(1, login.getAccountId());
			pstmt.setString(2, login.getAccountPw());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) result = 1;
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public int dpcStudentNo(Connection cont, String studentNo) throws Exception{
		int result = -10;
		try {
			pstmt = cont.prepareStatement(prop.getProperty("dpcSN"));
			pstmt.setString(1, studentNo);
			
			rs = pstmt.executeQuery();

			if(rs.next()) result = 1;
			else	result = 0;
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public List<ValueObject> PAAC(Connection cont) throws Exception {
		List<ValueObject> PAAC = new ArrayList<ValueObject>();
		try {
			stmt = cont.createStatement();
			rs = stmt.executeQuery(prop.getProperty("proAccountAccessCheck"));
			while(rs.next()) {
				ValueObject pa = new ValueObject();
				pa.setAccountNo(rs.getInt("ACCOUNT_NO"));
				pa.setProName(rs.getString("PRO_NAME"));
				pa.setDepartMentName(rs.getString("DEPARTMENT_NAME"));
				PAAC.add(pa);
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		return PAAC;
	}


	
	
}
