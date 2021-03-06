<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	
	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title> KH Community </title>
   <link rel="stylesheet" href="resources/css/main-style.css">
   <script src="https://kit.fontawesome.com/381a5c9f75.js" crossorigin="anonymous"></script>
</head>
<body id="top">
    <main>
        <!-- 외부 요청 주소가 아닌 내부 접근 경로 -->
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        
        <section class="main-content">
            <section class="content-1">
				<h3>회원 정보 조회</h3>
				<p>이메일을 입력 받아 일치하는 회원 정보 출력</p>
				이메일 : <input type="text" name="" id="in1">
				<button id="select1">조회하기</button>
				<div id="result1" style="height: 150px;">
				</div>
				<hr>
				<h3>회원 목록 조회</h3>
				<p>일정 시간 마다 비동기 회원 목록 조회</p>
				<table border="1">
					<thead>
						<tr>
							<th>회원 번호</th>
							<th>이메일</th>
							<th>닉네임</th>
						</tr>
					</thead>
					<tbody id="memberList">
					</tbody>
				</table>
            </section>
            
            <section class="content-2">
				<c:choose>
					<c:when test="${empty sessionScope.loginMember}">
		                <!-- <form action="/Community/member/login" name="login-form"> -->
		                <form action="member/login" name="login-form" method="post" onsubmit="return loginValidate()">
		                    <fieldset id="id-pw-area">
		                        <section>
		                            <input type="email" name="inputEmail" placeholder="아이디 (이메일)" value="${cookie.memberEmail.value}">
		                            <input type="password" name="inputPW" placeholder="비밀번호">
		                        </section>
		                        <section>
		                            <button>로그인</button>
		                        </section>
		                    </fieldset>
		                    <c:if test="${!empty cookie.memberEmail.value}">
								<c:set var="chk" value="checked"></c:set>
		                    </c:if>
		                    <label for="check">
		                        <input type="checkbox" id="check" name="saveId" ${chk}>아이디 저장
		                    </label>		                    
		                    <article id="signup-find-area">
		                    <!-- 외부로부터 접속을 차단한 경로 -->
		                        <a href="member/signUp">회원가입</a><span> | </span><a href="#">ID/PW 찾기</a>
		                    </article>
		               	</form>
	               	</c:when>
	               	<c:otherwise>
	               		<article class="login-area">
	               		
							<c:if test="${empty loginMember.profileImage }">
		               			<a href="${contextPath}/member/myPage/profile" >
		               				<img alt="profile-img" src="${contextPath}/resources/images/user.png" id="member-profile">
		               			</a>
							</c:if>	               		
							<c:if test="${!empty loginMember.profileImage }">
		               			<a href="${contextPath}/member/myPage/profile" >
		               				<img alt="profile-img" src="${contextPath}/${loginMember.profileImage}" id="member-profile">
		               			</a>
							</c:if>
							
							<div class="my-info">
								<div>
									<a href="${contextPath }/member/myPage/info" id="nickname">${sessionScope.loginMember.memberNickname} 님</a>
									<a href="member/logout" id="logout-btn">로그아웃</a>
								</div>
								<p>
									${sessionScope.loginMember.memberEmail}
								</p>
							</div>
	               		</article>
	               	</c:otherwise>
				</c:choose>
            </section>
        </section>
    </main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/main.js"></script>
</body>
</html>