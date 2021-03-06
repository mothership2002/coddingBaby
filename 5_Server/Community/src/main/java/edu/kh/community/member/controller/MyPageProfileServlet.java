package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import edu.kh.community.common.MyRenamePolicy;
import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/member/myPage/profile")
public class MyPageProfileServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/myPage-profile.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//multipartRequest 
			//1. 업로드 되는 파일 크기 전체 지정
			int maxSize = 1024 * 1024 * 20 ;
			
			//2. 파일 경로 지정 -> 절대경로
			
			//2-1 서버 옵션 확인
			
			//servers - 서버 설정 선택 - overview - server options
			//- serve modules without publishing
			
			//2-2 memberProfile 폴더 경로
			HttpSession session = req.getSession();
			String root = session.getServletContext().getRealPath("/");
			String folderPath = "resources/images/memberProfile/";
			String filePath = root + folderPath;
			
			//3. 저장되는 파일의 파일명 변경 규칙
			//MyRenamePolicy
			
			//4. 파일 이외 파라미터 처리
			String encoding = "UTF-8";
			
			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());
			
			Member loginMember = (Member)session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();
			String profileImage = folderPath + mpReq.getFilesystemName("profileImage");
    //		(주의) mutipart/form-data 리퀘스트로 파라미터 못 얻어옴 
			int delete = Integer.parseInt(mpReq.getParameter("delete"));
			if(delete == 1) {
				profileImage = null;
			}
	//		mpReq.getOriginalFileName("profileImage")
	//		mpReq.getFilesystemName("profileImage");
			MemberService service = new MemberService();
			int result = service.updateProfileImage(memberNo,profileImage);
			if(result>0) {
				session.setAttribute("message", "프로필 이미지가 변경되었습니다.");
				loginMember.setProfileImage(profileImage);
			} else {
				session.setAttribute("message", "프로필 이미지가 변경되지 않았습니다.\n다시 시도 해주세요.");
			}
			resp.sendRedirect("profile");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
