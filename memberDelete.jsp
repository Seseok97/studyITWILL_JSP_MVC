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
	<c:if test="${empty id }"> <!-- id == null -->
		<c:redirect url="./MemberLogin.me" />
	</c:if>

		<h1>memberDelete.jsp</h1>
		<h2> 회원정보 삭제(탈퇴) </h2>
		
		<fieldset>
		    <form action="./MemberDeleteAction.me" method="post">
		      <input type="hidden" name="id" value="${id }">
		      비밀번호 : <input type="password" name="pw"> <br>
		      <input type="submit" value="탈퇴하기">
		    </form>	
		</fieldset>
		
		
		
		

</body>
</html>