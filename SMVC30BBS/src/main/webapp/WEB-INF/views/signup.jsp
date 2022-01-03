<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form:form modelAttribute="memberVO" action="${pageContext.request.contextPath}/member/signupResult">
		<ul>
			<li><label for="id">id : <form:input path="id" name="id"/></label></li>
			<li><label for="password">password : <form:password path="password" name="password"/></label></li>
			<li><label for="name">name : <form:input path="name" name="name"/></label></li>
			<li><label for="gender">성별 : <form:radiobutton path="gender" name="gender" value="M"/>남<form:radiobutton path="gender" name="gender" value="F"/>여</label></li>
			<li><label for="email">email : <form:input path="email" name="email"/></label></li>
			<li><label for="phone">전화번호 : <form:input path="phone" name="phone"/></label></li>
			<li><button>회원가입</button></li>
		</ul>
	</form:form>
</body>
</html>