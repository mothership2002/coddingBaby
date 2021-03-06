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
   <title> My Page </title>
   <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
   <link rel="stylesheet" href="${contextPath}/resources/css/myPage-style.css">

   <script src="https://kit.fontawesome.com/381a5c9f75.js" crossorigin="anonymous"></script>
</head>
<body id="top">
    <main>
      <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
      <section class="myPage-content">
          
          <jsp:include page="/WEB-INF/views/member/sideMenu.jsp"></jsp:include>
          <section class="myPage-main">
              <h1 class="myPage-title">프로필</h1>
              <span class="myPage-explanation">프로필 이미지를 변경 할 수 있습니다.</span>
              
              <!-- 
                  enctype : 폼태그가 데이터를 서버로 제출할때,
                  데이터의 인코딩 형식을 지정하는 속성
                  1) application/x-www-form-urlencoded 
                  모든 문자를 서버로 제출하기 전 인코딩
                  2) multipart/form-data
                  모든 데이터가 원본을 유지 (인코딩 X)  
                  무조건 post로 전달      
                -->
                <form action="profile" method="post" name="profile" 
                enctype="multipart/form-data" onsubmit="return profileValidate()">
                <div class="profile-image-area">
                    <c:if test="${empty loginMember.profileImage}">
                        <img src="${contextPath}/resources/images/user.png" alt="" id="profile-image">
                    </c:if>
                    <c:if test="${!empty loginMember.profileImage}">
                        <img src="${contextPath}/${loginMember.profileImage}" alt="" id="profile-image">
                    </c:if>
                    <span id="delete-img">x</span>
                </div>
                <div class="profile-btn-area">
                    <label for="input-image">이미지 선택</label>
                    <input type="file" name="profileImage" id="input-image" accept="image/*">
                    <button>변경하기</button>
                </div>
                <div class="myPage-row">
                    <label for="">이메일</label>
                    <span>${loginMember.memberEmail}</span>
                </div>
                <div class="myPage-row">
                    <label for="">가입일</label>
                    <span>${loginMember.enrollDate}</span>
                </div>
                <div class="myPage-row info-title">
                <input type="hidden" name="delete" id="delete" value="0">
                </form>
            </section>
        </section>
    </main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    <script>
        const contextPath = "${contextPath}"
    </script>   
    <script src="${contextPath}/resources/js/member/mypage-profile.js"></script>
</body>
</html>