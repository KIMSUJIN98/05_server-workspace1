package com.kh.controller;

import java.io.IOException;
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
	
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message");
		String pizza = request.getParameter("pizza");
		
		String[] topping = request.getParameterValues("topping");
		String[] side = request.getParameterValues("side");
		
		String payment = request.getParameter("payment");
		
		System.out.println("김수진");
		System.out.println("userName : " + userName);
		System.out.println("phone : " + phone);
		System.out.println("address : " + address);
		System.out.println("message : " + message);
		System.out.println("pizza : " + pizza);
		
		if(topping == null) { // 아무런 선택도 안한 경우
			System.out.println("topping : 없음");
		}else { // 하나라도 선택한 경우
			System.out.println("topping : " + String.join("-", topping));
		}
		
		if(side == null) { // 아무런 선택도 안한 경우
			System.out.println("side : 없음");
		}else { // 하나라도 선택한 경우
			System.out.println("side : " + String.join("-", side));
		}
		
		System.out.println("payment : " + payment);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
