<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 수정</h1>
	<form:form modelAttribute="BBSVO" action="${pageContext.request.contextPath}/bbs/modify_result">
		<ul>
			<li><label for="title">제목 : </label><form:input path="title"/></li>
			<li><form:textarea path="content" cols="50" rows="10"/></li>
			<form:hidden path="num"/>
			<li>
				<form:button type="submit">수정</form:button>
			</li>
		</ul>
	</form:form>
</body>
</html>