<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>memberInfo.jsp(MVC)</h1>
	<h2>회원가입시 입력했던 정보 출력.</h2>
	<c:if test="${empty id }"> <!-- sessionScope.id -->
		<c:redirect url="./MemberLogin.me"/>
	</c:if>

<%-- 	${dto }<br> --%>
			

<table border="1">
	<tr>
		<td>아이디</td>
		<td>${dto.id }</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>${dto.pw }</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${dto.name }</td>
	</tr>
	<tr>
		<td>성별</td>
		<td>${dto.gender }</td>
	</tr>
	<tr>
		<td>나이</td>
		<td>${dto.age }</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${dto.email }</td>
	</tr>
	<tr>
		<td>가입날짜</td>
		<td>${dto.regdate }</td>
	</tr>
	
</table>

<h2><a href="./Main.me">메인페이지로</a></h2>





















</body>
</html>