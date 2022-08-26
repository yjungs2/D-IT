package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import sql.QueryInfo;

public class CustomerJDBCTest {
	public CustomerJDBCTest() throws ClassNotFoundException, SQLException{
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
			
			// INSERT
			// 3. PreparedStatement 객체 생성
			ps = conn.prepareStatement(QueryInfo.INSERT_CM);
			System.out.println("3. PrepareStatement 생성...");
			// 4. 쿼리문 실행
//			ps.setInt(1, 111);
//			ps.setString(2, "나희도");
//			ps.setString(3, "마포구");
//			System.out.println(ps.executeUpdate()+" row INSERT...");
			
//			ps.setInt(1, 222);
//			ps.setString(2, "백이진");
//			ps.setString(3, "송파구");
//			System.out.println(ps.executeUpdate()+" row INSERT...");
//			
//			ps.setInt(1, 333);
//			ps.setString(2, "고유림");
//			ps.setString(3, "종로구");
//			System.out.println(ps.executeUpdate()+" row INSERT...");
			
			// DELETE
			// 3. PreparedStatement 객체 생성
//			ps = conn.prepareStatement(QueryInfo.DELETE_CM);
//			System.out.println("3. PrepareStatement 생성...");
//			// 4. 쿼리문 실행
//			ps.setInt(1, 222);
//			System.out.println(ps.executeUpdate()+" row DELETE...");
			
			// UPDATE
			// 3. PreparedStatement 객체 생성
//			ps = conn.prepareStatement(QueryInfo.UPDATE_CM);
//			System.out.println("3. PrepareStatement 생성...");
//			// 4. 쿼리문 실행
//			ps.setString(1, "인절미");
//			ps.setString(2, "중구");
//			ps.setInt(3, 333);
//			System.out.println(ps.executeUpdate()+" row UPDATE...");
			
			// SELECT
			// 3. PreparedStatement 객체 생성
			ps = conn.prepareStatement(QueryInfo.SELECT_ALL);
			System.out.println("3. PrepareStatement 생성...");
			// 4. 쿼리문 실행
			rs = ps.executeQuery();
			while(rs.next()) {
	            System.out.println(rs.getInt("SSN")+"\t"
	                              +rs.getString("NAME")+"\t"
	                              +rs.getString("ADDRESS"));
	        }
		} finally { // 연 순서 반대로 닫음
			rs.close();
			ps.close();
			conn.close();			
		}
	}
	public static void main(String[] args) throws Exception {
		new CustomerJDBCTest();
	}
}