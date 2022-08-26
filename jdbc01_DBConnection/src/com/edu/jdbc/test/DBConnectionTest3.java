package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/* Test2의 문제점은
 * 1. 서버 정보가 프로그램에 하드코딩 되어져 있다. ==> public static final 상수값으로 지정하겠다
 * 2. Connection을 열어서 사용한 후, close 해줘야 한다. ==> finally 구문
 */
public class DBConnectionTest3 {
	// 파편적인 데이터를 모듈화한 것 -> Meta Data
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver"; // Meta Data
	public static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // Meta Data
	public static final String USER = "hr"; // Meta Data
	public static final String PASS = "hr"; // Meta Data -> Properties에 ~
	// 메타 데이터화 -> 두 개의 모듈...
	// 상수만으로 인터페이스를 만들기
	
	public DBConnectionTest3() throws ClassNotFoundException, SQLException{
		// 로컬 변수로 일단 선언
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER_NAME);
			System.out.println("1. 드라이버 로딩 성공...");
			
			// 2. DB Server와 연결
			conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("2. 디비 서버 연결 성공...");
			
			// 3. PreparedStatement 객체 생성
			String query = "SELECT id, name, addr FROM custom";
			ps = conn.prepareStatement(query);
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
		new DBConnectionTest3();
	}
}