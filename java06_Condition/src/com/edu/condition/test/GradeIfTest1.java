package com.edu.condition.test;
// ������ �����ϴ� ���α׷��� �ۼ�
// �ʵ�(Field) ������ Ŭ���� �ٷ� �Ʒ� / �޼ҵ� �� �ٱ�
// ����� ��ġ�� �ʵ�� ���ú����� ���е�
public class GradeIfTest1 {
	public static void main(String[] args) {
		int grade = 88; // Local Variable
		if(grade <= 100 & grade >= 90) { // false
			System.out.println("A Grade");
		} else if(grade < 90 & grade >= 80) { // true
			System.out.println("B Grade");
		} else if(grade < 80 & grade >= 70) { // false
			System.out.println("C Grade");
		} else {
			System.out.println("Try Again");
		}
	}
}
