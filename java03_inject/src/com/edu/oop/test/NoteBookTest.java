package com.edu.oop.test;
/*
 * NoteBookTest의 문제점
 * : 필드가 많아질수록 코드라인이 늘어남
 * 더욱이 생성되는 객체가 커질수록 코드량은 기하급수적으로 증가함
 * 
 * 필드에 값을 직접(direct) 할당하면 발생하는 문제점
 * 
 * => NoteBookTest의 해결책
 * : 필드 초기화 하는 기능(메소드)을 만든다.
 */

import com.edu.oop.NoteBook;

public class NoteBookTest {
	// main에서 시작하고 끝남
	public static void main(String[] args) {
		/*
		 * 1. 객체 생성
		 * 2. 값 할당 | 메소드 호출
		 */
		NoteBook nb = new NoteBook();
		NoteBook nb1 = new NoteBook();
		
		// 필드 초기화 (새로운 값이 할당(assign)됨)
		// variable(변수) = value(값)
//		nb.brand = "HP";
//		nb.price = 1200000;
//		nb.serialNumber = 1234;
//		
//		nb1.brand = "samsung";
//		nb1.price = 1300000;
//		nb1.serialNumber = 2222;
		
		// set~~() 사용해서 필드 초기화
		nb.setNoteBookInfo("HP", 1200000, 1234);
		nb1.setNoteBookInfo("samsung", 130000, 2222);
		
		// 함수 Calling Method
		// void -> return type 없음
//		nb.printNoteBookInfo();
//		System.out.println("Brand : "+nb.getBrand());
//		
//		nb1.printNoteBookInfo();
//		System.out.println("Brand : "+nb1.getBrand());
		
		System.out.println(nb.getNoteBookInfo());
		System.out.println(nb1.getNoteBookInfo());
	}

}