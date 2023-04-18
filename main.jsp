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
	<h1>main.jsp(MVC)</h1>
	<br>
<%-- 	<c:set var="id" value="${sessionScope.id }"/> --%>
	로그인 아이디(JSTL): <c:out value="${id }"/><br>

	<!-- empty 참조변수 : 객체(참조변수)가 null, 혹은 사이즈가 0인 경우 -->
	<c:if test="${empty id }">
	 <c:redirect url="./MemberLogin.me" />
	</c:if>
	
	
	<br>
<!-- 로그아웃    -->
	<input type="button" value="Log Out" onclick="location.href='./MemberLogoutAction.me'">
	
	<hr>
	
	<h3><a href="./MemberInfo.me"> 회원정보 조회</a></h3>
	<h3><a href="MemberUpdate.jsp"> 회원정보 수정</a></h3>
	<h3><a href="MemberDelete.jsp"> 회원정보 삭제</a></h3>
	
	<!-- 관리자메뉴 -->
	<c:if test="${!empty sessionScope.id && id.equals('admin')}">
	<!-- EL표현식은 저장된 변수의 타입을 그대로 들고온다! -->
		<hr>
	 	<h2>관리자 전용메뉴</h2>
		<h3><a href="#">회원정보 목록</a></h3>
	</c:if>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>