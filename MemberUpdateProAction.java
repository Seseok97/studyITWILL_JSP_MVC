package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.commons.Action;
import com.itwillbs.commons.ActionForward;
import com.itwillbs.commons.JSForward;
import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

// 회원정보 수정 동작 수행
public class MemberUpdateProAction implements Action {
// 클래스 만들때 Interface를 미리 받아올 수 있다 !! 이때 자동으로 구현되어있기때문에 수고가 줄어든다.
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println(" M : MemberUpdateProAction.execute()");
		
		// 세션정보 제어
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id == null) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}// idcheck if end
		
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		// 전달정보 저장
		MemberDTO dto = new MemberDTO();
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.setGender(request.getParameter("gender"));
		dto.setAge(Integer.parseInt(request.getParameter("age")));
		dto.setEmail(request.getParameter("email"));
		
		// DAO > 정보수정 메서드 호출
		MemberDAO dao = new MemberDAO();
		int result = dao.memberUpdate(dto);
		// 수정처리결과에 따른 페이지 이동 (JS이용 > alert를 사용하기 위함!)
		System.out.println(" M : 정보 수정결과 ("+result+")");
		if(result == 0) {
			// 비밀번호 오류
			JSForward.alertAndBack(response, "비밀번호 오류!");
			// static이기 때문에, 인스턴스 생성 없이 사용 가능하다.
			return null; // return
		}else if(result == -1) {
			// 아이디 오류
			JSForward.alertAndBack(response, "아이디 오류!");
			return null; // return
		}else if(result > 1) {
			// 쿼리 오류 (영향받은 행이 1개 이상)
			JSForward.alertAndBack(response, "쿼리 오류!");
			return null; // return
		}else { // result == 1
			// 정상
			JSForward.alertAndMove(response, "Main으로 이동!", "./Main.me");
			return null; // return
		}// i-ei-ei-e end
		
//		forward.setPath("./Main.me");
//		forward.setRedirect(true);
//		return forward;
		
	}// execute() method end
	

} // public class end































