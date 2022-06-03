package edu.kh.jdbc.board.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.model.service.BoardService;
import edu.kh.jdbc.board.model.vo.Board;
import edu.kh.jdbc.board.model.vo.Reply;
import edu.kh.jdbc.member.model.vo.Member;

public class BoardView {

	private Scanner sc = new Scanner(System.in);
	private BoardService service = new BoardService();
	
	public void boardMenu(Member loginMember) {
		int menuNum = -10;
		do {
			try {
				System.out.println(" \n [게시판 메뉴 ]\n");
				System.out.println("1. 게시글 목록");
				System.out.println("2. 게시글 상세 조회");
				System.out.println("3. 게시글 작성");
				System.out.println("4. 게시글 검색");
				System.out.println("\n0. 이전 메뉴로 돌아가기");
				System.out.print("\n메뉴 입력 : ");
				menuNum = sc.nextInt();
				sc.nextLine();
				
				switch(menuNum) {
				case 1: selectAll();
					break;
				case 2: selectOne(loginMember);
					break;
				case 3: instertBoard(loginMember.getMemberNo());
					break;
				case 4: searchBoard();
					break;
				case 0: System.out.println("\n이전 메뉴로 돌아갑니다.\n");
					break;
				default : System.out.println("\n메뉴에 해당되는 숫자만 입력해주세요.\n");
				}
				
				
				
			}catch(InputMismatchException e) {
				System.out.println("\n\n숫자에 해당하지 않습니다. 다시 시도해주세요\n");
				sc.nextLine();
			}
			
		}while(menuNum != 0);
		
	}

