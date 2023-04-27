package com.itwillbs.member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.commons.Action;
import com.itwillbs.commons.ActionForward;
import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

// 회원정보 목록 출력 동작(관리자 메뉴)
public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : MemberListAction.execute()");
		
		// 세션정보 제어 (관리자)
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		ActionForward forward = new ActionForward();
		if(id == null || !id.equals("admin")) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}// idCheck if end
		
		// 회원정보 목록 > DAO, getMemberList()
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		List<MemberDTO> memberList = dao.getMemberList();
		System.out.println("회원수: "+memberList.size()+"명");
		// request영역에 저장
		request.setAttribute("memberList", memberList);
		
		// 연결된 view에 출력(./member/memberList.jsp)
		forward.setPath("./member/memberList.jsp");
		forward.setRedirect(false);
		return forward;
	}// execute() method end

}// public class end
