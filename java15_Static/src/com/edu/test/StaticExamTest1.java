package com.edu.test;
// static
class StaticExam{
	// member level에서 사용해야 한다.
	static String name = "홍길동"; // static V, class V, 전역변수
	static int age = 10;
	int count = 1; // field, 멤버 변수
	
	// static은 static끼리 통한다.
	public static void getMember() {
		System.out.println("우/유/빛/깔/"+name);
		// count++;
	}
	public void getMember2() {
		//static String address = "한남동"; //local level 안 됨
		System.out.println("우/유/빛/깔/"+name);
	}
}

public class StaticExamTest1 {
	public static void main(String[] args) {
		StaticExam exam = new StaticExam();
		//static String name = "홍길동";
		// static한 멤버를 사용할 때는 클래스이름.static 멤버;
		StaticExam.getMember(); // 우/유/빛/깔/홍길동
		exam.getMember2(); // 우/유/빛/깔/홍길동
		System.out.println("=========================");
		exam.getMember(); // 우/유/빛/깔/홍길동
	}
}
