<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title> 제목 </title>
   <link rel="stylesheet" href="${contextPath}/resources/css/boardWriteForm-style.css">
   <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
   <script src="https://kit.fontawesome.com/381a5c9f75.js" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
        <form action="write" method="post" enctype="multipart/form-data"
        class="board-write">
            <h1 class="board-title">
                <input type="text" name="boardTitle" placeholder="제목을 작성해주세요.">
            </h1>
            <h5>썸네일</h5>
            <div class="img-box">
                <div class="board-img thumbnail">
                    <label for="img0">
                        <img class="preview">
                    </label>
                    <input type="file" class="input-img" id="img0" name="0" accept="image/*">
                    <span class="delete-image">&times;</span>
                </div>
            </div>
            <h5>업로드 이미지</h5>
            <div class="img-box">
                <div class="board-img">
                    <label for="img1">
                        <img class="preview">
                    </label>
                    <input type="file" class="input-img" id="img1" name="1" accept="image/*">
                    <span class="delete-image">&times;</span>
                </div>
                <div class="board-img">
                    <label for="img2">
                        <img class="preview">
                    </label>
                    <input type="file" class="input-img" id="img2" name="2" accept="image/*">
                    <span class="delete-image">&times;</span>
                </div>
                <div class="board-img">
                    <label for="img3">
                        <img class="preview">
                    </label>
                    <input type="file" class="input-img" id="img3" name="3" accept="image/*">
                    <span class="delete-image">&times;</span>
                </div>
                <div class="board-img">
                    <label for="img4">
                        <img class="preview">
                    </label>
                    <input type="file" class="input-img" id="img4" name="4" accept="image/*">
                    <span class="delete-image">&times;</span>
                </div>
            </div>
            <div class="board-content">
                <textarea name="boardContent" id=""></textarea>
            </div>
            <div class="board-btn-area">
                <button type="submit" id="writeBtn">등록</button>
                <button type="button" id="goToListBtn">목록으로</button>
            </div>
            <input type="hidden" name="mode" value="${param.mode}">
            <input type="hidden" name="type" value="${param.type}">
        </form>
    </main>
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
        <a href=#top>
            <button id="page-top" class="fa-duotone fa-eject"></button>
        </a>
        <script src="${contextPath}/resources/js/board/board.js"></script>
        <script src="${contextPath}/resources/js/board/boardWriteForm.js"></script>
</body>
</html>