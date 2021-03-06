<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="announcement" value="${map.announcement}"></c:set>
<c:set var="hot" value="${map.hot}"></c:set>
<c:set var="new" value="${map.nw}"></c:set>
<c:set var="ex" value="${map.exercise}"></c:set>
<c:set var="free" value="${map.free}"></c:set>
<c:set var="met" value="${map.met}"></c:set>
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title> undongin </title>
   <link rel="stylesheet" href="resources/css/main-style.css">
   <script src="https://kit.fontawesome.com/381a5c9f75.js" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <main>
        <div class="announcement">
            <div><a href="${contextPath}/board/list?type=1">알립니다</a></div>
            <c:if test="${!empty announcement}">
				<c:forEach var="a" items="${announcement}">
	           		<div><a href="${contextPath}/board/detail?type=1&no=${a.boardNo}"><span>${a.boardTitle}</span></a><span>${a.likeCount}</span><span>${a.replyCount}</span><span>${a.memberNickname}</span><span>${a.date}</span></div>
	            <!-- 공지 슬라이드 쇼 구현 생각 중  -->
				</c:forEach>
            </c:if>
            <c:if test="${empty announcement}">
            	<div>현재 게시글이 존재하지 않습니다.</div>
            </c:if>
        </div>
        <section class="container">
            <div class="main-content">
                <div class="hot-board">
                									<!-- 타입 관련 생각 -->
                    <div><a href="${contextPath}/board/list?type=5">인기 게시판</a></div>
                    <div>                    
                        <ul>
                        	<c:if test="${!empty hot}">
                        		<c:forEach var="hb" items="hot">
                        							<!-- 링크주소 -->
		                            <li><a href="${contextPath}/board/detail?type=${hb.boardType}&no=${hb.boardNo}"><span>${hb.boardTitle}</span></a><span>${hb.likeCount}</span><span>${hb.replyCount}</span><span>${hb.memberNickname}</span><span>${hb.date}</span></li>
                        		</c:forEach>
                        	</c:if>
                        	<c:if test="${empty hot}">
	                            <div>현재 게시글이 존재하지 않습니다.</div>
                        	</c:if>
                        </ul>
                    </div>
                </div>
                <div class="new-board">
                										<!-- 타입 관련 생각 -->
                    <div><a href="${contextPath}/board/list?type=6">최근 게시글</a></div>
                    <div>                    
                        <ul>
                        	<c:if test="${!empty nw}">
                        		<c:forEach var="nb" items="nw">
                        							<!-- 링크주소 -->
		                            <li><a href="${contextPath}/board/detail?type=${nb.boardType}&no=${nb.boardNo}"><span>${nb.boardTitle}</span></a><span>${nb.likeCount}</span><span>${nb.replyCount}</span><span>${nb.memberNickname}</span><span>${nb.date}</span></li>
                        		</c:forEach>
                        	</c:if>
                        	<c:if test="${empty nw}">
	                            <div>현재 게시글이 존재하지 않습니다.</div>
                        	</c:if>                        
                        </ul>
                    </div>
                </div>
                <div class="exercise-board">
                    <div><a href="${contextPath}/board/list?type=2">운동 게시판</a></div>
                    <div>                    
                        <ul>
                        	<c:if test="${!empty ex}">
                        		<c:forEach var="eb" items="ex">
                        							<!-- 링크주소 -->
		                            <li><a href="${contextPath}/board/detail?type=2&no=${eb.boardNo}"><span>${eb.boardTitle}</span></a><span>${eb.likeCount}</span><span>${eb.replyCount}</span><span>${eb.memberNickname}</span><span>${eb.date}</span></li>
                        		</c:forEach>
                        	</c:if>
                        	<c:if test="${empty ex}">
	                            <div>현재 게시글이 존재하지 않습니다.</div>
                        	</c:if>           
                        </ul>
                    </div>
                </div>
                <div class="free-board">
                    <div><a href="${contextPath}/board/list?type=3">자유 게시판</a></div>
                    <div>                    
                        <ul>
                        	<c:if test="${!empty free}">
                        		<c:forEach var="fb" items="free">
                        							<!-- 링크주소 -->
		                            <li><a href="${contextPath}/board/detail?type=3&no=${fb.boardNo}"><span>${fb.boardTitle}</span></a><span>${fb.likeCount}</span><span>${fb.replyCount}</span><span>${fb.memberNickname}</span><span>${fb.date}</span></li>
                        		</c:forEach>
                        	</c:if>
                        	<c:if test="${empty free}">
	                            <div>현재 게시글이 존재하지 않습니다.</div>
                        	</c:if>           
                        </ul>
                    </div>
                </div>
            </div>
            <div class="sub-content">
                <div class="login-container">
                    <!-- 비 로그인시 -->
                    <c:if test="${empty loginMember}">
                        <form action="user/login" id="submitLogin" method="post" onsubmit="return login()">
                            <div>
                                <img src="resources/images/idIcon.png" alt="idIcon">
                                <input type="text" id="inputID" name="ID" placeholder="아이디">
                            </div>
                            <div>
                                <img src="resources/images/pwIcon.png" alt="pwIcon">
                                <input type="password" id="inputPW" name="PW" placeholder="비밀번호">
                            </div>
                            <button>로그인</button>
                        </form>
                        <div>
                            <a href="user/join">회원가입</a>
                            <a href="user/accountQuery">아이디/비밀번호 찾기</a>
                        </div>
                    </c:if>
                    <!-- 로그인세션 존재시 -->
                    <c:if test="${!empty loginMember}">
                        <div>
                            <div>프로필 이미지</div>
                            <div>닉네임</div>
                            <div>이메일</div>
                            <div>
                                <a href="#">내 쪽지함</a>
                                <a href="#">내 정보</a>
                                <!-- 
                                <a href="#">내가 쓴 글</a>
                                <a href="#">내가 쓴 댓글</a>
                                -->
                            </div>
                        </div>
                    </c:if>
                </div>
                <div class="add-box">광고</div>
                <div class="met-board">
                    <div><a href="${contextPath}/board/list?type=4">정모 게시판</a></div>
                    <div>
                        <ul>
                        	<c:if test="${!empty met}">
                        		<c:forEach var="mb" items="met">
                        							<!-- 링크주소 -->
		                            <li><a href="${contextPath}/board/detail?type=4&no=${mb.boardNo}"><span>${mb.boardTitle}</span></a><span>${mb.likeCount}</span><span>${mb.replyCount}</span><span>${mb.memberNickname}</span><span>${mb.date}</span></li>
                        		</c:forEach>
                        	</c:if>
                        	<c:if test="${empty met}">
	                            <div>현재 게시글이 존재하지 않습니다.</div>
                        	</c:if>           
                        </ul>
                    </div>                    
                </div>
            </div>
        </section>
        <div id="space"></div>
    </main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/main-login.js"></script>
</body>
</html>