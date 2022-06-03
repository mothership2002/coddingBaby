package UM.HW.management.model.dao;

import static UM.HW.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import UM.HW.management.model.vo.LogVo;
import UM.HW.management.model.vo.ValueObject;

public class DAOforDML {
	
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstmt;
	private Properties prop;
	
	public DAOforDML() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("SQL_DML.xml"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int addAccount(Connection cont, LogVo lv) throws Exception {
		int result = -10;
		try {
			pstmt = cont.prepareStatement(prop.getProperty("insertAccount"));
			pstmt.setString(1, lv.getAccountId());
			pstmt.setString(2, lv.getAccountPw());
			pstmt.setString(3, lv.getAccountName());
			pstmt.setString(4, lv.getAccountSSN());
			pstmt.setString(5, lv.getAccountDept());
			pstmt.setString(6, lv.getAccountSSN());
			pstmt.setString(7, lv.getAccountName());
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertRecord(Connection cont, ValueObject check) throws Exception{
		int result = -10;
		try {
			pstmt = cont.prepareStatement(prop.getProperty("insertRecord"));
			pstmt.setString(1, check.getClassName());
			pstmt.setString(2, check.getStudentNo());
			pstmt.setDouble(3, check.getStudenRecord());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertStudents(Connection cont, ArrayList<ValueObject> insertStudents) throws Exception{
		int result = 0;
		try {
			for(ValueObject vo : insertStudents) {
				pstmt = cont.prepareStatement(prop.getProperty("insertStudent"));
				pstmt.setString(1, vo.getStudentNo());
				pstmt.setString(2, vo.getStudentName());
				pstmt.setString(3, vo.getStudentSSN());
				pstmt.setString(4, vo.getStudentPhone());
				pstmt.setString(5, vo.getStudentEmail());
				pstmt.setString(6, vo.getStudentAdress());
				pstmt.setString(7, vo.getStudentDepartment());
				pstmt.setString(8, vo.getAdmissoinString());
				result = result + pstmt.executeUpdate();
			}
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int accessY(Connection cont, int accountNo) throws Exception{
		int result = 0 ;
		try {
			pstmt = cont.prepareStatement(prop.getProperty("accessUpdateAll"));
			pstmt.setInt(1, accountNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ValueObject accountCheck(Connection cont, ValueObject accountNo) throws Exception {
		ValueObject accountCheck = new ValueObject();
		try {
			pstmt = cont.prepareStatement(prop.getProperty("accountCheck"));
			pstmt.setInt(1, accountNo.getAccountNo());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				close(pstmt);
				pstmt = cont.prepareStatement(prop.getProperty("accountCheck2"));
				pstmt.setInt(1, accountNo.getAccountNo());
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) accountCheck.setProName(rs.getString("ACCOUNT_NAME"));
				
			}else {
				accountCheck = null;
			}
			
		}finally {
			close(pstmt);
		}
		return accountCheck;
	}

	public int updateGrade(Connection cont) throws Exception{
		int result = -10;
		try {
			stmt = cont.createStatement();
			result = stmt.executeUpdate(prop.getProperty("updateGrade"));
			
		}finally {
			close(stmt);
		}
		return result;
	}


}
