<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%	
	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title> Update My Information</title>
   <link rel="stylesheet" href="${contextPath }/resources/css/main-style.css">
   <link rel="stylesheet" href="${contextPath }/resources/css/myPage-style.css">
   
   <script src="https://kit.fontawesome.com/381a5c9f75.js" crossorigin="anonymous"></script>
</head>
<body id="top">
    <main>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
        
        <section class="myPage-content">
            <jsp:include page="/WEB-INF/views/member/sideMenu.jsp"/>
            
            <section class="myPage-main">
                <h1 class="myPage-title">내 정보</h1>
                <span class="myPage-explanation">회원 정보를 수정 할 수 있습니다.</span>
                <form action="info" method="post" name="profile" onsubmit="return checkValue()">
                    <div class="myPage-row">
                        <label for="">닉네임</label>
                        <input type="text" name="memberNickname"
                        maxlength="10" value="${sessionScope.loginMember.memberNickname}">
                    </div>
                    <div class="myPage-row">
                        <label for="">전화번호</label>
                        <input type="text" name="memberTel" 
                        maxlength="11" value="${sessionScope.loginMember.memberTel}">
                    </div>
                    <c:set var="addr" value="${fn:split(loginMember.memberAddress,',,')}"></c:set>
                    <div class="myPage-row info-title">
                        <span>주소</span>
                    </div>
                    <div class="myPage-row">    
                        <input type="text" name="memberAddress" 
                        maxlength="6" value="${addr[0]}">
                        <button type="button" id="info-address-btn">검색</button>
                    </div>
                    <div class="myPage-row">
                        <input type="text" name="memberAddress" 
                        value="${addr[1]}">
                    </div>
                    <div class="myPage-row">    
                        <input type="text" name="memberAddress" 
                        value="${addr[2]}">
                    </div>
                    <button id="info-update-btn">수정하기</button>
                </form>
            </section>
        </section>
    </main>
    <script src="${contextPath}/resources/js/member/myPage-info.js"></script>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>