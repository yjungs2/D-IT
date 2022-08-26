package com.edu.loop.test;

public class BasicLoopTest1 {
	public static void main(String[] args) {
		System.out.println("========for========");
		for(int i=0; i<10; i++) { // 로컬변수 i는 for 안에서만
			// 10번... 반복하는 횟수를 알 수 있다
			System.out.println("i : "+i);
		} // for(int i=0; i<10; i++) System.out.println("i : "+i);

		System.out.println("========while========");
		int i = 10;
		while(i>0) {
			System.out.println("i : "+i);
			i--;
		}
	}
}
