package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.commons.Action;
import com.itwillbs.commons.ActionForward;

public class MemberLogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println(" M : MemberLogoutAction.execute()");
		
		// 세션정보 초기화
		HttpSession session = request.getSession();
		session.invalidate();
		
		System.out.println(" M : 세션정보 초기화 완료!");
		
		// 페이지 이동
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('로그아웃 성공!');");
		out.print("location.href='./Main.me'");
		out.print("</script>");
		
		System.out.println(" M : JS를 사용한 페이지 이동!");
		
		return null; 
		// JS로 이동을 실행 한 경우, 컨트롤러에서 다시 이동을 시키는것을
		// 막기 위해 null(티켓없는상황)을 리턴해야한다.
		
//		// forward 활용
//		ActionForward forward = new ActionForward();
//		forward.setPath("./Main.me");
//		forward.setRedirect(true);
//		return forward;
		// 둘중 하나만 사용해야함!
	}// execute() method end
	

}// public class end
