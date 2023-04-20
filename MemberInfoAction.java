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
		request.setAttribute("dto", dto); // 나중에는 .setAttribute("dto", dao.getMember(id));로 작성할거
																			// > 얘가 dto를 리턴하기 때문 !!
//		session.setAttribute("dto", dto); session: 서버에 정보 저장해둠 <---> request : 페이지끼리 정보전달
		// > 얘로 하면 안됨 ? > 개발자 입장에서 편하긴 함. 단, 보안취약점이 발생하고,
		// 						session이 사용불가능한 페이지가 있는 경우가 있어서 안쓴다.
		
		// 페이지 forward이동(jsp) + 정보 출력
		// ./member/memberInfo.jsp
		forward.setPath("./member/memberInfo.jsp");// 회원정보조회 페이지
		forward.setRedirect(false); // .jsp로 이동할때는 주소가 드러나지 않는것이 좋기때문에 포워딩 선택
									// request 영역을 사용하여 정보를 전달하는 경우, 포워딩밖에 못쓴다 !!!
									// 그래서 setRedirect() 자동완성하면 알아서 false 박아주는 듯!
		System.out.println(" M : 정보조회 저장, 처리 끝!!");
		
		
		
		return forward; // ???? 맞나이거
	}// execute() method end

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// public class end
