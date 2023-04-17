package com.itwillbs.commons;

// 페이지 이동시 필요한 정보를 저장하는 객체.(티켓)
public class ActionForward {
	private String path; // 이동할 페이지 주소(목적지)
	private boolean isRedirect; // 이동할 방식(직행 / 환승)
	// 이동방식 설정 (수업에서만 유효함.)
	// true  > sendRedirect 방식
	// false > forward 방식
	
	public ActionForward() {
		System.out.println("----------------------------------");
		System.out.println("페이지 이동을 위한 티켓 생성.");
		System.out.println("목적지, 이동방식 정보 저장!");
		System.out.println("----------------------------------");
	}// ActionForward() method end, constructor
	
	// getter/setter
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	// getter/setter end

}// public class end
