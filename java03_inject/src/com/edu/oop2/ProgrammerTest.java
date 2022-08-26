package com.edu.oop2;

public class ProgrammerTest {

	public static void main(String[] args) {
		/*
		 * 1. 객체 생성
		 * 2. 메소드 호출
		 * -----------------------------------
		 * 염미정이라는 개발자를 생성
		 * 정보를 입력 ... 이름, 주요기술, 주소, 급여
		 * 염미정이 노트북을 구매 (setter)
		 * 염미정이 구매한 노트북을 받아서 노트북의 정보를 출력
		 * 최종적으로 염미정의 노트북의 브랜드를 출력
		 */
		Programmer pro1 = new Programmer();
		pro1.setProgrammerInfo("염미정", "자바", 4000000, "산포시");
		
		NoteBook nb1 = new NoteBook();
		nb1.setNoteBookInfo("samsung", 1200000, 1234);
		pro1.buyNoteBook(nb1); // has a relation 성립. 미정이가 삼성노트북을 구매했다.
		
		NoteBook pro1NB = pro1.getNoteBook();
		System.out.println("==========NoteBook Information==========");
		System.out.println(pro1NB.getNoteBookInfo());
		
		System.out.println("==========NoteBook Brand==========");
		System.out.println(pro1NB.getBrand());
	}
}
