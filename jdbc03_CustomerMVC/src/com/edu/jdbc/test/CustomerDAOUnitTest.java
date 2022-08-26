package com.edu.jdbc.test;

import java.util.ArrayList;

import com.edu.jdbc.dao.impl.CustomerDAOImpl;
import com.edu.jdbc.vo.Customer;

import config.ServerInfo;

public class CustomerDAOUnitTest {
	public static void main(String[] args) {
		CustomerDAOImpl dao = CustomerDAOImpl.getInstance();
		try {
//			dao.registerCustomer(new Customer(222, "구자경", "신사동"));
//			System.out.println(dao.getCustomer(222));
//			dao.removeCustomer(111);
			dao.removeCustomer(333);		
//			dao.registerCustomer(new Customer(123, "구자경", "방배동"));
//			Customer vo = dao.getCustomer(123);
//			dao.registerCustomer(new Customer(333, "염미정", "산포시"));
//			System.out.println(vo);
//			
//			System.out.println("\n======================\n");
			ArrayList<Customer> returnlist = dao.getCustomer();
			for(Customer c : returnlist) System.out.println(c);
		} catch(Exception e) {
//			System.out.println("Exception 발생...!");
			System.out.println(e.getMessage());
		}
	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("1. 드라이버 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 실패..");
		}
		
	}
}