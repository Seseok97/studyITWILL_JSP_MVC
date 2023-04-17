package com.itwillbs.member.action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.commons.Action;
import com.itwillbs.commons.ActionForward;
import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

// 회원가입 처리 (인코딩, 정보저장, 디비연결, 페이지 이동)
public class MemberJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M :(Model)MemberJoinAction.excecute() 실행! ");
		
		// 한글처리 // request는 JSP에서 실행가능한 객체인데, 자바파일에서 사용가능 ?!?!
		// 				>> Controller 파일에서 호출했기때문 !! >> doProcess() 메서드에 저장해 둠.
		//				>> Controller 객체는 Servlet으로써 생성되었기 때문에,
		//				   기본적으로 request, response를 가지고 있다!
		//				    >> (public class가 HttpServlet를 상속하고있음 > Servlet)
		//				>> request, response 는 jsp페이지(index.jsp)에서 받아오는 것임.
		request.setCharacterEncoding("UTF-8");
		
		// MemberDTO 객체 생성
		MemberDTO dto = new MemberDTO();
		// 전달받은 정보 저장 (jsp페이지가 아니기때문에, 액션태그 사용이 불가능하다.)
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.setGender(request.getParameter("gender"));
		dto.setAge(Integer.parseInt(request.getParameter("age")));
		dto.setEmail(request.getParameter("email"));
		dto.setRegdate(new Date(System.currentTimeMillis()));
		
		System.out.println(" M :"+dto);
		
		// MemberDAO 객체 생성
		MemberDAO dao = new MemberDAO();
		// DAO: 회원가입 메서드
		dao.memberJoin(dto);
		
		// 페이지이동
		ActionForward forward = new ActionForward();
		forward.setPath("./MemberLogin.me");
		forward.setRedirect(true); 
		// 이동방식의 차이는 현재 주소와 이동할 주소를 비교하면 된다.
		// 주소가 유지되고 화면이 바뀌느냐 / 주소도 바뀌고 화면도 바뀌느냐 !
		// 						    true   /   false
		System.out.println(" M : 데이터처리 완료! 티켓 가지고 이동");
		
		return forward;
	}// execute() method end
	

}// public class end
































