<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList, java.util.Date" %> <!-- page 지시어는 원래 하나에 다 쓰지만, import는 예외 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>page 지시어</h1>
	
	<%
		ArrayList<String> list = new ArrayList<>();
		list.add("Servlet"); // 0번 인덱스
		list.add("JSP"); // 1번 인덱스
		
		Date today = new Date();
	%>
	
	<p>
		현재 날짜 및 시간 : <%= today %> <br>
		리스트 길이 : <%= list.size() %> <br>
		0번 인덱스 : <%= list.get(0) %> <br>
		1번 인덱스 : <%= list.get(1) %> <br>
		10번 인덱스 : <%= list.get(10) %> <br>
		
		<!-- 500에러는 자바코드 문제 있을 때 나는 에러 -->
	</p>
</body>
</html>