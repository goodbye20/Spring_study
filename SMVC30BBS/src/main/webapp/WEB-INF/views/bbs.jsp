<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
<style type="text/css">
	table,tr,td {
		border-collapse: collapse;
		border : 1px solid black;
	}
	
	table {
		width: 99%;
	}
</style>
</head>
<body>
	<h1>자유게시판</h1>
	<table>
		<thead>
			<tr>
				<th>순번</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.num}</td>
					<td><a href="${pageContext.request.contextPath}/bbs/detail?num=${item.num}">${item.title}</a></td>
					<td>${item.ownername}</td>
					<td>${item.createdate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr>
	
	<hr>
	<button id="create-btn">추가</button>
	<script type="text/javascript">
		$(function(){
			$("#create-btn").click(function(){
				location.href = "${pageContext.request.contextPath}/bbs/create";
			});	
		});
	</script>
</body>
</html>