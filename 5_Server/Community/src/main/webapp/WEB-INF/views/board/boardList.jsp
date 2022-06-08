<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="boardName" value="${map.boardName}"></c:set>
<c:set var="pagination" value="${map.pagination}"></c:set>
<c:set var="boardList" value="${map.boardList}"></c:set>
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title> 제목 </title>
   <link rel="stylesheet" href="${contextPath}/resources/css/boardList-style.css">
   <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
   <script src="https://kit.fontawesome.com/381a5c9f75.js" crossorigin="anonymous"></script>
</head>
<body>
    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        <c:if test="${!empty param.key}">
            <c:set var="sURL">&key=${param.key}&query=${param.query}</c:set>
        </c:if>
        <section class="board-list">
            <h1 class="board-name">${boardName}</h1>
            <c:if test="${!empty param.key}">
                <h3 style="margin-left: 30px; color: rgb(147, 147, 147);">"${param.query}" 검색 결과</h3>
            </c:if>
            <div class="list-wrapper">
                <table class="list-table">
                    <thead>
                        <tr>
                            <th>글번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    <c:choose>
                    	<c:when test="${empty boardList}">
	                    	<tr>
	                            <th colspan="5">게시글이 존재하지 않습니다.</th>
	                        </tr>
                    	</c:when>
                    	<c:otherwise>
                    		<c:forEach var="board" items="${boardList}">
                    			<tr>
		                            <td>${board.boardNo}</td>
		                            <td>
                                        <c:if test="${!empty board.thumbnail}">
                                            <img src="${contextPath}${board.thumbnail}" class="list-thumbnail">
                                        </c:if>
                                        <a href="detail?type=${param.type}&cp=${pagination.currentPage}&no=${board.boardNo}${sURL}">${board.boardTitle}</a>
                                    </td>
		                            <td>
                                        <a href="#">${board.memberNickName}</a>
                                    </td>
		                            <td>${board.createDate}</td>
		                            <td>${board.readCount}</td>
		                        </tr>
                    		</c:forEach>
                    	</c:otherwise>
                    </c:choose>
                    
                    </tbody>
                </table>
            </div>
            <div class="btn-area">
            	<c:if test="${!empty loginMember}">
	                <button id="insertBtn" onclick="location.href='write?mode=insert&type=${param.type}'">글쓰기</button>
            	</c:if>
            </div>
            <div class="pagination-area">
            	<c:set var="url" value="list?type=${param.type}&cp="></c:set>
                <ul class="pagination">
                    <li><a href="${url}1${sURL}">&lt;&lt;</a></li>
                    <li><a href="${url}${pagination.prevPage}${sURL}">&lt;</a></li>

                    <%-- <li><a href="${contextPath}/board/list?type=${param.type}&cp=2">2</a></li> --%>
					<c:forEach var="i" begin="${pagination.startPage}"
								 end="${pagination.endPage}" step="1">
						<c:choose>
							<c:when test="${i==pagination.currentPage}">
								<li><a class="current">${pagination.currentPage}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="${url}${i}${sURL}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
                    <li><a href="${url}${pagination.nextPage}${sURL}">&gt;</a></li>
                    <li><a href="${url}${pagination.maxPage}${sURL}">&gt;&gt;</a></li>
                </ul>
            </div>
            <form action="list" method="get" id="boardSearch">
                <input type="hidden" name="type" value="${param.type}">
                <select name="key">
                    <option value="t">제목</option>
                    <option value="c">내용</option>
                    <option value="tc">제목+내용</option>
                    <option value="w">작성자</option>
                </select>
                <input type="text" name="query" id="search-query" placeholder="검색어를 입력해주세요.">
                <button>검색</button>
            </form>
        </section>
    </main>
    <div class="modal">
        <span id="modal-close">&times;</span>
        <img id="modal-image" src="${contextPath}/resources/images/user.png">
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <script src="${contextPath}/resources/js/board/board.js"></script>
</body>
</html>