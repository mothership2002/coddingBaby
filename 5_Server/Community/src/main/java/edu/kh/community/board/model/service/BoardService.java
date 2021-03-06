package edu.kh.community.board.model.service;

import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.community.board.model.dao.BoardDao;
import edu.kh.community.board.model.vo.Board;
import edu.kh.community.board.model.vo.BoardDetail;
import edu.kh.community.board.model.vo.BoardImage;
import edu.kh.community.board.model.vo.Pagination;
import edu.kh.community.common.Util;

public class BoardService {
	private BoardDao dao = new BoardDao();

	public Map<String, Object> selectBoardList(int type, int cp) throws Exception {
		Connection conn = getConnection();
		
		String boardName = dao.selectBoardName(conn, type);
		int listCount = dao.selectListCount(conn,type);
		
		Pagination pagination = new Pagination(cp, listCount);
		
		List<Board> boardList = dao.selectBoardList(conn,pagination,type);
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("boardName", boardName);
		result.put("pagination", pagination);
		result.put("boardList", boardList);
		close(conn);
		return result;
	}

	public BoardDetail selectBoardDeatil(int boardNo) throws Exception{
		Connection conn = getConnection();
		
		BoardDetail detail = dao.selectBoardDetail(conn,boardNo);
		if(detail != null) {
			List<BoardImage> imageList = dao.selectImage(conn,boardNo);
			detail.setImageList(imageList);
		}
		close(conn);
		return detail;
	}

	public int insertBoard(List<BoardImage> imageList, BoardDetail detail, int boardCode)throws Exception {
		Connection conn = getConnection();
		int boardNo = dao.nextBoardNo(conn);
		detail.setBoardNo(boardNo);
		detail.setBoardTitle(Util.XSSHandling(detail.getBoardTitle()));
		detail.setBoardContent(Util.XSSHandling(detail.getBoardContent()));
		detail.setBoardContent(Util.newLineHandlling(detail.getBoardContent()));
		int result = dao.insertBoard(conn,detail,boardCode);
		if(result>0) {
			//리스트도 반복으로 보드넘집어넣나?
			for(BoardImage i : imageList) {
				i.setBoardNo(boardNo);
				result = dao.insertBoardImage(conn,i);
				if(result==0) {
					break;
				}
			}
		}
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
			boardNo = 0;
		}
		close(conn);
		return boardNo;
	}

	public int updateBoard(List<BoardImage> imageList, BoardDetail detail, String deleteList) throws Exception {
		Connection conn = getConnection();
		detail.setBoardTitle(Util.XSSHandling(detail.getBoardTitle()));
		detail.setBoardContent(Util.XSSHandling(detail.getBoardContent()));
		detail.setBoardContent(Util.newLineHandlling(detail.getBoardContent()));
		int result = dao.updateBoard(conn,detail);
		
		if(result>0) {
			for(BoardImage img : imageList) {
				img.setBoardNo(detail.getBoardNo());
				result = dao.updateImage(conn,img);
				if(result<1) {
					result = dao.insertBoardImage(conn, img);
				}
			}
			if(!deleteList.equals("")) {
				result = dao.deleteImage(conn,detail.getBoardNo(),deleteList);
			}
		}
		if(result>0)		commit(conn);
		else				rollback(conn);
		close(conn);
		return result;
	}

	public int deleteBoard(int boardNo) throws Exception{
		Connection conn = getConnection();
		int result = dao.deleteBoard(conn,boardNo);
		if(result>0)		commit(conn);
		else				rollback(conn);
		close(conn);
		return result;
	}

	public Map<String, Object> searchBaordList(int type, int cp, String key, String query) throws Exception{
		Connection conn = getConnection();
		String boardName = dao.selectBoardName(conn, type);
		String condition = null;
		
		switch(key){
			case "t": condition = " AND BOARD_TITLE LIKE '%" + query +"%'";
				break;
			case "c": condition = " AND BOARD_CONTENT LIKE '%" + query +"%'";
				break;
			case "tc": condition = " AND (BOARD_TITLE LIKE '%" + query +"%' "
								+  " OR BOARD_CONTENT LIKE '%" + query +"%') ";
				break;
			default :  condition = "AND MEMBER_NICK LIKE '%" + query +"%'";
		}
		
		int listCount = dao.searchListCount(conn,type,condition);
		Pagination pagination = new Pagination(cp, listCount);
		List<Board> BoardList = dao.searchBoardList(conn,pagination,type,condition);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardName", boardName);
		map.put("pagination",pagination);
		map.put("boardList", BoardList);
		close(conn);
		return map;
	}

}
