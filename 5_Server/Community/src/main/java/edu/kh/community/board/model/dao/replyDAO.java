package edu.kh.community.board.model.dao;

import static edu.kh.community.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.community.board.model.vo.Reply;


public class ReplyDAO {
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ReplyDAO() {
		try {
			prop = new Properties();
			String filePath = ReplyDAO.class.getResource("/edu/kh/community/sql/reply-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Reply> selectReplyList(Connection conn, int boardNo) throws Exception{
		List<Reply> rList = new ArrayList<Reply>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectReplyList"));
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Reply r = new Reply();
				r.setReplyNo(rs.getInt(1));
				r.setReplyContent(rs.getString(2));
				r.setCreateDate(rs.getString(3));
				r.setBoardNo(rs.getInt(4));
				r.setMemberNo(rs.getInt(5));
				r.setMemberNickname(rs.getString(6));
				r.setProfileImage(rs.getString(7));
				rList.add(r);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return rList;
	}

	public int replyInsert(Connection conn, Reply reply) throws Exception{
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("replyInsert"));
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getMemberNo());
			pstmt.setInt(3, reply.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int replyDelete(Connection conn, int replyNo) throws Exception{
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("replyDelete"));
			pstmt.setInt(1, replyNo);
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateReply(Connection conn, int replyNo, String replyContent) throws Exception{
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updateReply"));
			pstmt.setString(1, replyContent);
			pstmt.setInt(2, replyNo);
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
}
