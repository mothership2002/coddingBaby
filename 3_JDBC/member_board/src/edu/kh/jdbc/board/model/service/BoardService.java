package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.board.model.dao.Dao;
import edu.kh.jdbc.board.model.vo.Board;
import edu.kh.jdbc.board.model.vo.Reply;

public class BoardService {
	
	private Dao dao = new Dao();

	public List<Board> selectAll() throws Exception{
		Connection conn = getConnection();
		List<Board> selectAll = dao.selectAll(conn);
		close(conn);
		return selectAll;
	}

	public Board selectOne(int boardNo)throws Exception {
		Connection conn = getConnection();
		Board board = dao.selectBoard(conn,boardNo);
		if(board != null) {
			List<Reply> reply = dao.selectReply(conn,boardNo);
			board.setReplyList(reply);
			
			int result = dao.readCount(conn,boardNo);
			if(result == 1 ) {
				commit(conn);
				board.setReadCount(board.getReadCount()+1);
			}
			else 			rollback(conn);
		}

		close(conn);
		return board;
	}

//	public String replyAdd(Member loginMember, String replyContent, int boardNo)throws Exception {
//		Connection conn = getConnection();
//		int result = dao.replyAdd(conn,loginMember,replyContent,boardNo);
//		if(result >0) {
//			commit(conn);
//			close(conn);
//			return "\n댓글이 성공적으로 작성되었습니다.\n";
//		}
//		else {
//			rollback(conn);
//			close(conn);
//			return "\n댓글 작성을 실패하였습니다.\n";
//		}
//	}

//	public String boardUpdate(int boardNo,String boardContent) throws Exception {
//		Connection conn = getConnection();
//		int result = dao.boardUpdate(conn,boardNo,boardContent);
//		close(conn);
//		if(result > 0 ) commit(conn);
//		else			rollback(conn);
//		return null;
//	}

	public String boardDelete(int boardNo) throws Exception{
		Connection conn = getConnection();
		int result = dao.boardDelete(conn,boardNo);
		if(result >0) {
			commit(conn);
			close(conn);
			return "\n 삭제 되었습니다.\n";
		}else {
			rollback(conn);
			close(conn);
			return "\n 삭제를 실패했습니다.\n";
		}
		
		
	}

//	public String replyDelete(int memberNo, int deleteReply)throws Exception {
//		Connection conn = getConnection();
//		int result = dao.replyDelete(conn,memberNo,deleteReply);
//		if(result>0) {
//			commit(conn);
//			close(conn);
//			return "\n삭제되었습니다.";
//		}else {
//			rollback(conn);
//			close(conn);
//			return "\n삭제 실패.";
//		}
//	}

	public int updateBoard(Board board)throws Exception{
		Connection conn = getConnection();
		int result = dao.updateBoard(conn,board);
		if(result>0) commit(conn);
		else 		 rollback(conn);
		close(conn);
		return result;
	}

	public int insertReply(Reply reply)throws Exception {
		Connection conn = getConnection();
		int result = dao.insertReply(conn,reply);
		if(result > 0) commit(conn);
		else 		   rollback(conn);
		close(conn);
		return result;
	}

	public int updateReply(Reply reply) throws Exception {
		Connection conn = getConnection();
		int result = dao.updateReply(conn,reply);
		if(result>0) commit(conn);
		else		 rollback(conn);
		close(conn);
		return result;
	}

	public int deleteReply(int replyNo)throws Exception {
		Connection conn = getConnection();
		int result = dao.deleteReply(conn,replyNo);
		if(result>0) commit(conn);
		else		 rollback(conn);
		close(conn);
		return result;
	}

	public int insertBoard(Board board) throws Exception{
		Connection conn = getConnection();
		int result = dao.insertBoard(conn,board);
		if(result>0) commit(conn);
		else 		 rollback(conn);
		close(conn);
		return result;
	}

	public List<Board> searchBoard(String keyword, int selectNum) throws Exception {
		Connection conn = getConnection();
		List<Board> searchBoard = dao.searchBoard(conn,keyword,selectNum);
		close(conn);
		return searchBoard;
	}

}
