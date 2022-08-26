package com.edu.oop2;
/*
 * NoteBook을 가지고 있는 개발자 클래스를 정의
 * 
 * 이름, 주요기술, 급여, 주소 + NoteBook
 * 
 */
public class Programmer {
	public String name;
	public String mainSkill;
	public int salary;
	public String address;
	
	// Has a Relation
	public NoteBook noteBook;

	// 메소드... 값 주입 / 값 반환
	public void setProgrammerInfo(String name, String mainSkill, int salary, String address) {
		this.name = name;
		this.mainSkill = mainSkill;
		this.salary = salary;
		this.address = address;
	}
	
	public void buyNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook; // 값 주입
	}
	
	public String getProgrammerInfo() {
		return name+","+mainSkill+","+salary+","+address;
	}
	
	public NoteBook getNoteBook() {
		return noteBook;
	}
	
	// 기능을 추가
	// 1. 개발자의 연봉을 리턴
	public int getAnnualSalary() {
		return salary*12;
	}
	// 2. 개발자의 급여를 기존보다 50만원 더 추가된 급여로 변경
	public int changeSalary(int amount) { // 매개변수 amount 사용
		salary += amount; //salary = salary + amount;
	}
}
