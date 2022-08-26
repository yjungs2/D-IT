package com.edu.test;
// 추상메소드(구현부가 없는 메소드)
// 기능의 Template
// field가 없다.
// 추상이기 때문에...객체 생성의 대상이 될 수 없다...Type으로서만 존재
interface Flyer{
	void fly(); //public abstract 생략 (안 붙여도 붙어있음)
	public abstract void land();
	void take_off();
}

class Bird implements Flyer{
	@Override
	public void fly() {
		System.out.println("새가 난다.");
	}
	@Override
	public void land() {
		System.out.println("새가 이륙한다.");
	}
	@Override
	public void take_off() {
		System.out.println("새가 착륙한다.");
	}
}

public class InterfaceTest {
	public static void main(String[] args) {
		Flyer f = new Bird(); // 다형성
	}
}
