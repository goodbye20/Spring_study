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
	<h1>글쓰기 페이지</h1>
	<form:form modelAttribute="BBSVO" action="${pageContext.request.contextPath}/bbs/create_result">
		<ul>
			<li><label for="title">제목 : </label><form:input path="title"/></li>
			<li><form:textarea path="content" cols="50" rows=""/></li>
			<form:hidden path="ownerid" value="${sessionScope.account.id}"/>
			<form:hidden path="ownername" value="${sessionScope.account.name}"/>
			<li>
				<form:button type="submit">전송</form:button>
			</li>
		</ul>
	</form:form>
</body>
</html>