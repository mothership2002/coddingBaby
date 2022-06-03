package edu.kh.SemiProject.member.model.dao;

import static edu.kh.SemiProject.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.SemiProject.member.model.vo.User;

public class UserDAO {

	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public UserDAO() {
		try {
			prop = new Properties();
			String filePath = UserDAO.class.getResource
					("/edu/kh/SemiProject/sql/User_sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public User login(Connection conn, User user) throws Exception {
		User result = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("login"));
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPW());
			rs = pstmt.executeQuery();
			
			//vo에 데이터 저장할 애들
			if(rs.next()) {
				result = new User();
				result.setUserNo(rs.getInt(1));
				result.setUserID(rs.getString(2));
				result.setUserEmail(rs.getString(3));
				result.setUserName(rs.getString(4));
				result.setUserTel(rs.getString(5));
				result.setUserProfile(rs.getString(6));
				result.setGrade(rs.getString(7));
				result.setPoint(rs.getInt(8));
				result.setRegistDate(rs.getString(9));
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

}
