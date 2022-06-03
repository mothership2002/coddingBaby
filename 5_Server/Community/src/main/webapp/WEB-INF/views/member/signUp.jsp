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
   <link rel="stylesheet" href="../resources/css/main-style.css">
   <link rel="stylesheet" href="../resources/css/sign-up-style.css">
   <script src="https://kit.fontawesome.com/381a5c9f75.js" crossorigin="anonymous"></script>
</head>
<body id="top">
    <main>

	<jsp:include page="../common/header.jsp"></jsp:include>

        <section class="signUp-content">
            <form action="signUp" method="post" name="signUp-form" onsubmit="return signUpValidate()">
                <label for="memberEmail">
                    <span class="required">*</span> 이메일
                </label>
                <div class="signUp-input-area">
                    <input type="text" name="memberEmail" id="memberEmail"
                    placeholder="아이디(이메일)" maxlength="30" autocomplete="off"
                    required>
                    <button type="button">인증번호 받기</button>
                </div>
                <span class="signUp-message" id="emailMessage">메일을 수신 할 수 있는 이메일 입력</span>
                
                <label for="emailCheck">
                    <span class="required">*</span> 인증번호 입력
                </label>
                    <div class="signUp-input-area">
                        <input type="text" id="emailCheck"
                        placeholder="인증번호 입력" maxlength="6" autocomplete="off">
                        <button type="button">인증번호 확인</button>
                    </div>
                    <span class="signUp-message confirm">받은 메일의 인증번호를 입력</span>

                <label for="memberPassword">
                    <span class="required">*</span> 비밀번호
                </label>
                    <div class="signUp-input-area">
                        <input type="password" id="memberPassword" name="memberPW"
                        placeholder="비밀번호" maxlength="30"></input>
                    </div>
                    
                    <div class="signUp-input-area">
                        <input type="password" id="memberPwConfirm" 
                        placeholder="비밀번호 확인" maxlength="30"></input>
                    </div>
                    <span class="signUp-message" id="pwMessage">대소문자,숫자,특수문자(!,@,#,$,-,_)6~30글자 사이로 작성해주세요.</span>
                
                <label for="memberNickname">
                    <span class="required">*</span> 닉네임
                </label>
                    <div class="signUp-input-area">
                        <input type="text" id="memberNickname" name="memberNickname"
                        placeholder="닉네임" maxlength="10"></input>
                    </div>
                    <span class="signUp-message" id="nicknameMessage">영문/숫자/한글 2~10자 사이로 작성해주세요.</span>
                <label for="memberTel">
                    <span class="required">*</span> 전화번호
                </label>
                <div class="signUp-input-area">
                    <input type="text" id="memberTel" name="memberTel"
                    placeholder="(-없이 숫자만 입력)" maxlength="11"
                    autocomplete="off"></input>
                </div>
                <span class="signUp-message" id="telMessage">전화번호 형식이 올바르지 않습니다.(- 제외)</span>
            
                <label for="memberAddress">
                    주소
                </label>
                <div class="signUp-input-area">
                    <input type="text" id="memberAddress" name="memberAddress"
                    placeholder="우편 번호" maxlength="6"></input>
                    <button type="button">검색</button>
                </div>
                <div class="signUp-input-area">
                    <input type="text" name="memberAddress" placeholder="도로명주소" ></input>
                </div>
                <div class="signUp-input-area">
                    <input type="text"name="memberAddress" placeholder="상세주소">
                </div>
                <button id="signUp-btn" >가입하기</button>
            </form>
        </section>
    </main>
    <jsp:include page="../common/footer.jsp"></jsp:include>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/member/signUp.js"></script>
</body>
</html>