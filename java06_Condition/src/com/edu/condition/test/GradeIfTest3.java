package com.edu.condition.test;

import java.util.Scanner;

// ����� { ���� �ڵ���� �� ���� ���� { ������ �����ϴ�.
public class GradeIfTest3 {
	public static void main(String[] args) {
		System.out.println("���� �Է� >>");
		Scanner sc = new Scanner(System.in);
		int grade = sc.nextInt();
		
		System.out.println("���� �Է� >>");
		String subject = sc.next();
		
		if(grade <= 100 & grade >= 90) System.out.println(subject+", A Grade");
		else if(grade < 90 & grade >= 80) System.out.println(subject+", B Grade");
		else if(grade < 80 & grade >= 70) System.out.println(subject+", C Grade");
		else System.out.println(subject+", Try Again");
	}
}
