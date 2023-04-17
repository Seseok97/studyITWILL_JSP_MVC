package com.itwillbs.commons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 모든 Action 페이지의 형태를 고정!
//  > 각 페이지의 동작은 다르지만, 리턴되는 값, 형태가 같아진다 !! > 다형성 !
//  > 당장에 인터페이스를 활용하여 다형성을 갖추는것의 장점은 보이지 않는다 !!
//    이후에 설계의 개념에 들어가기 시작하면 장점이 많이 보일것 !!
//		>> 예를들면, 한 작업에 여러명이 투입되는경우 !! 메서드를 뒤죽박죽으로 만들게 됨 ..
//		>> 인터페이스를 통하여 강제성을 부여하여, 메서드의 형태를 통일하고 수정이 필요할때 더 편하게 실행할 수 있다!
public interface Action {
	// 상수, 추상메서드
	/**
	 * execute() 실행할 때 ! > 반드시  request,response가 필요하다.
	 * execute() 실행 결과로 ActionForward(티켓) 생성.
	 */
	public ActionForward execute(HttpServletRequest request,
								 HttpServletResponse response)
								throws Exception;
}// public interface end
