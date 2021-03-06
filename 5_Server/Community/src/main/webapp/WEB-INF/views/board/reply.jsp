<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="reply-area">
    <div class="reply-list-area">
        <ul id="reply-list">
        	<c:forEach var="reply" items="${rList}">
	            <li class="reply-row">
	                <p class="reply-writer">
	                	<c:if test="${empty reply.profileImage}">
	                		<a href="#"><img src="${contextPath}/resources/images/user.png" alt=""></a>
	                	</c:if>
	                    <c:if test="${!empty reply.profileImage}">
	                    	<a href="#"><img src="${contextPath}/${reply.profileImage}" alt=""></a>
	                    </c:if>
	                    <a href="#"><span>${reply.memberNickname}</span></a>
	                    <span class="reply-date">(${reply.createDate})</span>
	                </p>
	                <p class="reply-content">${reply.replyContent}</p>
	                <c:if test="${loginMember.memberNo == reply.memberNo}">
					<div class="reply-btn-area">
						<button onclick="showUpdateReply(${reply.replyNo},this)">수정</button>
						<button onclick="deleteReply(${reply.replyNo})">삭제</button>
					</div>
	                </c:if>
	            </li>
        	</c:forEach>
    </div>
    <div class="reply-write-area">
        <textarea name="" id="replyContent"></textarea>
        <button id="addReply">
            등록
        </button>
    </div>
</div>