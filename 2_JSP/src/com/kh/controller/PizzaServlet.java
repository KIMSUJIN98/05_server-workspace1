package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaServlet
 */
@WebServlet("/confirmPizza.do")
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("이거 잘 되나???");
		// 1) 전달값 중에 한글이 있을 경우 인코딩 처리 (post 방식일 때만)
		// request.setCharacterEncoding("UTF-8"); (post 방식일 때만 필수, get 방식은 선택)
		
		// 2) 요청시 전달값 뽑기 및 데이터 가공처리(파싱 같은거) => 변수 및 객체 기록
		// request.getParameter("키값") : "벨류값" (String)
		// request.getParameterValues("키값") : ["벨류값", "벨류값",..] (String[])
		// => 만일 키 값이 존재하지 않을 경우 null 반환
		
		// 과제 : 요청시 전달값들 다 뽑아서 변수에 기록해놓기(변수명 임의로) + 콘솔출력
	
		String name = request.getParameter("userName"); // "차은우" 						// 앞단에서 required가 걸려있으므로 "" 빈문자열이 오는 경우가 없기에 고려하지 않아도 됨.
		String phone = request.getParameter("phone"); // "01011112222" 					// int 형으로 받으면 1011112222로 앞에 0이 생략되기에 String 형태로!
		String address = request.getParameter("address"); // "서울시 어딘가" 				// 앞단에서 required가 걸려있으므로 "" 빈문자열이 오는 경우가 없기에 고려하지 않아도 됨.
		String message = request.getParameter("message"); // "빨리와" | "" 				// 빈문자열이 올 수 있음.
		
		String pizza = request.getParameter("pizza"); // "콤비네이션피자" | "포테이토피자" 							// 앞단에서 기본적으로 "콤비네이션피자"가 선택되어있으므로 빈문자열이 오는 경우가 없다.
		String[] toppings = request.getParameterValues("topping"); // ["고구마무스","치즈바이트",..] | null 		// null일 경우를 고려해야함.
		String[] sides = request.getParameterValues("side"); // ["핫소스","피클",..] | null 					// null일 경우 고려해야함.
		String payment = request.getParameter("payment"); // "card", "cash" 								// 앞단에서 기본적으로 card가 checked 되어있고, 라디오버튼이므로 null값 들어올 일이 없다.
		
		System.out.println("김수진");
		System.out.println("userName : " + name);
		System.out.println("phone : " + phone);
		System.out.println("address : " + address);
		
		if(message.equals("")) { // 빈문자열이 넘어오는 경우 존재함.
			System.out.println("요청사항이 없습니다.");
		}else {
			System.out.println("message : " + message);			
		}
		
		System.out.println("pizza : " + pizza);
		
		if(toppings == null) { // 아무런 선택도 안한 경우
			System.out.println("topping : 없음");
		}else { // 하나라도 선택한 경우
			System.out.println("topping : " + String.join("-", toppings));
		}
		
		if(sides == null) { // 아무런 선택도 안한 경우
			System.out.println("side : 없음");
		}else { // 하나라도 선택한 경우
			System.out.println("side : " + String.join("-", sides));
		}
		
		System.out.println("payment : " + payment);
		
		
		
		
		// 3) 요청처리 (db에 sql문 실행하러 > Service > Dao)
		
		int price = 0; // 나중에 총액을 저장할 변수
		
		switch(pizza) {
		case "콤비네이션피자" : price += 5000; break;
		case "치즈피자" : price += 6000; break;
		case "포테이토피자" :
		case "고구마피자" : price += 7000; break;
		case "불고기피자" : price += 8000; break;
		}
		
		if(toppings != null) { // 토핑이 null이 아닐때만 돌리기 				// null에 접근하면 NullPointerException 발생하기 때문!
			for(int i=0; i<toppings.length; i++) {
				switch(toppings[i]) {
				case "고구마무스" :
				case "콘크림무스" : price += 1500; break;
				case "파인애플토핑" :
				case "치즈토핑" : price += 2000; break;
				case "치즈바이트" :
				case "치즈크러스트" : price += 3000; break;
				}
			}
		}
		
		if(sides != null) { // 사이드가 null이 아닐때만 돌리기
			for(int i=0; i<sides.length; i++) {
				switch(sides[i]) {
				case "콜라" :
				case "사이다" : price += 2000; break;
				case "핫소스" :
				case "갈릭소스" : price += 300; break;
				case "피클" :
				case "파마산치즈가루" : price += 500; break;
				}
			}
		}
		
		// 4) 요청 처리 후 사용자가 보게될 응답페이지 (결제페이지) 만들기
		//	  응답페이지(jsp)를 선택해서 포워딩
		//	  단, 응답페이지에서 필요한 데이터가 있다면 담아서 포워딩 할 것!
		// 	  > request의 attribute 영역에 담기
		
		request.setAttribute("name", name); // "name"이라는 키값으로 name의 값을 넣음
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("message", message);
		request.setAttribute("pizza", pizza);
		request.setAttribute("toppings", toppings);
		request.setAttribute("sides", sides);
		request.setAttribute("payment", payment);
		request.setAttribute("price", price);
		
		// 응답할 뷰 (jsp) 선택
		RequestDispatcher view = request.getRequestDispatcher("views/pizza/pizzaPayment.jsp");
		// 선택된 뷰가 사용자에게 보여지도록 포워딩
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
