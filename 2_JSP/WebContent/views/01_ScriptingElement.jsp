<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1{color:red;}
</style>
</head>
<body>
	<h1>스크립팅 원소</h1>
	
	<!-- html 주석 : 개발자 도구탭에 노출됨 -->
	<%-- jsp 주석 : 개발자 도구탭에 노출 안됨 --%>
	
	<%
		// 스크립틀릿 : 이안에 일반적인 자바 코드 작성 (변수 선언 및 초기화, 제어문 등등)
		int sum = 0;
		for(int i=1; i<=100; i++){
			sum+=i;
		}
		
		System.out.println("덧셈 끝! 결과 : " + sum);
	%>
	
	<p>
		화면으로 출력하고자 한다면 <br>
		스크립틀릿 이용해서 출력 가능 : <% out.println(sum); %> <br>
		표현식(출력식) 이용해서 출력 가능 : <%= sum %> <!-- out.println(); 으로 감싸져 있다고 생각하면 됨! : 즉, 괄호 안에 들어가므로 세미콜론 불필요함. -->
	</p>
	
	<%
		String[] name = {"문동은","박연진","이사라","최혜정"};
	%>
	
	<h5>배열의 길이 : <%= name.length %></h5>
	<h5>배열에 담긴 값 : <%= String.join("-", name) %></h5>
	
	<h4>반복문을 통해 html 요소 반복적으로 화면에 출력 가능</h4>
	<!-- forEach 문 -->
	<ul>
		<% for(String a:name) { %>
		<li><%= a %></li>
		<% } %>
	</ul>
	
	<%!
		public void test(){
		
	}
	%> <!-- public void test(){} 이와같은 함수는 단순 스크립틀릿으로는 에러발생 !(선언문)이 필요하다. 따라서 위와 같은 선언문 방법은 잘 쓰이지 않고 아래와 같이 자주 쓴다. -->
	
	<% test(); %>
	
</body>
</html>