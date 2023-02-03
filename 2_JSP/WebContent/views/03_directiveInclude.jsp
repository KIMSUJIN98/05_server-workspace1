<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>include 지시어</h1> <!-- 복붙의 개념이라 해당 jsp(01_ScriptingElement)의 스타일 속성이 적용되버림. -->
	
	<div style="border:1px solid black;">
	<%@ include file="01_ScriptingElement.jsp" %> <!-- 01_ScriptingElement.jsp를 가져옴 -->
	</div>
	
	포함한 jsp 상에 선언되어 있는 변수를 가져다 사용 <br>
	1부터 100까지의 총 합계 : <%= sum %> <!-- 복붙의 개념이라 해당 jsp(01_ScriptingElement)의 변수도 사용가능함. -->
	
</body>
</html>