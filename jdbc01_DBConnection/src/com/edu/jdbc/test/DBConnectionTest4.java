package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import sql.QueryInfo;
/* Test3의 문제점은
 * 1. 상수값으로 서버 정보를 지정했지만, 더 나은 방식은 완전히 프로그램과 분리시키는 것이다.
 *    다시 말해서 서버의 파편적인 정보를 "Meta Data화" 시키겠다.
 *    ---> 인터페이스 적용
 */
public class DBConnectionTest4 {
	public DBConnectionTest4() throws ClassNotFoundException, SQLException{
		// 로컬 변수로 일단 선언
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER_NAME); // 모듈화, 메타데이터화
			System.out.println("1. 드라이버 로딩 성공...");
			
			// 2. DB Server와 연결
			conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
			System.out.println("2. 디비 서버 연결 성공...");
			
			// 3. PreparedStatement 객체 생성
			ps = conn.prepareStatement(QueryInfo.SELECT_ALL);
			System.out.println("3. PrepareStatement 생성...");
			
			// 4. 바인딩, 쿼리문 실행
			rs = ps.executeQuery();
			while(rs.next()) {
	            System.out.println(rs.getInt("id")+"\t"
	                              +rs.getString("name")+"\t"
	                              +rs.getString("addr"));
	        }
		} finally { // 연 순서 반대로 닫음
			rs.close();
			ps.close();
			conn.close();			
		}
	}
	public static void main(String[] args) throws Exception{
		new DBConnectionTest4();
	}
}