package edu.kh.jdbc.member.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.model.vo.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();
	private Connection conn;
	
	/**
	 * @param memberId
	 * @return int
	 * @throws Exception
	 */
	public int duplicateCheck(String memberId) throws Exception{
		
		conn = getConnection();
		int result = dao.duplicateCheck(conn,memberId);
		close(conn);
		return result;
	}

	/**
	 * @param signUpMember
	 * @return int
	 * @throws Exception
	 */
	public int signUp(Member signUpMember) throws Exception{
		
		conn = getConnection();
		int result = dao.signUp(conn,signUpMember);		
		if(result>0) commit(conn);
		else		 rollback(conn);
		close(conn);
		return result;
	}

	/**
	 * @param mem
	 * @return
	 * @throws Exception
	 */
	public Member login(Member mem) throws Exception {
		
		conn = getConnection();
		Member loginMember = dao.login(conn,mem);
		close(conn);
		return loginMember;
	}

	public List<Member> selectAll() throws Exception{
		
		conn = getConnection();
		List<Member> memberList = dao.selectAll(conn);
		close(conn);
		return memberList;
	}

	public int updateMyinfo(Member updateMem) throws Exception {
		
		conn = getConnection();
		int result = dao.updateMyInfo(conn,updateMem);
		if(result > 0) commit(conn);
		else		   rollback(conn);
		close(conn);
		return result;	
	}

	public int passCheck(int memberNo, String currentPw) throws Exception {
		conn = getConnection();
		int result = dao.passCheck(conn,memberNo,currentPw);
		close(conn);
		return result;
	}

	public int updatePw(Member updatePw) throws Exception {
		conn = getConnection();
		int result = dao.updatePass(conn,updatePw);
		if(result > 0) commit(conn);
		else		   rollback(conn);
		close(conn);
		return result;
	}

	public int secessionY(int memberNo) throws Exception {
		conn = getConnection();
		int result = dao.secessionY(conn,memberNo);
		if(result > 0) commit(conn);
		else		   rollback(conn);
		close(conn);
		return result;
	}



}