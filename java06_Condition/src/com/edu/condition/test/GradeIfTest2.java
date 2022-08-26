package com.edu.condition.test;

import java.util.Scanner;

// 실행시점에서 서로 다른 성적이 입력될 수 있도록 코드를 수정
// Scanner 객체를 이용
public class GradeIfTest2 {
	public static void main(String[] args) {
		// int grade = 88; // Local Variable
		System.out.println("성적 입력 >>");
		Scanner sc = new Scanner(System.in);
		int grade = sc.nextInt();
		
		System.out.println("과목 입력 >>");
		String subject = sc.next();
		
		if(grade <= 100 & grade >= 90) { // false
			System.out.println(subject+", A Grade");
		} else if(grade < 90 & grade >= 80) { // true
			System.out.println(subject+", B Grade");
		} else if(grade < 80 & grade >= 70) { // false
			System.out.println(subject+", C Grade");
		} else {
			System.out.println(subject+", Try Again");
		}
	}
}
