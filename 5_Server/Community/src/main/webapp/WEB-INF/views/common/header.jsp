<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
    <section class="logo">
    <%--	${pageContext.servletContext.contextPath}
    		<%= requset.getContextPath()%>
    		/Community
    --%>
        <a href="${contextPath}"><img src="${contextPath}/resources/images/logo.jpg" alt="logo" id="home-logo" ></a>
    </section>

    <section>
        <article class="search-area">
            <form action="#" name="search-form">
                <fieldset>
                    <input type="search" id="query" name="query" placeholder="검색어를 입력해주세요." autocomplete="off">
                    <button type="submit" id="search-btn" class="fa-solid fa-magnifying-glass"></button>
                </fieldset>
            </form>
        </article>
    </section>
    
    <section></section>
</header>

<nav>
    <ul>
        <li><a href="${contextPath}/board/list?type=1">공지사항</a></li>
        <li><a href="${contextPath}/board/list?type=2">자유 게시판</a></li>
        <li><a href="${contextPath}/board/list?type=3">질문 게시판</a></li>
        <li><a href="#">FAQ</a></li>
        <li><a href="#">1:1 문의</a></li>
        <li><a href="#">우리반 게시판</a></li>
    </ul>
</nav>
 