package com.edu.oop.test;

import com.edu.oop.NoteBook;

public class NoteBookTest {
	// main에서 시작하고 끝남
	public static void main(String[] args) {
		/*
		 * 1. 객체 생성
		 * 2. 값 할당 | 메소드 호출
		 */
		NoteBook nb = new NoteBook();
		
		// 필드 초기화 (새로운 값이 할당(assign)됨)
		// variable(변수) = value(값)
		nb.brand = "HP";
		nb.price = 1200000;
		nb.serialNumber = 1234;
		
		// 함수 Calling Method
		// void -> return type 없음
		nb.printNoteBookInfo();
		System.out.println("Brand : "+nb.getBrand());
	}

}
