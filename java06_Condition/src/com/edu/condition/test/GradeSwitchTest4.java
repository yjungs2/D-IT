package com.edu.condition.test;

import java.util.Scanner;

public class GradeSwitchTest4 {
	public static void main(String[] args) {
		System.out.println("���� �Է� >>");
		Scanner sc = new Scanner(System.in);
		int grade = sc.nextInt();
		
		switch(grade) {
			case 95:
			case 90:
				System.out.println("A Grade");
			break;
			case 85:
			case 80:
				System.out.println("B Grade");
			break;
			case 75:
			case 70:
				System.out.println("C Grade");
			break;
			default:
				System.out.println("Nuts~~");
		}
	}
}
