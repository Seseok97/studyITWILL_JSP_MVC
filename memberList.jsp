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
	<c:if test="${empty id || !id.equals('admin') }"> <!-- id == null -->
		<c:redirect url="./MemberLogin.me" />
	</c:if>
		<h1>memberList.jsp</h1>
		<h2> 회원정보 목록페이지 (관리자용)</h2>
		<table border="1">
			<tr>
				<th>id</th>
				<th>pw</th>
				<th>name</th>
				<th>gender</th>
				<th>age</th>
				<th>email</th>
				<th>regdate</th>
			</tr>
			<c:forEach var="dto" items="${memberList }">
				<tr>
					<td>${dto.id }</td>
					<td>${dto.pw }</td>
					<td>${dto.name }</td>
					<td>${dto.gender }</td>
					<td>${dto.age }</td>
					<td>${dto.email }</td>
					<td>${dto.regdate }</td>
				</tr>
			</c:forEach>
		</table>
		
		<h2><a href="./Main.me">메인으로</a></h2>

		
		
		
		
		
		
</body>
</html>




























