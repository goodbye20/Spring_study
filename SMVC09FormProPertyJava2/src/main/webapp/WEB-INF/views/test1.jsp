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
	<h1>test1</h1>
	<form:form action="#" modelAttribute="dataBean">
		<form:select path="a1">
			<form:option value="data1">항목1</form:option>
			<form:option value="data2">항목2</form:option>
			<form:option value="data3">항목3</form:option>
		</form:select>
		<hr>
		<form:select path="a2">
			<form:options items="${requestScope.dataList1}"/>
		</form:select>
		<hr>
		<form:select path="a3">
			<form:options items="${requestScope.dataList2}"/>
		</form:select>
		<hr>
		<form:select path="a4">
			<form:options items="${requestScope.dataList3}"/>
		</form:select>
		<hr>
		<!-- 무엇을 어디에 맵핑할지 itemLabel itemValue로 키와 벨류값을 각각 지정-->
		<form:select path="a4">
			<form:options items="${requestScope.dataList3}" itemLabel="key" itemValue="value"/>
		</form:select>
		<hr>
		<!-- a5에 data1 data3가 맵핑되어 있기때문에 두개의 선택지가 미리 선택되어나옴 -->
		<form:checkbox path="a5" value="data1"/>항목1
		<form:checkbox path="a5" value="data2"/>항목2
		<form:checkbox path="a5" value="data3"/>항목3
		<hr>
		<!-- 일반 배열[] 형태 불러오기 문제없음 -->
		<form:checkboxes items="${requestScope.dataList1 }" path="a6"/>
		<hr>
		<!-- ArrayList<> 형태 불러오기 역시 문제없음 -->
		<form:checkboxes items="${requestScope.dataList2 }" path="a7"/>
		<hr>
		<!-- 가변적으로 키와 벨류값을 지정하여 출력 -->
		<form:checkboxes items="${requestScope.dataList3 }" path="a8" itemLabel="key" itemValue="value"/>
		<hr>
		<form:radiobutton path="a9" value="data1"/>항목1
		<form:radiobutton path="a9" value="data2"/>항목2
		<form:radiobutton path="a9" value="data3"/>항목3
		<hr>
		<!-- 일반 배열[] 형태 불러오기 문제없음 -->
		<form:radiobuttons path="a10" items="${requestScope.dataList1 }"/>
		<hr>
		<!-- ArrayList<> 형태 불러오기 역시 문제없음 -->
		<form:radiobuttons path="a11" items="${requestScope.dataList2 }"/>
		<hr>
		<form:radiobuttons path="a12" items="${requestScope.dataList3 }" itemLabel="key" itemValue="value"/>
	</form:form>
</body>
</html>