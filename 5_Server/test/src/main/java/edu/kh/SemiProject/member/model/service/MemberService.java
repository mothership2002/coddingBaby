package edu.kh.SemiProject.member.model.service;

import static edu.kh.SemiProject.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.SemiProject.member.model.dao.MemberDAO;
import edu.kh.SemiProject.member.model.vo.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	public Member login(Member user) throws Exception{
		Connection conn = getConnection();
		Member result = dao.login(conn,user);
		close(conn);
		return result;
	}
	
	
}
