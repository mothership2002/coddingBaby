package edu.kh.test.user.model.dao;

import static edu.kh.test.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.kh.test.user.model.vo.User;

public class UserDAO {
	
	private PreparedStatement pstmt;
	private ResultSet rs;

	/**
	 * @param conn
	 * @param userNo
	 * @return user
	 * @throws Exception
	 */
	public User searchUser(Connection conn, int userNo) throws Exception{
		User user = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM TB_USER WHERE USER_NO = ?");
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setUserNo(rs.getInt("USER_NO"));
				user.setUserID(rs.getString("USER_ID"));
				user.setUserName(rs.getString("USER_NAME"));
				user.setUserAge(rs.getInt("USER_AGE"));
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return user;
	}

	
	
}
