package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/* JDBC 4단계
 * 1. 클라이언트 메모리에 드라이버를 로딩
 *    이때 드라이버 정보의 압축파일(~~.ajr)이 디폴트 클래스 패스로 잡혀져 있어야 한다.
 *    ext 디렉토리 기억!!
 *    Class.forName("드라이버이름");
 *    
 * 2. DB Server와 연결
 *	- 인터페이스 (1) 추상 메소드들의 집합 -> 추상적인 기능
 *  		 (2) field가 없다. but, 상수는 존재
 *    Connection conn = DriverManager.getConnection(url, "hr", "hr");
 *  
 *  3. PreparedStatement 객체를 생성
 *     PreparedStatement ps = conn.prepareStatement(sql);
 *     
 *  4. Query문 실행
 *	   ResultSet rs = ps.executeQuery()
 *	   int row = st.executeUpdate()
 */
public class DBConnectionTest2 {
	public DBConnectionTest2() {
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 드라이버 로딩 성공...");
			
			// 2. DB Server와 연결
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; 
			Connection conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("2. 디비 서버 연결 성공...");
			
			// 3. PreparedStatement 객체 생성
			String query = "SELECT id, name, addr FROM custom";
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("3. PrepareStatement 생성...");
			
			// 4. 바인딩, 쿼리문 실행
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
	            System.out.println(rs.getInt("id")+"\t"
	                              +rs.getString("name")+"\t"
	                              +rs.getString("addr"));
	        }
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패...");
		} catch (SQLException e) {
			System.out.println("디비 서버 연결 실패...");
		}
	}
	public static void main(String[] args) {
		new DBConnectionTest2();
	}
}