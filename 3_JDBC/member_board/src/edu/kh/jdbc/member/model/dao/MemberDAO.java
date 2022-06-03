package edu.kh.jdbc.member.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.member.model.vo.Member;


public class MemberDAO {
	
	private Statement stmt;
	private PreparedStatement prestmt;
	private ResultSet rs;
	private Properties prop;
	
	public MemberDAO() { 
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("member_sql.xml"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param conn
	 * @param memberId
	 * @return result
	 * @throws Exception
	 * 아이디 중복검사
	 */
	public int duplicateCheck(Connection conn, String memberId)
	throws Exception
	{
		int result = -10;
		try {
			prestmt = conn.prepareStatement(prop.getProperty("duplicateCheck"));
			prestmt.setString(1, memberId);
			
			rs = prestmt.executeQuery();
			
			if(rs.next()) result = rs.getInt(1);
			
		}finally {
			close(rs);
			close(stmt);
		}
		return result;
	}


	public int signUp(Connection conn,Member signUpMember) 
	throws Exception{
		int result = -10;
		try {
			
			prestmt = conn.prepareStatement(prop.getProperty("signUp"));
			
			prestmt.setString(1, signUpMember.getMemberId());
			prestmt.setString(2, signUpMember.getMemberPw());
			prestmt.setString(3, signUpMember.getMemberName());
			prestmt.setString(4, String.valueOf(signUpMember.getMemberGender()));
//			문자열 개념이용	4,signUpMember.getMemberGender()+""
//			preparedStatement.setObject(4, signUpMember.getMemberGender(), java.sql.Types.CHAR);
//			preparedStatement.setString(4, String.valueOf(signUpMember.getMemberGender()));			
			
			result = prestmt.executeUpdate();

		}finally {
			close(stmt);
		}
		return result;
	}

	public Member login(Connection conn,Member mem) 
	throws Exception {
		
		Member loginMember = null;
		try {
			prestmt = conn.prepareStatement(prop.getProperty("login"));
			prestmt.setString(1, mem.getMemberId());
			prestmt.setString(2, mem.getMemberPw());
			
			rs = prestmt.executeQuery();
			
			if(rs.next()) {
				loginMember = new Member();
				loginMember.setMemberNo(rs.getInt("MEMBER_NO"));
				loginMember.setMemberId(rs.getString("MEMBER_ID"));
				loginMember.setMemberName(rs.getString("MEMBER_NM"));
				loginMember.setMemberGender(rs.getString("MEMBER_GENDER").charAt(0));
				loginMember.setEnrollDate(rs.getDate("ENROLL_DATE"));
			}
			
		}finally {
			close(rs);
			close(prestmt);
		}
		
		return loginMember;
	}

	public List<Member> selectAll(Connection conn) throws Exception {
		List<Member> memberList = new ArrayList<Member>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(prop.getProperty("selectAll"));
			
			while(rs.next()) {
				Member mem = new Member();
				mem.setMemberId(rs.getString("MEMBER_ID"));
				mem.setMemberName(rs.getString("MEMBER_NM"));
				mem.setEnrollDate(rs.getDate("ENROLL_DATE"));
				memberList.add(mem);
			}
		}finally {
			close(rs);
			close(stmt);
		}
		return memberList;
	}

	/**
	 * @param conn
	 * @param updateMem
	 * @return
	 * @throws Exception
	 */
	public int updateMyInfo(Connection conn, Member updateMem) throws Exception {
		int result = -10;
		try {
			prestmt = conn.prepareStatement(prop.getProperty("updateMyInfo"));
			prestmt.setString(1, updateMem.getMemberName());
			prestmt.setString(2, String.valueOf(updateMem.getMemberGender()));
			prestmt.setInt(3, updateMem.getMemberNo());
			
			result = prestmt.executeUpdate();
			
		}finally {
			close(stmt);
		}
		return result;
	}

	public int passCheck(Connection conn, int memberNo, String currentPw) throws Exception{
		int result = -10;
		try {
			prestmt = conn.prepareStatement(prop.getProperty("passCheck"));
			prestmt.setInt(1, memberNo);
			prestmt.setString(2, currentPw);
			
			rs = prestmt.executeQuery();
			if(rs.next()) result = 1;
			
		}finally {
			close(stmt);
			close(rs);
		}
		return result;
	}

	public int updatePass(Connection conn, Member updatePw)throws Exception {
		int result = -10;
		try {
			prestmt = conn.prepareStatement(prop.getProperty("updatePass"));
			prestmt.setString(1, updatePw.getMemberPw());
			prestmt.setInt(2, updatePw.getMemberNo());
			
			result = prestmt.executeUpdate();

		}finally {
			close(stmt);
		}
		return result;
	}

	public int secessionY(Connection conn, int memberNo) throws Exception {
		int result = -10;
		try {
			prestmt = conn.prepareStatement(prop.getProperty("secessionY"));
			prestmt.setInt(1, memberNo);
			result = prestmt.executeUpdate();
		}finally {
			close(stmt);
		}
		return result;
	}

}
