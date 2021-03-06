package edu.kh.test.user.model.service;

import static edu.kh.test.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.test.user.model.dao.UserDAO;
import edu.kh.test.user.model.vo.User;


public class UserService {
	
	private UserDAO dao = new UserDAO();

	/**
	 * @param userNo
	 * @return user
	 * @throws Exception
	 */
	public User searchUser(int userNo) throws Exception{
		Connection conn = getConnection();
		User user = dao.searchUser(conn,userNo);
		close(conn);
		return user;
	}
	
}
