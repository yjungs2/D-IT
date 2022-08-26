// DB Access하는 기능만으로 이뤄진 클래스
// = Business Logic으로만 구성된 클래스
// = DAO 클래스
/*
 * 1. 드라이버 로딩
 * 2. 디비 연결...Connection 반환 받고
 * 3. PreparedStatement 객체...쿼리문 실행하는 기능을 얘가 가지고 있다.
 * 4. 값 바인딩...쿼리문 실행
 *    int executeUpdate() -> INSERT / UPDATE / DELETE (DML)
 *    ResultSet executeQuery() -> SELECT
 * 5. 자원을 닫는다. (연 순서 반대로 닫아준다)
 *    ResultSet --> PreparedStatement --> connection을 close()
 */
/*
 * Business Logic 마다마다
 * 1. 고정적인 로직...static --> 새로운 기능을 하나 정의...이걸 매번 작성하는 게 아니라 호출...
 * 		1) Connection 반환 로직 :: getConnect()
 * 		2) 자원 닫는 로직     :: closeAll()
 * 2. 가변적인 로직...dynamic
 */
package com.edu.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class CustomerDAO {
	public CustomerDAO() {
		System.out.println("DAO Creating...");
	}
	///// 공통적인 로직 /////
	public Connection getConnect() throws SQLException{
		Connection conn = DriverManager.getConnection(ServerInfo.URL, "scott", "tiger");
		System.out.println("db연결 성공....");
		return conn;
	}
	
	// INSERT, DELETE, UPDATE...Connection, PreparedStatement
	// SELECT...Connection, PreparedStatement, ResultSet
	// => Method Overloading 기법
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException{
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException{
		if(rs!=null) rs.close();
		closeAll(conn, ps);
	}
	
	// DML - INSERT
	public void addCustomer(int ssn, String name, String address) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			String query = "INSERT INTO CUSTOMER (SSN, cust_name, ADDRESS) VALUES(?, ?, ?)";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, ssn);
			ps.setString(2, name);
			ps.setString(3, address);
			System.out.println(ps.executeUpdate()+"명 회원 등록 성공!");
		} finally {
			closeAll(conn, ps);
		}
	}
	// DML - DELETE
	public void deleteCustomer(int ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			String query = "DELETE FROM customer WHERE ssn=?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, ssn);
			System.out.println(ps.executeUpdate()+"명 회원 삭제 성공!");
		} finally {
			closeAll(conn, ps);
		}
	}
	// DML - UPDATE
	public void updateCustomer(int ssn, String name, String address) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			String query = "UPDATE CUSTOMER SET cust_name=?, ADDRESS=? WHERE SSN=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setInt(3, ssn);
			System.out.println(ps.executeUpdate()+"명 수정 성공!");
		} finally {
			closeAll(conn, ps);
		}
	}
	
	// SELECT
	public void printAllCustomer() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			String query = "SELECT SSN, NAME, ADDRESS FROM CUSTOMER";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString("name")+"\t"+rs.getString("address"));
			}
		} finally {
			closeAll(conn, ps, rs);
		}
	}
}