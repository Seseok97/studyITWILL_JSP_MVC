package com.itwillbs.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 컨트롤러: 서블릿 구현
 * Model-View 연결
 *
 */
public class MemberFrontController extends HttpServlet {

	// http://localhost:8088/MVC7/anyWords.me 
	
//	@Override // doProcess() 메소드는 상속받은 클래스에 존재하지 않는 메소드이기 때문에, 오버라이딩을 하면 에러가 발생한다.
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 페이지정보 전달방식에 상관없이 한번에 처리하는 메서드.
		System.out.println("doProcess() 호출!");
		
		// URL: http://localhost:8088/MVC7/anyWords.me 
		// URI: /MVC7/anyWords.me // > 프로토콜, 포트번호 없음
		
		// 3가지 파트의 동작을 구현할 메서드 !!
		/**********************************1. 가상주소 계산 ***************************************/
		// 가상주소 가져오기
		System.out.println("1. 가상주소 계산 - 시작!");
		// 1. URI 가져오기
		String requestURI = request.getRequestURI();
		System.out.println("requestURI: "+requestURI);
		// 2. 프로젝트명 가져오기
		String ctxPath = request.getContextPath();
		System.out.println("ctxPath: "+ctxPath);
		// 3. 가상주소 = URI-프로젝트명 
		String command = requestURI.substring(ctxPath.length());
		System.out.println("command: "+command); // 가상주소명 !!
		
		System.out.println("1. 가상주소 계산 - 끝!");
		
		/**********************************1. 가상주소 계산 ***************************************/
		
		/**********************************2. 가상주소 매핑 ***************************************/
		
		
		/**********************************2. 가상주소 매핑 ***************************************/
		
		/**********************************3. 가상주소 이동 ***************************************/
		
		
		/**********************************3. 가상주소 이동 ***************************************/

	}// doProcess() method end
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doGET() 호출!");
		doProcess(request,response);

	}// doGet() method end

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doPost() 호출!");
		doProcess(request,response);

	}// doPost() method end
	

}// public class end





























