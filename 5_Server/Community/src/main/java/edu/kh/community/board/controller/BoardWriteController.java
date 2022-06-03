package edu.kh.community.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import edu.kh.community.board.model.service.BoardService;
import edu.kh.community.board.model.vo.BoardDetail;
import edu.kh.community.board.model.vo.BoardImage;
import edu.kh.community.common.MyRenamePolicy;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mode = req.getParameter("mode");
		if(mode.equals("update")) {
			
		}
		String path = "/WEB-INF/views/board/boardWriteForm.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();

			int maxSize = 1024 * 1024 * 20 * 5;
			
			String root = session.getServletContext().getRealPath("/");
			String folderPath = "/resources/images/board/";
			String filePath = root + folderPath;
			String encoding = "UTF-8";
			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());

//			file type의 name속성 값을 얻어와 enumeration 형태로 반환
			Enumeration<String> files = mpReq.getFileNames();
			List<BoardImage> imageList = new ArrayList<BoardImage>();
			
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				String rename = mpReq.getFilesystemName(name);
				String originalName = mpReq.getOriginalFileName(name);
				
				if(rename != null) {
					BoardImage image = new BoardImage();
					image.setImageOriginal(originalName);
					image.setImageRename(folderPath + rename);
					image.setImageLevel(Integer.parseInt(name));
//					image.setBoardNo(boardType);
					imageList.add(image);
				}
			}
			
			String boardTitle = mpReq.getParameter("boardTitle");
			String boardContent = mpReq.getParameter("boardContent");
			int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
			
			int boardCode = Integer.parseInt(mpReq.getParameter("type"));

			BoardDetail detail = new BoardDetail();
			detail.setBoardContent(boardContent);
			detail.setBoardTitle(boardTitle);
			detail.setMemberNo(memberNo);
			
			BoardService service = new BoardService();

			String mode = mpReq.getParameter("mode");
			
			int boardNo = -10;
			if(mode.equals("insert")) {
				boardNo = service.insertBoard(imageList,detail,boardCode);
				String path = null;
				if(boardNo > 0) {
					session.setAttribute("message", "게시글이 등록되었습니다.");
					path = "detail?no="+boardNo+"&type="+boardCode;
				} else {
					session.setAttribute("message", "게시글 등록을 실패");
					path = "write?mode="+mode+"&type="+boardCode;
				}
				resp.sendRedirect(path);
			}
			if(mode.equals("update")) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
