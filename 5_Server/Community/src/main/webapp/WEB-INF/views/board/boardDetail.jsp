<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% 

%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title> </title>
   <link rel="stylesheet" href="${contextPath}/resources/css/boardDetail-style.css">
   <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
   <link rel="stylesheet" href="${contextPath}/resources/css/reply-style.css">
   <script src="https://kit.fontawesome.com/381a5c9f75.js" crossorigin="anonymous"></script>
</head>
<body>
    <main>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
        <section class="board-detail">
            <h1 class="board-title">${detail.boardTitle} <span>- ${detail.boardName }</span></h1>
            <div class="board-header">
                <div class="board-writer">
                <c:if test="${empty detail.profileImage}">
                	<a href=#><img src="${contextPath}/resources/images/user.png" alt="프로필이미지"></a>
                </c:if>
                <c:if test="${!empty detail.profileImage }">
                	<a><img src="${contextPath}${detail.profileImage}" alt="프로필이미지"></a>
                </c:if>
                    <span>${detail.memberNickname }</span>
                </div>

                <div class="board-info">
                    <p><span>작성일</span> ${detail.createDate}</p>
                    <c:if test="${!empty detail.updateDate}">
                    	<p><span>마지막 수정일</span> ${detail.updateDate}</p>
                    </c:if>
                    <p><span>조회수</span> ${detail.readCount}</p>
                </div>
            </div>
            
            <c:if test="${!empty detail.imageList}">
            	<c:if test="${detail.imageList[0].imageLevel==0}">
            		<c:set var="thumbnail" value="${detail.imageList[0]}"></c:set>
	            </c:if>
	            <c:if test="${!empty thumbnail}">
	            	<h5>썸네일</h5>
		            <div class="img-box">
		                <div class="boardImg thumbnail">
		                    <img src="${contextPath}${thumbnail.imageRename}" alt="">
		                    <a href="${contextPath}${thumbnail.imageRename}" download="${thumbnail.imageOriginal }">다운로드</a>
		                </div>
		            </div>
	            </c:if>
	            
	            
	            <c:if test="${empty thumbnail}">
	            	<c:set var="start" value="0"></c:set>
	            </c:if>
	            <c:if test="${!empty thumbnail}">
	            	<c:set var="start" value="1"></c:set>
	            </c:if>
	            <h5>업로드 이미지</h5>
	            <c:if test="${fn:length(detail.imageList) > start}"> 
	           		<div class="img-box">
		            <c:forEach var="i" begin="${start}" end="${fn:length(detail.imageList)-1}">
						<div class="boardImg">
			                <img src="${contextPath}${detail.imageList[i].imageRename}" alt="">
			                <a href="${contextPath}${detail.imageList[i].imageRename}"download=${detail.imageList[i].imageOriginal }>다운로드</a>
			            </div>
		            </c:forEach>
	            	</div>
	            </c:if>
			</c:if> 
            <div class="board-content">
                ${detail.boardContent}
            </div>
            
            <div class="board-btn-area">
            	<c:if test="${sessionScope.loginMember.memberNo == detail.memberNo}">
            	    <button id="updateBtn">수정</button>
                	<button id="removeBtn">삭제</button>
            	</c:if>
                <button id="goToListBtn">목록으로</button>
            </div>
        </section>
		<jsp:include page="/WEB-INF/views/board/reply.jsp"></jsp:include>
    </main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/board/board.js"></script>
	<script>
		const contextPath = "${contextPath}";
		const boardNo = "${detail.boardNo}";
		const loginMember = "${sessionScope.loginMember.memberNo}"
	</script>
	<script src="${contextPath}/resources/js/board/reply.js"></script>
</body>
</html>