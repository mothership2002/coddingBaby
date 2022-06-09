package edu.kh.SemiProject.board.model.service;

import static edu.kh.SemiProject.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.SemiProject.board.model.dao.BoardDAO;
import edu.kh.SemiProject.board.model.vo.ShowWindowInfo;

public class BoardService {

	private BoardDAO dao = new BoardDAO();

	public List<ShowWindowInfo> mainBoardSelect(String boardType) throws Exception{
		Connection conn = getConnection();
		List<ShowWindowInfo> showList= dao.mainBoardSelect(conn,boardType);
		close(conn);
		return showList ;
	}
	
}
