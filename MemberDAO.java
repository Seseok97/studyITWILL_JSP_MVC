package com.itwillbs.member.db;
// DB와 연결되는 모든 동작은 db패키지에 저장한다 !!

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// DB와 연결해서 처리하는 모든 동작 수행
// >> DB를 활용해야하는 모든 동작 > MemberDAO 객체를 생성해야한다!
public class MemberDAO {
	// 공통변수 선언
	private Connection con = null; 			// DB연결정보 저장(관리)
	private PreparedStatement pstmt = null; // SQL쿼리 작성, 실행
	private ResultSet rs = null;			// select결과 데이터를 저장.
	private String sql = "";				// SQL쿼리 구문 저장.
	
	// DB 연결 메서드
	private Connection getCon() throws Exception{
		// Context 객체 생성 > 프로젝트(Context)에대한 정보
		Context initCTX = new InitialContext(); // 초기화된 프로젝트 정보를 initCTX 안에 저장.
		// DB연결정보 불러와서 사용!
		DataSource ds // xml파일에서 타입을 DataSource 로 미리 설정해뒀음!(8번 라인)
			=(DataSource)initCTX.lookup("java:comp/env/jdbc/mvc7");
									// 여기까지는 고정/(여기가 달라진다 !!)
		// DB연결
		con = ds.getConnection(); // DB연결정보를 Connection타입 변수 con에 저장.
		
		System.out.println("DAO: DB연결 성공!"+con);
		return con;
	}// getCon() method end
	
	// 자원 해제
	public void closeDB() {
			try {
				if(rs != null) 	  rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}// t-c end
	}// closeDB() method end
	
	// 회원가입 - memberJoin()
	public void memberJoin(MemberDTO dto) {
		//1,2. DB연결
		try {
			con = getCon();
			sql = "insert into itwill_member (id,pw,name,gender,age,email,regdate)"
					+ " values (?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			// 3. SQL 쿼리작성 & pstmt객체
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setInt(5, dto.getAge());
			pstmt.setString(6, dto.getEmail());
			pstmt.setDate(7, dto.getRegdate());
			// 4. SQL쿼리 실행
			pstmt.executeUpdate();
			System.out.println("DAO: memberJoin() 메서드 정상작동");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}// t-c-f end
		
	}// memberJoin() method end
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// public class end
