<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)request.getAttribute("name"); // request.getAttribute("키") : Object(그에 해당하는 벨류값) // 다운캐스팅. 강제형변환. 오브젝트는 모든 것의 부모.
	String phone = (String)request.getAttribute("phone");
	String address = (String)request.getAttribute("address");
	String message = (String)request.getAttribute("message");
	String pizza = (String)request.getAttribute("pizza");
	String[] toppings = (String[])request.getAttribute("toppings");
	String[] sides = (String[])request.getAttribute("sides");
	String payment = (String)request.getAttribute("payment");
	int price = (int)request.getAttribute("price");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>피자 결제 페이지</h1>

    <h2>주문내역</h2>

    <!-- 처음에는 값을 xxx로 두고! -->
    <h4>[ 주문자 정보 ]</h4>
    <ul>
        <li>성함 : <%= name %></li>
        <li>전화번호 : <%= phone %></li>
        <li>주소 : <%= address %></li>
        <% if(message.equals("")) { %>
            <li>요청사항 : 작성안함</li> <!-- case1 -->
		<% }else { %>
            <li>요청사항 : <%= message %> </li> <!-- case2 -->
        <% } %>
    </ul>

    <h4>[ 주문 정보 ]</h4>
    <ul>
        <li>피자 : <%= pizza %> </li>
		<% if(toppings == null) { %>
            <li>토핑 : 선택안함</li> <!-- case1 -->
        <% }else { %>
            <li>토핑 : <%= String.join(",", toppings) %></li> <!-- case2 -->
        <% } %>

		<% if(sides == null) { %>
            <li>사이드 : 선택안함</li> <!-- case1 -->
        <% }else { %>
            <li>사이드 : <%= String.join(",", sides) %></li> <!-- case2 -->
		<% } %>
		
        <li>결제방식 : <%= payment %></li>

    </ul>

    <hr>

    <h3>위와 같이 주문하셨습니다.</h3>
    <h2>총 가격 : <%= price %></h2>

</body>
</html>