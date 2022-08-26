package com.edu.oop;
/*
 * Object Class
 * 
 * 필드 선언;
 * 
 * void setXxx(o, o, o) {
 * // 필드 초기화
 * }
 * 리턴 타입 getXxx(x) {
 * // ??(놓침)	 
 * }
 * 
 */

public class NoteBook {
	// 1. 필드 선언 == 변수 선언 : 변수타입 변수이름;
	public String brand;
	public int price;
	public int serialNumber;
	
	// 2. 메소드 정의
	// 함수 working Method
	// step1
//	public void printNoteBookInfo() { // 메소드 선언부 .. return type (무조건 있어야 함) + 메소드 이름 (매개변수)
//		System.out.println("NoteBookInfo :: "+brand+","+price+","+serialNumber); // 메소드 구현부
//	}
	
	// step2
	public String getNoteBookInfo() {
		// String Data + Non-String ==> ??(놓침)
		return "NoteBookInfo :: "+brand+","+price+","+serialNumber;
	}
	
	// 3. 메소드 추가
	// 노트북의 브랜드를 리턴하는 기능을 추가
	public String getBrand() {
		return brand; // 메소드를 호출한 지점으로 값이 리턴된다. (back 된다)
	}
	
	// 필드 초기화 하는 기능을 추가 ex) setField(), setInfo(), setNoteBookInfo()
	// 필드에 값을 할당 -> 값 주입 -> 반환값이 필요없다.(void) but, 매개변수는 필요하다.
	public void setNoteBookInfo(String brand, int price, int serialNumber) { // 로컬 변수 (temporary 변수)
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
		// 필드 변수 = 로컬 변수 (필드 초기화 이루어짐)
		// 필드 이름과 로컬 변수의 이름이 같을 때 필드 앞에 this를 붙인다.
	}
	
}
