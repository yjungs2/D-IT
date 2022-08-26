package com.edu.book.test;

import com.edu.book.dao.impl.BookDAOImpl;
import com.edu.book.vo.Book;

import config.ServerInfo;

public class BookDAOTest {
	public static void main(String[] args) {
		BookDAOImpl dao = BookDAOImpl.getInstance();
		// 메소드를 try { catch 안에서 하나씩 호출하면서 작업을 마무리 하시기 바랍니다.
		try {
			//dao.registerBook(new Book("7G7", "강아지똥", "권정생", "길벗", 12000));
			//dao.registerBook(new Book("1A1", "강아지똥", "권정생", "길벗", 12000));
			//dao.deleteBook("7G7");
			//System.out.println(dao.findByIsbn("4D4"));
			//System.out.println(dao.findByTitle("몰입"));
			//System.out.println(dao.findByTitle("자바")); // 자바의 정석
			//System.out.println(dao.findByWriter("남궁성"));
			//System.out.println(dao.findByWriter("김자바"));
			//System.out.println(dao.findByPublisher("동아"));
			//System.out.println(dao.findByPrice(15000, 30000));
			//System.out.println(dao.findByPrice(35000, 30000));
			//dao.discountBook(10, "길벗");
			System.out.println(dao.findAllBook());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("1. 드라이버 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 실패...");
		}
	}
}