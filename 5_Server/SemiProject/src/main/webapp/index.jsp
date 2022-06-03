<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title> index </title>
   <link rel="stylesheet" href="resources/css/main-style.css">
   <script src="https://kit.fontawesome.com/381a5c9f75.js" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <main>
        <div class="announcement">
            <div><a href="#">알립니다</a></div>
            <div><a href=""><span>공지 내용이 어떻게 보일까</span></a></div>
        </div>
        <section class="container">
            <div class="main-content">
                <div class="hot-board">
                    <div><a href="">인기 게시판</a></div>
                    <div>                    
                        <ul>
                            <li><a href=""><span>hot1</span></a></li>
                            <li><a href=""><span>hot2</span></a></li>
                            <li><a href=""><span>hot3</span></a></li>
                            <li><a href=""><span>hot4</span></a></li>
                            <li><a href=""><span>hot5</span></a></li>
                            <li><a href=""><span>hot6</span></a></li>
                            <li><a href=""><span>hot7</span></a></li>
                        </ul>
                    </div>
                </div>
                <div class="new-board">
                    <div><a href="">최근 게시글</a></div>
                    <div>                    
                        <ul>
                            <li><a href=""><span>new1</span></a></li>
                            <li><a href=""><span>new2</span></a></li>
                            <li><a href=""><span>new3</span></a></li>
                            <li><a href=""><span>new4</span></a></li>
                            <li><a href=""><span>new5</span></a></li>
                            <li><a href=""><span>new6</span></a></li>
                            <li><a href=""><span>new7</span></a></li>
                        </ul>
                    </div>
                </div>
                <div class="exercise-board">
                    <div><a href="">운동 게시판</a></div>
                    <div>                    
                        <ul>
                            <li><a href=""><span>exercies1</span></a></li>
                            <li><a href=""><span>exercies2</span></a></li>
                            <li><a href=""><span>exercies3</span></a></li>
                            <li><a href=""><span>exercies4</span></a></li>
                            <li><a href=""><span>exercies5</span></a></li>
                            <li><a href=""><span>exercies6</span></a></li>
                            <li><a href=""><span>exercies7</span></a></li>
                        </ul>
                    </div>
                </div>
                <div class="free-board">
                    <div><a href="">자유 게시판</a></div>
                    <div>                    
                        <ul>
                            <li><a href=""><span>free1</span></a></li>
                            <li><a href=""><span>free2</span></a></li>
                            <li><a href=""><span>free3</span></a></li>
                            <li><a href=""><span>free4</span></a></li>
                            <li><a href=""><span>free5</span></a></li>
                            <li><a href=""><span>free6</span></a></li>
                            <li><a href=""><span>free7</span></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="sub-content">
                <div class="login-container">
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
                    </c:if>
                    <c:if test="${!empty loginMember}">
                        
                    </c:if>
                    <div>
                        <a href="user/join">회원가입</a>
                        <a href="user/accountQuery">아이디/비밀번호 찾기</a>
                    </div>
                </div>
                <div class="add-box">광고</div>
                <div class="met-board">
                    <div><a href="">정모 게시판</a></div>
                    <div>
                        <ul>
                            <li><a href=""><span>met5</span></a></li>
                            <li><a href=""><span>met5</span></a></li>
                            <li><a href=""><span>met5</span></a></li>
                            <li><a href=""><span>met5</span></a></li>
                            <li><a href=""><span>met5</span></a></li>
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