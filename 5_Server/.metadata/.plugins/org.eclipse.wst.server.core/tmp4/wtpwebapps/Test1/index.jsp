<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

</head>

<body>

	<form action="selectUser" method="get">

		<h1>회원 정보 조회(회원 번호 검색)</h1>

		<input type="text" placeholder="회원 번호 입력" name="userNo">

		<button>조회</button>

	</form>

	<script>

		document.getElementsByTagName("button")[0].addEventListener("click",function(e){

			const value = document.getElementsByName("userNo")[0].value

			if(value.trim() ==""){

				alert("공란은 값이 아니다.");

				e.preventDefault();

				return;

			}

              	const regEx = /[0-9]+/;

			if(!regEx.test(value)){

				alert("숫자만 입력해주세요");

				e.preventDefault();

				return;

			}

		})

	</script>

</body>

</html>​