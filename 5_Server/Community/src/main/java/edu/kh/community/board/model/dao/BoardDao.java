package edu.kh.community.board.model.dao;

import static edu.kh.community.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.community.board.model.vo.Board;
import edu.kh.community.board.model.vo.BoardDetail;
import edu.kh.community.board.model.vo.BoardImage;
import edu.kh.community.board.model.vo.Pagination;

public class BoardDao {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public BoardDao() {
		try {
			prop = new Properties();
			String filePath = BoardDao.class.getResource("/edu/kh/community/sql/board-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String selectBoardName(Connection conn, int type) throws Exception{
		String boardName = null;
		try {
			String sql = prop.getProperty("selectBoardName");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardName = rs.getString(1);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardName;
	}
	public int selectListCount(Connection conn, int type) throws Exception{
		int result = -10;
		try {
			String sql = prop.getProperty("selectListCount");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public List<Board> selectBoardList(Connection conn, Pagination pagination, int type) throws Exception{
		List<Board> boardList = new ArrayList<Board>();
		try {
			String sql = prop.getProperty("selectBoardList");
			int start = (pagination.getCurrentPage()-1)*pagination.getLimit()+1;
			int end = start + pagination.getLimit()-1;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberNickName(rs.getString("MEMBER_NICK"));
				board.setCreateDate(rs.getString("CREATE_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setThumbnail(rs.getString("THUMBNAIL"));
				boardList.add(board);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardList;
	}
	public BoardDetail selectBoardDetail(Connection conn, int boardNo) throws Exception{
		BoardDetail detail = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectBoardDetail"));
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				detail = new BoardDetail();
	            detail.setBoardNo(rs.getInt(1));
	            detail.setBoardTitle(rs.getString(2));
	            detail.setBoardContent(rs.getString(3));
	            detail.setCreateDate(rs.getString(4));
	            detail.setUpdateDate(rs.getString(5));
	            detail.setReadCount(rs.getInt(6));
	            detail.setMemberNickname(rs.getString(7));
	            detail.setProfileImage(rs.getString(8));
	            detail.setMemberNo(rs.getInt(9));
	            detail.setBoardName(rs.getString(10));
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return detail;
	}
	
	public List<BoardImage> selectImage(Connection conn, int boardNo) throws Exception{
		List<BoardImage> imageList = new ArrayList<BoardImage>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectImage"));
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardImage imageData = new BoardImage();
				imageData.setImageNo(rs.getInt(1));
	            imageData.setImageRename(rs.getString(2));
	            imageData.setImageOriginal(rs.getString(3));
	            imageData.setImageLevel(rs.getInt(4));
	            imageData.setBoardNo(rs.getInt(5));
				imageList.add(imageData);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return imageList;
	}
	public int nextBoardNo(Connection conn) throws Exception{
		int boardNo = -10; 
		try { 
			stmt = conn.createStatement();
			rs = stmt.executeQuery(prop.getProperty("nextBoardNo"));
			if(rs.next())	boardNo = rs.getInt(1);
		} finally {
			close(rs);
			close(stmt);
		}
		return boardNo;
	}
	public int insertBoard(Connection conn, BoardDetail detail, int boardCode) throws Exception {
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertBoard"));
			pstmt.setInt(1, detail.getBoardNo());
			pstmt.setString(2, detail.getBoardTitle());
			pstmt.setString(3, detail.getBoardContent());
			pstmt.setInt(4, detail.getMemberNo());
			pstmt.setInt(5, boardCode);
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertBoardImage(Connection conn, BoardImage i) throws Exception {
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertImage"));
			pstmt.setString(1, i.getImageRename());
			pstmt.setString(2, i.getImageOriginal());
			pstmt.setInt(3, i.getImageLevel());
			pstmt.setInt(4, i.getBoardNo());
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateBoard(Connection conn, BoardDetail detail)throws Exception{
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updateBoard"));
			pstmt.setString(1, detail.getBoardTitle());
			pstmt.setString(2, detail.getBoardContent());
			pstmt.setInt(3, detail.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateImage(Connection conn, BoardImage img) throws Exception {
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updateImage"));
			pstmt.setString(1, img.getImageRename());
			pstmt.setString(2, img.getImageOriginal());
			pstmt.setInt(3, img.getImageLevel());
			pstmt.setInt(4, img.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int deleteImage(Connection conn, int boardNo,String deleteList) throws Exception{
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("deleteImage") + 
					deleteList+")");
			pstmt.setInt(1, boardNo);
			//??? ????????? ?????????
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int deleteBoard(Connection conn, int boardNo) throws Exception{
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("deleteBoard"));
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int searchListCount(Connection conn, int type, String condition) throws Exception {
		int result = -10;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("searchListCount") 
					+ condition);
			pstmt.setInt(1, type);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	public List<Board> searchBoardList(Connection conn, Pagination pagination,
									int type, String condition) throws Exception{
		List<Board> list = new ArrayList<Board>();
		try {
			int start = (pagination.getCurrentPage()-1)*pagination.getLimit()+1;
			int end = start + pagination.getLimit()-1; 
			
			pstmt = conn.prepareStatement(prop.getProperty("searchBoardList1") + 
					condition + prop.getProperty("searchBoardList2"));
			pstmt.setInt(1, type);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberNickName(rs.getString("MEMBER_NICK"));
				board.setCreateDate(rs.getString("CREATE_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setThumbnail(rs.getString("THUMBNAIL"));
				list.add(board);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
}
