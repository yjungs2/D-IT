package com.edu.condition.test;

import java.util.Scanner;

// ����������� ���� �ٸ� ������ �Էµ� �� �ֵ��� �ڵ带 ����
// Scanner ��ü�� �̿�
public class GradeIfTest2 {
	public static void main(String[] args) {
		// int grade = 88; // Local Variable
		System.out.println("���� �Է� >>");
		Scanner sc = new Scanner(System.in);
		int grade = sc.nextInt();
		
		System.out.println("���� �Է� >>");
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
