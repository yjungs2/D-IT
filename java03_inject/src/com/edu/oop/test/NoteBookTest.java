package com.edu.oop.test;
/*
 * NoteBookTest�� ������
 * : �ʵ尡 ���������� �ڵ������ �þ
 * ������ �����Ǵ� ��ü�� Ŀ������ �ڵ差�� ���ϱ޼������� ������
 * 
 * �ʵ忡 ���� ����(direct) �Ҵ��ϸ� �߻��ϴ� ������
 * 
 * => NoteBookTest�� �ذ�å
 * : �ʵ� �ʱ�ȭ �ϴ� ���(�޼ҵ�)�� �����.
 */

import com.edu.oop.NoteBook;

public class NoteBookTest {
	// main���� �����ϰ� ����
	public static void main(String[] args) {
		/*
		 * 1. ��ü ����
		 * 2. �� �Ҵ� | �޼ҵ� ȣ��
		 */
		NoteBook nb = new NoteBook();
		NoteBook nb1 = new NoteBook();
		
		// �ʵ� �ʱ�ȭ (���ο� ���� �Ҵ�(assign)��)
		// variable(����) = value(��)
//		nb.brand = "HP";
//		nb.price = 1200000;
//		nb.serialNumber = 1234;
//		
//		nb1.brand = "samsung";
//		nb1.price = 1300000;
//		nb1.serialNumber = 2222;
		
		// set~~() ����ؼ� �ʵ� �ʱ�ȭ
		nb.setNoteBookInfo("HP", 1200000, 1234);
		nb1.setNoteBookInfo("samsung", 130000, 2222);
		
		// �Լ� Calling Method
		// void -> return type ����
//		nb.printNoteBookInfo();
//		System.out.println("Brand : "+nb.getBrand());
//		
//		nb1.printNoteBookInfo();
//		System.out.println("Brand : "+nb1.getBrand());
		
		System.out.println(nb.getNoteBookInfo());
		System.out.println(nb1.getNoteBookInfo());
	}

}