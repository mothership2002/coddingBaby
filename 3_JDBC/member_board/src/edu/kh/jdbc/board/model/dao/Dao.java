package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.vo.Board;
import edu.kh.jdbc.board.model.vo.Reply;

public class Dao {
	
	private ResultSet rs;
	private Statement stmt;
	private PreparedStatement pstmt;
	private Properties prop;
	
	public Dao() { 
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("board_sql.xml"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<Board> selectAll(Connection conn) throws Exception{
		List<Board> selectAll = new ArrayList<Board>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(prop.getProperty("selectBoard"));
			
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getNString("BOARD_TITLE"));
				board.setReplyCount(rs.getInt("댓글 수"));
				board.setCreateDate(rs.getDate("CREATE_DATE"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setMemberName(rs.getString("MEMBER_NM"));
				selectAll.add(board);
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		return selectAll;
	}

	public Board selectBoard(Connection conn, int boardNo) throws Exception {
		Board board = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectOneBoard"));
			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new Board();
				board.setBoardNo(boardNo);
				board.setMemberNo(rs.getInt("MEMBER_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
				board.setCreateDate(rs.getDate("CREATE_DATE"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setMemberName(rs.getString("MEMBER_NM"));
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return board;
	}

	public List<Reply> selectReply(Connection conn, int boardNo) throws Exception {
		List<Reply> selectReply = new ArrayList<Reply>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectOneReply"));
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Reply reply = new Reply(); //reply_member_no
				reply.setMemberNo(rs.getInt("MEMBER_NO"));
				reply.setReplyNo(rs.getInt("REPLY_NO"));
				reply.setReplyName(rs.getString("MEMBER_NM"));
				reply.setReplyContent(rs.getString("REPLY_CONTENT"));
				reply.setCreateDate(rs.getDate("CREATE_DATE"));
				selectReply.add(reply);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return selectReply;
	}

	public int readCount(Connection conn, int boardNo)throws Exception {
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("readCount"));
			pstmt.setInt(1, boardNo);
				
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}

//	public int replyAdd(Connection conn, Member loginMember, String replyContent, int boardNo) throws Exception {
//		int result = -10;
//		try {
//			pstmt = conn.prepareStatement(prop.getProperty("replyAdd"));
//			pstmt.setString(1, replyContent);
//			pstmt.setInt(2, loginMember.getMemberNo());
//			pstmt.setInt(3, boardNo);
//			
//			result = pstmt.executeUpdate();
//			
//		}finally {
//			close(pstmt);
//		}
//		return result;
//	}

	public int boardUpdate(Connection conn, int boardNo, String boardContent)throws Exception {
		int result = -10;
		try {
			
			
		}finally {
			
		}
		return result;
	}

	public int boardDelete(Connection conn, int boardNo) throws Exception{
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("deleteBoard"));
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int replyDelete(Connection conn, int deleteReply, int memberNo) throws Exception {
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("deleteReply"));
			pstmt.setInt(1, deleteReply);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateBoard(Connection conn, Board board) throws Exception{
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updateboard"));
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, board.getBoardNo());
			
			result = pstmt.executeUpdate();
		}finally {
			close(conn);
		}
		
		return result;
	}

	public int insertReply(Connection conn, Reply reply) throws Exception{
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("replyAdd"));
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getMemberNo());
			pstmt.setInt(3, reply.getBoard_no());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(conn);
		}
		return result;
	}

	public int updateReply(Connection conn, Reply reply)throws Exception {
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updateReply"));
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getReplyNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(conn);
		}
		return result;
	}

	public int deleteReply(Connection conn, int replyNo) throws Exception{
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("deleteReply"));
			pstmt.setInt(1, replyNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(conn);
		}
		return result;
	}

	public int insertBoard(Connection conn, Board board)throws Exception {
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertBoard"));
			pstmt.setInt(3, board.getMemberNo());
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	public List<Board> searchBoard(Connection conn, String keyword, int selectNum)throws Exception {
		List<Board> searchBoards = new ArrayList<Board>();
		try {

			String sql = prop.getProperty("searchBoard1") + 
						prop.getProperty("condition" + selectNum) +
						prop.getProperty("searchboard2");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			if(selectNum == 3) pstmt.setString(2, keyword);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setReplyCount(rs.getInt("댓글 수"));
				board.setCreateDate(rs.getDate("CREATE_DATE"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setMemberName(rs.getString("MEMBER_NM"));
				searchBoards.add(board);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return searchBoards;
	}

}
