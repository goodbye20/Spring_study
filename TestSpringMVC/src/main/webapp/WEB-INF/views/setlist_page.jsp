<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addlist">
	<p><label for="title">제목 : </label><input type="text" id="title" name="title" /></p>
	<label for="#">내용 : </label>
	<p><textarea id="content" name="content" cols="30" rows="10"></textarea></p>
	<button>전송</button>
	</form>
</body>
</html>