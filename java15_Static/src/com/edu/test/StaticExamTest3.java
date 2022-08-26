package com.edu.test;
// static
class A{
	public final static int BASIC_SALARY = 3000000; // final + 변수 = 상수
	public final String test() {  // final + 메소드 -> 오버라이딩 금지
		return "오버라이딩 금지";
	}
}
final class B{ // final + 클래스 -> 상속 금지
//	BASIC_SALARY = 3500000;
}
//class C extends B{
//	B 상속 불가
//}
//class D extends A{
//	public final String test() {
//		return "오버라이딩 금지";
//	}
//}

public class StaticExamTest3 {
	public static void main(String[] args) {
		
	}
}