	private void searchBoard() {
		System.out.println("\n4. 게시글 검색\n");
		System.out.println("검색 조건을 선택해주세요.");
		System.out.println("1. 제목");
		System.out.println("2. 내용");
		System.out.println("3. 내용 + 제목");
		System.out.println("4. 작성자");
		System.out.println("\n0. 이전메뉴로 돌아가기\n");
		int selectNum = -10;
		try {	
			while(selectNum != 0) {
				System.out.print("번호 입력 : ");
				selectNum = sc.nextInt();
				System.out.println();
				sc.nextLine();
				switch(selectNum) {
				case 1 : case 2 : case 3 : case 4 : 
					System.out.print("검색어 : ");
					String keyword = sc.nextLine();
					List<Board> boardList = service.searchBoard(keyword,selectNum);
					if(!boardList.isEmpty()) {
						for(Board e : boardList) {
							System.out.printf("NO:%-3d 제목 : %-7s [%d]  작성자 : %-5s  조회수 : %-3d 생성일 : %10s \n"
									,e.getBoardNo(),e.getBoardTitle(),e.getReplyCount(),e.getMemberName(),e.getReadCount(),e.getCreateDate());
						}
					}else {
						System.out.println("\n검색결과가 없습니다.");
					}
					break;
				case 0 : System.out.println("\n이전 메뉴로 돌아갑니다."); 
					break;
				default : System.out.println("\n해당 숫자에 해당하는 메뉴가 없습니다."); 
				}
			}
		}catch(InputMismatchException e) {
			System.out.println("\n입력 형식이 옳바르지 않습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}

	private void instertBoard(int memberNo) {
		System.out.println("\n3.게시글 작성\n");
		System.out.print("게시글 제목 : ");
		String title = sc.nextLine();
		System.out.println("\n게시글 내용 (종료 시 @exit입력) : ");
		String instertContent = inputContent();
		
		Board board = new Board();
		board.setBoardTitle(title);
		board.setMemberNo(memberNo);
		board.setBoardContent(instertContent);
		
		int result = 0;
		try {
			result = service.insertBoard(board);
			if(result > 0) System.out.println("\n게시글이 작성되었습니다. \n");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void selectAll() {
		System.out.println("\n1. 게시글 목록\n");
		try {
			List<Board> board = new ArrayList<Board>();
			board = service.selectAll();
			if(!board.isEmpty()) {
				for(Board e : board) {
					System.out.printf("NO:%-3d 제목 : %-7s [%d]  작성자 : %-5s  조회수 : %-3d 생성일 : %10s \n"
							,e.getBoardNo(),e.getBoardTitle(),e.getReplyCount(),e.getMemberName(),e.getReadCount(),e.getCreateDate());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	private void selectOne(Member loginMember) {
		System.out.println("\n2. 게시글 상세 조회\n");
		System.out.print("게시글 번호 입력 : ");
		int boardNo = sc.nextInt();
		sc.nextLine();
		
		try {
			int select = -10;
			Board board = service.selectOne(boardNo);
			if(board != null) {
				
				System.out.println("------------------------------------------------------------------------------");
				String a = "\nno : %d  \n제목 : %s   조회수 : %d  \n작성자 : %s   ";
				String c = " 작성일 : %10s \n\n내용 : \n%s\n";
				if(loginMember.getMemberNo()==board.getMemberNo()) {
					System.out.printf(a + "(나) " + c
							,board.getBoardNo(),board.getBoardTitle(),board.getReadCount(),board.getMemberName(),board.getCreateDate(),board.getBoardContent());
				}else {
					System.out.printf(a + c
							,board.getBoardNo(),board.getBoardTitle(),board.getReadCount(),board.getMemberName(),board.getCreateDate(),board.getBoardContent());
				}
				System.out.println("\n---------------------------------------------------------------------------");
				System.out.println("[ 댓글 ]");
				System.out.println("------------------------------------------------------------------------------");
				if(board.getReplyList().isEmpty()) {
					System.out.println("\n아직 댓글이 없습니다.\n");
				}else {
					int i = 1;
					String b = "no : %d \n내용 : \n%s\n작성자 : %s ";
					String d = "  작성일 : %10s ";
					for(Reply e : board.getReplyList()) {
						if(loginMember.getMemberNo() == e.getMemberNo()) {
							System.out.printf(b +"(나)"+ d+ "[내 댓글 번호] %d"
									,i,e.getReplyContent(),e.getReplyName(),e.getCreateDate(),e.getReplyNo());
						}else {
							System.out.printf(b+d
									,i,e.getReplyContent(),e.getReplyName(),e.getCreateDate());
						}
						System.out.println("\n--------------------------------------------------------------------");
						i++;
					}
				}
				do {
					System.out.println();
					System.out.println("\n상세 조회 메뉴\n ");
					System.out.println("1. 댓글 작성");
					System.out.println("2. 내 댓글 수정");
					System.out.println("3. 내 댓글 삭제");
					
					if(loginMember.getMemberNo() == board.getMemberNo()) {
						System.out.println("4. 게시글 수정 ");
						System.out.println("5. 게시글 삭제 ");
					}
					System.out.println("\n0. 이전 메뉴로 돌아가기\n");
				
					System.out.print("메뉴 번호 : ");
					select = sc.nextInt();
					sc.nextLine();
				
					switch(select) {
					case 1 : 
						System.out.println("\n1. 댓글 작성");
//						System.out.print("\n댓글 내용 : ");
//							String replyContent = sc.nextLine();
//							System.out.println(service.replyAdd(loginMember,replyContent,boardNo));
						insertReply(loginMember,boardNo);
						break;
					case 2 : case 3 : 
						String tmp = select == 2 ? "\n2. 댓글 수정\n " : "\n3. 댓글 삭제\n" ;
						System.out.println(tmp);
						System.out.print("댓글 번호 입력 : ");
						int changeReplyNo = sc.nextInt();
						sc.nextLine();
						Reply reply = null;
						for(Reply r : board.getReplyList()) {
							if(r.getReplyNo() == changeReplyNo) {
								reply = r;
								break;
							}
						}
						if(reply == null) {
							System.out.println("\n해당 댓글은 존재하지 않습니다.");
						}else {
							if(reply.getMemberNo()==loginMember.getMemberNo()) {
								
								if(select == 2)		updateReply(changeReplyNo);
								else				deleteReply(changeReplyNo);
								
							}else {
								System.out.println("\n회원님이 작성한 댓글이 아닙니다.");
							}
						}
						
						
						
/*							 System.out.print("\n삭제할 댓글 번호 :");
 *							 int deleteReply = sc.nextInt();
 *							 sc.nextLine();
 *							 while(true) {
 *								System.out.print("\n정말 삭제 하시겠습니까? (Y/N) : ");
 *								char agree = sc.next().toUpperCase().charAt(0);
 *								if(agree == 'Y' || agree == 'N') {
 *									while(true){
 *										String captcha = cap();
 *										System.out.println("\n다음과 같은 문자열을 입력해주세요.");
 *										System.out.println("문자열 : " + captcha);
 *										System.out.print("입력 : ");
 *										String ck = sc.next();
 *										if(ck.equals(captcha)) {
 *											System.out.println("\n확인 되었습니다.");
 *											System.out.println(service.replyDelete(loginMember.getMemberNo(),deleteReply));
 *											break;
 *										}else {
 *											System.out.println("\n일치하지 않습니다.");
 *										}
 *									}
 *									break;
 *								}
 *								else {
 *									System.out.println("\n일치하지 않습니다.");
 *									break;
 *								}
 *							 }
 * */
					
						break;
					case 4 : case 5 : 
						if(loginMember.getMemberNo() == board.getMemberNo()) {
							if(select == 4) {
								updateBoard(boardNo);
							}else {
								System.out.println("\n[ 게시글 삭제 ]\n");
								while(true){
									System.out.print("정말 삭제 하시겠습니까? (Y/N) : ");
									char agree = sc.next().toUpperCase().charAt(0);
									//삭제 의도 확인
									if(agree == 'Y') {
										while(true) {
											// 보안 문자
											String captcha = cap();

											System.out.println("\n다음과 같은 문자열을 입력해주세요 . ");
											System.out.println("문자열 : " + captcha);
											System.out.print("입력 : ");
											String ch = sc.next();
											if(captcha.equals(ch)) {
												System.out.println("\n일치합니다. 삭제를 진행합니다.");
												break;
											}else {
												System.out.println("\n일치하지 않습니다. 다시 입력해주세요.");
											}
										}
										//실행
										System.out.println(service.boardDelete(board.getBoardNo()));
										break;
									}else if(agree == 'N') {
										System.out.println("\n삭제를 취소 하셨습니다.");
										break;
									}else {
										System.out.println("\n옳바른 값을 입력해주세요.");
									}
								}	
							}
						}else {
							System.out.println("\n해당 숫자의 메뉴는 존재하지 않습니다.");
						}
						break;
					case 0 : System.out.println("\n이전 메뉴로 돌아갑니다.");
						break;
					default : System.out.println("\n해당 숫자의 메뉴는 존재하지 않습니다.");
					}
				}while(select != 0);
			}else {
				System.out.println("\n해당 게시글은 존재하지 않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void deleteReply(int replyNo) {
		char ch;
		while(true) {	
			System.out.print("\n정말로 삭제 하시겠습니까? (Y/N) : ");
			ch = sc.next().toUpperCase().charAt(0);
			if(ch=='Y'||ch=='N') {
				break;
			}else {
				System.out.println("\n값이 옳바르지 않습니다.");
			}
		}
		if(ch == 'Y') {
			String captcha = cap();
			System.out.println("\n다음 보안 문자를 입력해주세요");
			System.out.println("문자열 : " + captcha);
			System.out.print("입력 : ");
			String input = sc.next();
			if(input.equals(captcha)) {
				try{
					int result = service.deleteReply(replyNo);
					if(result>0) System.out.println("\n댓글이 삭제되었습니다.");
					else 		 System.out.println("\n댓글 삭제를 실패했습니다.");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("\n보안 문자가 일치하지 않습니다.");
			}
		}else {
			System.out.println("\n댓글 삭제를 취소하셨습니다.");
		}
		
	}

	private void updateReply(int replyNo) {
		System.out.println("\n수정할 내용 입력 (입력 종료 시 @exit)");
		String replyContent = inputContent();
		Reply reply = new Reply();
		reply.setReplyNo(replyNo);
		reply.setReplyContent(replyContent);
		try {
			int result = service.updateReply(reply);
			if(result>0)System.out.println("\n댓글이 수정되었습니다.\n");
			else		System.out.println("\n댓글 수정 실패\n");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private void insertReply(Member loginMember, int boardNo) {
		System.out.println("댓글 내용 입력 (@exit 입력 시 종료)\n");
		String replyContent = inputContent();
		Reply reply = new Reply();
		reply.setMemberNo(loginMember.getMemberNo());
		reply.setBoard_no(boardNo);
		reply.setReplyContent(replyContent);
		try {
			int result = service.insertReply(reply);
			if(result >0) System.out.println("\n댓글이 작성 되었습니다.");
			else  System.out.println("\n댓글이 작성이 실패.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private String cap() {
		String captcha = "";
		for(int i=0;i<6;i++) {
		captcha += (char)(Math.random()*26+'a');
		}
		return captcha;
	}
	
	private void updateBoard(int boardNo) {
		System.out.println("\n[ 게시글 수정 ]\n");
		System.out.print("수정할 제목 : ");
		String boardTitle = sc.nextLine() + " (수정된글)";
		
		System.out.println("\n수정할 내용(입력 종료 시 @exit 입력)\n");
		String boardContent = inputContent();
		
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setBoardContent(boardContent);
		board.setBoardTitle(boardTitle);
		
		try {
			int result = service.updateBoard(board);
			if(result > 0) System.out.println("\n"+boardNo+"번 게시글을 수정 했습니다.");
			else		   System.out.println("\n"+boardNo+"번 게시글글 수정을 실패했습니다.");
		}catch(Exception e){
			System.out.println("\n게시글 실패");
			e.printStackTrace();
		}
	}
	/*
	 * immutable mutable
	 */
	private String inputContent() {
		StringBuffer content = new StringBuffer();
		String input = null;
		while(true) {
			input = sc.nextLine();
			if(input.equals("@exit")) {
				break;
			}else {
				content.append(input);
				content.append("\n");
			}
		}
		return content.toString();
	}
	
}
