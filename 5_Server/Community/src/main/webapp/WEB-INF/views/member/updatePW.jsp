<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update PassWord</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title> KH Community </title>
	<link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/myPage-style.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/updatePW-style.css">
	<script src="https://kit.fontawesome.com/381a5c9f75.js" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<main>
		<section class="update-pw">
			<jsp:include page="sideMenu.jsp"></jsp:include>
	
			<section class="submit-area">
				<div>
					<h1>비밀번호 변경</h1>
					<p>현재 비밀번호가 일치하는 경우 새 비밀번호로 변경할 수 있습니다.</p>
				</div>
				<form action="updatePW" method="post" name="udpatePW">
					<div>
						<label for="비번">
							현재 비밀번호
						</label>
						<input name="password" type="password" id="비번">
					</div>
					<div>
						<label for="바비">
							새 비밀번호
						</label>
						<input name="updatePW" type="password" id="바비">
					</div>
					<div>
						<label for="바비책">
							새 비밀번호 확인
						</label>
						<input name="updateChk" type="password" id="바비책">
					</div>
					<button class="update-btn" id="submitBTN">변경하기</button>
				</form>

			</section>
		</section>
	</main>
	<script src="${contextPath}/resources/js/member/updatePW.js"></script>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>