package edu.kh.community.member.model.dao;

import static edu.kh.community.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import edu.kh.community.member.model.vo.Member;

public class MemberDAO {
	
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public MemberDAO() {
		try {
			prop = new Properties();
			String filePath = MemberDAO.class.getResource
					("/edu/kh/community/sql/member-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Member login(Connection conn, Member member)throws Exception {
		Member loginMember = null;
		try {
			String sql = prop.getProperty("login");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberEmail());
			pstmt.setString(2, member.getMemberPW());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginMember = new Member();
				loginMember.setMemberNo(rs.getInt("MEMBER_NO"));
	            loginMember.setMemberEmail( rs.getString("MEMBER_EMAIL")  );
	            loginMember.setMemberNickname( rs.getString("MEMBER_NICK")  );
	            loginMember.setMemberTel( rs.getString("MEMBER_TEL")  );
	            loginMember.setMemberAddress( rs.getString("MEMBER_ADDR")  );
	            loginMember.setProfileImage( rs.getString("PROFILE_IMG")  );
	            loginMember.setEnrollDate( rs.getString("ENROLL_DT")  );
			}

		}finally {
			close(rs);
			close(pstmt);
		}
		return loginMember;
	}

	public int signUp(Connection conn, Member member) throws Exception{
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("signUp"));
			pstmt.setString(1, member.getMemberEmail());
			pstmt.setString(2, member.getMemberPW());
			pstmt.setString(3, member.getMemberNickname());
			pstmt.setString(4, member.getMemberTel());
			pstmt.setString(5, member.getMemberAddress());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateInfo(Connection conn, Member updateMember)throws Exception {
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updateInfo"));
			pstmt.setString(1, updateMember.getMemberNickname());
			pstmt.setString(2, updateMember.getMemberTel());
			pstmt.setString(3, updateMember.getMemberAddress());
			pstmt.setInt(4, updateMember.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updatePW(Connection conn, int memberNo, HashMap<String, String> sendPw) throws Exception{
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updatePW"));
			pstmt.setString(1, sendPw.get("updatePW"));
			pstmt.setInt(2, memberNo);
			pstmt.setString(3, sendPw.get("currentPW"));
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int secessionAgree(Connection conn, int memberNo, String secessionAgree) throws Exception{
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("secessionAgree"));
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, secessionAgree);
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int emailDupCheck(Connection conn, String memberEmail) throws Exception{
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("emailDupCheck"));
			pstmt.setString(1, memberEmail);
			rs = pstmt.executeQuery();
			if(rs.next())	result = rs.getInt(1);
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public int nicknameDupCheck(Connection conn, String nicknameDup)throws Exception{
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("nicknameDup"));
			pstmt.setString(1, nicknameDup);
			rs = pstmt.executeQuery();
			if(rs.next())		result = rs.getInt(1);
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public Member selectOne(Connection conn, String email) throws Exception{
		Member result = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectOne"));
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new Member();
				result.setMemberEmail(rs.getString(1));
				result.setMemberNickname(rs.getString(2));
				result.setMemberTel(rs.getString(3));
				result.setMemberAddress(rs.getString(4));
				result.setEnrollDate(rs.getString(5));
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public List<Member> selectAll(Connection conn) throws Exception{
		List<Member> result = new ArrayList<Member>();;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(prop.getProperty("selectAll"));
			while(rs.next()) {
				Member member = new Member();
				member.setMemberNo(rs.getInt(1));
				member.setMemberEmail(rs.getString(2));
				member.setMemberNickname(rs.getString(3));
				result.add(member);
			}
		}finally {
			close(rs);
			close(stmt);
		}
		return result;
	}

	public int updateProfileImage(Connection conn, int memberNo, String profileImage) throws Exception{
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updateProfileImage"));
			pstmt.setString(1, profileImage);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
