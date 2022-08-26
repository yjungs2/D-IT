package com.edu.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.jdbc.dao.CustomerDAO;
import com.edu.jdbc.exception.DuplicateSsnException;
import com.edu.jdbc.exception.RecordNotFoundException;
import com.edu.jdbc.vo.Customer;

import config.ServerInfo;

public class CustomerDAOImpl implements CustomerDAO{
	private static CustomerDAOImpl dao = new CustomerDAOImpl();
	private CustomerDAOImpl() {
		System.out.println("Singletone Pattern...Creating");
	}
	public static CustomerDAOImpl getInstance() {
		return dao;
	}
	
	// Source > Override/Implement Methods...
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DB Server Connection...");
		return conn;
	}
	@Override
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	@Override
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(conn, ps);
	}
	// ssn이 있는지 없는지...SELECT ssn FROM customer WHERE ssn=?
	private boolean ssnExist(int ssn, Connection conn) throws SQLException { // 아래에서 쓰는 거지, customer이 쓰는 게 아니므로 private
		PreparedStatement ps = null;
		ResultSet rs = null;
		//boolean flag = false; // return 타입이 있을 때 선언

		String query = "SELECT ssn FROM customer WHERE ssn=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, ssn);
		rs = ps.executeQuery();
			
		return rs.next(); // 있으면  1, 없으면  0 -> boolean으로 return
	}
	// INSERT : registerCustomer
	@Override
	public void registerCustomer(Customer vo) throws SQLException, DuplicateSsnException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(!ssnExist(vo.getSsn(), conn)) {// 추가하려는 회원이 없다면
				String query = "INSERT INTO customer(ssn, cust_name, address) VALUES(?, ?, ?)";
				ps = conn.prepareStatement(query);
				ps.setInt(1, vo.getSsn());
				ps.setString(2, vo.getCustName());
				ps.setString(3, vo.getAddress());
				
				int row = ps.executeUpdate();
				System.out.println(row+"row Customer Register Success!");
			} else { // 추가하려는 회원이 있다면
				throw new DuplicateSsnException("이미 등록된 회원입니다."); // 의도적으로 던짐 -> 앞에 throw 사용
			}
		} finally {
			closeAll(conn, ps);
		}
	}
	// DELETE : removeCustomer
	@Override
	public void removeCustomer(int ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(ssnExist(ssn, conn)) { // 삭제할 대상이 있다면
				String query = "DELETE FROM customer WHERE ssn=?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, ssn);
				
				int row = ps.executeUpdate();
				System.out.println(row+"row Customer Delete Success!");
			} else { // 삭제할 대상이 없다면
				throw new RecordNotFoundException("삭제할 대상이 존재하지 않습니다.");
			}
		} finally {
			closeAll(conn, ps);
		}
	}
	// UPDATE : updateCustomer
	@Override
	public void updateCustomer(Customer vo) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(ssnExist(vo.getSsn(), conn)) { // 수정할 대상이 있다면
				String query = "UPDATE customer SET cust_name=?, address=? WHERE ssn=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, vo.getCustName());
				ps.setString(2, vo.getAddress());
				ps.setInt(3, vo.getSsn());
				
				int row = ps.executeUpdate();
				System.out.println(row+"row Customer Update Success!");
			} else { // 수정할 대상이 없다면
				throw new RecordNotFoundException("수정할 대상이 존재하지 않습니다.");
			}
		} finally {
			closeAll(conn, ps);
		}
	}
	// SELECT ONE by SSN
	@Override
	public Customer getCustomer(int ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer cust = null;
		try {
			conn = getConnect();
			String query ="SELECT ssn, cust_name, address FROM customer WHERE ssn=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, ssn);
			
			rs = ps.executeQuery();
			if(rs.next()) { // 해당되는 선택 대상이 있다면
				cust = new Customer(ssn, rs.getString("cust_name"), rs.getString("address"));
			}
		} finally {
			closeAll(conn, ps, rs);
		}
		return cust;
	}
	// SELECT ALL
	@Override
	public ArrayList<Customer> getCustomer() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<>();
		try {
			conn = getConnect();
			String query = "SELECT ssn, cust_name, address FROM customer";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Customer(rs.getInt("ssn"), rs.getString("cust_name"), rs.getString("address")));
			}
		} finally {
			closeAll(conn, ps, rs);
		}
		return list;
	}
	// SELECT ALL by ADDRESS
	@Override
	public ArrayList<Customer> getCustomer(String address) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<>();
		try {
			conn = getConnect();
			String query = "SELECT ssn, cust_name FROM customer WHERE address=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, address);
			rs = ps.executeQuery();
			if(rs.next()) {
				list.add(new Customer(rs.getInt("ssn"), rs.getString("cust_name"), address));
			}
		} finally {
			closeAll(conn, ps, rs);
		}
		return list;
	}
	// GET COUNT by ADDRESS
	@Override
	public int getCountByAddress(String address) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = getConnect();
			String query = "SELECT ssn, cust_name FROM customer WHERE address=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, address);
			rs = ps.executeQuery();
			if(rs.next()) {
				count += 1;
			}
		} finally {
			closeAll(conn, ps, rs);
		}
		return count;
	}
}