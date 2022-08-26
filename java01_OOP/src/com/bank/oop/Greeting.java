package com.bank.oop;
/*
 Greeting
  특정한 대상에게 인삿말을 출력하는 기능을 하는 클래스
“클래스는 변수와 메소드로 구성되어져 있다.”

 변수 선언법 -> 변수타입 변수이름 ;
 string who;
 string greet;
 
 기능(메소드) 정의
 sayHello()
 */
public class Greeting {
	// 1. 필드 선언
	public String who;
	public String greet;

	// 2. 메소드 정의
	public void sayHello() {
		// 해당 메소드가 하는 기능을 직접 작성.. 콘솔에 출력하는 기능.
		//sysout 입력하고 Ctrl + Spacebar -> System.out.println() 자동완성
		System.out.println(who+", "+greet);
	}
}
