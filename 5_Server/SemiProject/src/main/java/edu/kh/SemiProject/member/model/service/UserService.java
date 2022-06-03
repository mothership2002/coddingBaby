package edu.kh.SemiProject.member.model.service;

import static edu.kh.SemiProject.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.SemiProject.member.model.dao.UserDAO;
import edu.kh.SemiProject.member.model.vo.User;

public class UserService {
	
	private UserDAO dao = new UserDAO();

	public User login(User user) throws Exception{
		Connection conn = getConnection();
		User result = dao.login(conn,user);
		close(conn);
		return result;
	}
	
	
}