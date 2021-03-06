package edu.kh.community.board.model.service;

import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.community.board.model.dao.ReplyDAO;
import edu.kh.community.board.model.vo.Reply;
import edu.kh.community.common.Util;

public class ReplyService {
	private ReplyDAO dao = new ReplyDAO();

	/** 댓글 목록 조회 서비스
	 * @param boardNo
	 * @return rList
	 * @throws Exception
	 */
	public List<Reply> selectReplyList(int boardNo) throws Exception{
		Connection conn = getConnection();
		List<Reply> rList = dao.selectReplyList(conn,boardNo);
		close(conn);
		return rList;
	}

	public int replyInsert(Reply reply)throws Exception {
		Connection conn = getConnection();
//		reply.setReplyContent(reply.getReplyContent().replaceAll("(\n|\r|\r\n|\n\r)", "<br>"));
		reply.setReplyContent(Util.XSSHandling(reply.getReplyContent()));
		reply.setReplyContent(Util.newLineHandlling(reply.getReplyContent()));
		int result = dao.replyInsert(conn,reply);
		if(result>0) commit(conn);
		else		 rollback(conn);
		close(conn);
		return result;
	}

	public int replyDelete(int replyNo)throws Exception {
		Connection conn = getConnection();
		int result = dao.replyDelete(conn, replyNo);
		if(result>0)	commit(conn);
		else			rollback(conn);
		close(conn);
		return result;
	}

	public int replyUpdate(int replyNo, String replyContent) throws Exception{
		Connection conn = getConnection();
		replyContent = Util.XSSHandling(replyContent);
		replyContent = Util.newLineHandlling(replyContent);
		int result = dao.updateReply(conn,replyNo,replyContent);
		if(result>0)	commit(conn);
		else			rollback(conn);
		close(conn);
		return result;
	}
	
	
}
