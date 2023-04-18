package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.commons.Action;
import com.itwillbs.commons.ActionForward;
import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

// 패턴 3번
public class MemberInfoAction implements Action {

	//
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		System.out.println(" M : MemberInfoAction.execute()");
		
		// 세션정보 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id == null) {
//			response.sendRedirect("./Main.me"); (X)
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}// idcheck if end
		
		// MemberDAO객체 생성 - 회원정보 조회 메서드 getMember()
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember(id);
		
		// 회원정보 저장 (request영역)
		request.setAttribute("dto", dto);
		// 페이지 forward이동(jsp) + 정보 출력
		// ./member/memberInfo.jsp
		
		
		
		return null;
	}// execute() method end

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// public class end
