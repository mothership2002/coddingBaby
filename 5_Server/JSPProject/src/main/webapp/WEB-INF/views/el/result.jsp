<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%--Person 클래스 import --%>   
<%@ page import="edu.kh.jsp.model.vo.Person"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet/JSP 내장 객체의 범위(scope)</title>
</head>
<body>
	<!-- 
		EL의 특징
		1. get 이라는 단어를 사용하지 않음
		왜? 표현 언어 == 출력용 언어 == 출력은 얻어와서 밖에 못함
	 -->


		request 범위 message : ${message}
		<br>
		session 범위 sessionValue : ${ sessionValue}
		<br>
		application 범위 appValue : ${appValue }
		<br>
	session 범위 sessionValue : ${ sessionValue}
	<pre>
		EL에서 Paramter 얻어와서 출력하는 방법 
		\${ param.name속성 값 }
	</pre>
	1) JSP 표현식 : 
		<%= request.getParameter("inputName") %> / 
		<%= request.getParameter("inputAge") %> / 
		<%= request.getParameter("inputAddress") %> 
		<%= request.getParameter("inputAddress2") %> 
		
	<br><br>
	
	2) EL(표현 언어) : 
		${ param.inputName } / 
		${ param.inputAge } / 
		${ param.inputAddress } 
		${ param.inputAddress2 } 
		<!--빈칸  -->
		
	<hr>
	
	<h3>request에서 속성(Attribute) 얻어오기</h3>
	
	<pre>
		Servlet에서 추가된 속성을 표현(출력)하려는 경우 
		request에 세팅된 속성(Attribute)의 key값만 작성하여 출력할 수 있다! 
		(import, getAttribute(), 다운캐스팅, 변수 저장 모두 생략)
		
		\${속성key } 
		
		
		\${속성key } 
	</pre>
	
	<%
		String menu = (String)request.getAttribute("menu");
		Person person = (Person)request.getAttribute("person");
	%>
	1) JSP 표현식 : <%= menu %>	
	
	<br> <%=person %>
	
	<br><%= person.getName() %>
	<br><%= person.getAge() %>
	<br><%= person.getAddress() %>
	
	<br><br>
	
	2) EL(표현 언어) : ${menu } 
	
	<br> ${ person }
	<br> ${person.name }
	<br> ${person.age }
	<br> ${person.address }
	
	<hr>
	
	<h3>null 처리 방법</h3>
	
	<pre>
		EL에서 null을 출력해야 되는 경우 ""(빈 문자열)을 출력한다.
		
		+ NullPointerException이 발생하는 코드에서도 ""(빈 문자열)을 출력한다.
		
		+EL은 null인 경우를 확인할 때 empty를 통해서 확인할 수 있다.
	</pre>
		
	<%
		List<String> list = null;
	%>	
	1) JSP 표현식 : <%= list %>
	
	<br> <%= list == null %>
	
	<br><br>
	
	2)EL(표현언어) : ${list }
	
	<br> ${empty list }
	
	<h3 style="color:red">EL의 empty는 null과 비어있는 컬렉션을 비어있는 것으로 취급함</h3>
	
	<%
		list=new ArrayList<String>();
		//list가 ArrayList 객체를 참조 == null 아님
		// 참조하고 있는 ArrayList에 내용은 없음 == 비어있음
	%>
	
	${empty list }
	<!-- 
		EL을 이용해서 컬렉션 요소를 다룰 떄 
		null인지 비어있는지 확인하는 방법이 동일하기 떔누에
		코드 작성 시 이를 잘 구분할 수 있도록 해야한다.
	
	 -->
</body>
</html>