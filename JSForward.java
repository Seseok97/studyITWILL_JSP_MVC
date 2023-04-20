package com.itwillbs.commons;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class JSForward {
	// 자바 스크립트를 사용, 페이지를 이동하는 동작 수행
	
	// 1. alert 메세지 출력, 페이지 뒤로가기.
	public static void alertAndBack(HttpServletResponse response, String msg) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>"); 
			out.print(" alert('"+msg+"');");
			out.print(" history.back();"); 
			out.print("</script>");		
			out.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}// t-c end
	}// alertAndBack() method end
	
	// 2. alert 메세지 출력, 원하는위치로 이동
	public static void alertAndMove(HttpServletResponse response, String msg, String location) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>"); 
			out.print(" alert('"+msg+"');");
			out.print(" location.href='"+location+"';"); 
			out.print("</script>");		
			out.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}// t-c end
	}// alertAndBack() method end
	

}// public class end
