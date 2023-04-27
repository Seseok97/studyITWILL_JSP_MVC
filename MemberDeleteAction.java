package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.commons.Action;
import com.itwillbs.commons.ActionForward;
import com.itwillbs.commons.JSForward;
import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

// 회원삭제(탈퇴) 동작
public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : MemberDeleteAction.execute() 호출");
		
		// 세션정보 제어 (로그인)
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id == null) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		} // idCheck if end
		// 정보저장(id,pw)
		String pw = request.getParameter("pw");
		// 회원 탈퇴 > DAO객체 생성 후 동작 > deleteMember()
		MemberDAO dao = new MemberDAO();
		int result = dao.deleteMember(id,pw);
		
		// 삭제결과에 따른 페이지 이동 (js)
		System.out.println(" M : 삭제 결과: "+result);
		// JSForward는 static 메서드이기 때문에, 인스턴스 생성 없이 사용 가능하다.
		if(result == 0) {
			// 비밀번호 오류
			JSForward.alertAndBack(response, "비밀번호 오류!");
			return null; // return
		}else if(result == -1) {
			// 아이디 오류
			JSForward.alertAndBack(response, "회원정보 없음 !");
			return null; // return
		}else if(result > 1) {
			// 쿼리 오류 (영향받은 행이 1개 이상)
			JSForward.alertAndBack(response, "쿼리 오류!");
			return null; // return
		}else { // result == 1
			// 정상
			JSForward.alertAndMove(response, "회원탈퇴 완료!", "./Main.me");
			session.invalidate();
			return null; // return
		}// i-ei-ei-e end
		
		// JS를 통하여 이동을 진행하였기 때문에, ActionForward forward에 null을 전달해야 한다.
	}// execute() method end

}// public class end
