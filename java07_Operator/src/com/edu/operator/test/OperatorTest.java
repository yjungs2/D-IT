package com.edu.operator.test;
/*
 * 			선언된 위치		기본값					메모리	별칭
 * field	메소드 바깥		있다						heap	멤버변수
 * local	메소드 블락 안		없다(사용 전 반드시 초기화)	stack	지역변수, Temporary 변수, Automatically 변수
 */
public class OperatorTest {
	public static void main(String[] args) {
		// Local Variation ... main 안에서 선언
		int i = 5;
		int j = 3;
		
		System.out.println(i==j); // false
		System.out.println(i!=j); // true
		
		System.out.println("연산자 : "+i%j); //2
		System.out.println("연산자 : "+i/j); //1
		
		int k = 10;
		System.out.println(k++); // 10
		System.out.println(k); // 11
		
		int m = 10;
		System.out.println(++m); // 11
		System.out.println(m); // 11
	}
}
