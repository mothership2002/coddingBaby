package edu.kh.community.member.model.service;

import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import edu.kh.community.member.model.dao.MemberDAO;
import edu.kh.community.member.model.vo.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	/**
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Member member) throws Exception{
		Connection conn = getConnection();
		Member loginMember = dao.login(conn,member);
		close(conn);
		return loginMember;
	}

	public int signUp(Member member) throws Exception{
		Connection conn = getConnection();
		int result = dao.signUp(conn,member);
		if(result>0) commit(conn);
		else		 rollback(conn);
		close(conn);
		return result;
	}

	public int updateInfo(Member updateMember) throws Exception{
		Connection conn = getConnection();
		int result = dao.updateInfo(conn,updateMember);
		if(result >0) commit(conn);
		else		  rollback(conn);
		close(conn);
		return result;
	}

	public int passwordCheck(int memberNo ,HashMap<String, String> sendPw) throws Exception {
		Connection conn = getConnection();
		int result = dao.updatePW(conn,memberNo,sendPw);
		if(result > 0) commit(conn);
		else		   rollback(conn);
		close(conn);
		return result;
	}

	public int secessionAgree(int memberNo, String secessionAgree) throws Exception{
		Connection conn = getConnection();
		int result = dao.secessionAgree(conn,memberNo,secessionAgree);
		if(result>0)	commit(conn);
		else			rollback(conn);
		close(conn);
		return result;
	}

	public int emailDupCheck(String memberEmail) throws Exception{
		Connection conn = getConnection();
		int result = dao.emailDupCheck(conn,memberEmail);
		close(conn);
		return result;
	}

	public int nicknameDup(String nicknameDup)throws Exception {
		Connection conn = getConnection();
		int result = dao.nicknameDupCheck(conn,nicknameDup);
		close(conn);
		return result;
	}

	public Member selectOne(String email) throws Exception{
		Connection conn = getConnection();
		Member result = dao.selectOne(conn,email);
		close(conn);
		return result;
	}

	public List<Member> selectAll() throws Exception{
		Connection conn = getConnection();
		List<Member> result = dao.selectAll(conn);
		close(conn);
		return result;
	}

	public int updateProfileImage(int memberNo, String profileImage) throws Exception{
		Connection conn = getConnection();
		int result = dao.updateProfileImage(conn,memberNo,profileImage);
		if(result>0)	commit(conn);
		else			rollback(conn);
		close(conn);
		return result;
	}

}
