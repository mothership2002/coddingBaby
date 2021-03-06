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
		try {
			String mode = req.getParameter("mode");
			if(mode.equals("update")) {
				int boardNo = Integer.parseInt(req.getParameter("no"));
				BoardDetail detail = new BoardService()
						.selectBoardDeatil(boardNo);
				detail.setBoardContent(detail.getBoardContent().replaceAll("<br>","\n"));
				req.setAttribute("detail", detail);
			}
			String path = "/WEB-INF/views/board/boardWriteForm.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
				int cp = Integer.parseInt(mpReq.getParameter("cp"));
				boardNo = Integer.parseInt(mpReq.getParameter("no"));
				String deleteList = mpReq.getParameter("deleteList");
				detail.setBoardNo(boardNo);
				
				int result = service.updateBoard(imageList,detail,deleteList);
				
				String path = null;
				String message = null;
				if(result>0) {
					path = "detail?type="+boardCode+"&cp="+cp+"&no="+boardNo;
					message = "게시글이 수정 되었습니다.";
				} else {
//					path = "update?mode="+mode+"&type="+boardCode+"&cp="+cp+"&no="+boardNo+"";
					path = req.getHeader("referer");
					message = "게시글 수정이 실패 했습니다."
							+ "\n다시 시도해주세요.";
				}
				session.setAttribute("message", message);
				resp.sendRedirect(path);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
