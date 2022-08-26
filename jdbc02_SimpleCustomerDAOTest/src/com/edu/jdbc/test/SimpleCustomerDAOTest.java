package com.edu.jdbc.test;

import java.sql.SQLException;
import com.edu.jdbc.dao.CustomerDAO;
import config.ServerInfo;

public class SimpleCustomerDAOTest {
	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAO();
		try {
//			dao.addCustomer(222,  "James", "NY");
//			dao.deleteCustomer(111);
//			dao.updateCustomer(222, "수정", "Brandon");
			dao.printAllCustomer();
		} catch(SQLException e) {
			
		}
	} // main
	
	// static initialization block -> 가장 먼저 초기화
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공...");
			
		} catch(ClassNotFoundException e) {
				System.out.println("드라이버 로딩 실패...");
		}
	}
}