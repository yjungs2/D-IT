package com.edu.oop.test;

import com.edu.oop.NoteBook;

public class NoteBookTest {
	// main���� �����ϰ� ����
	public static void main(String[] args) {
		/*
		 * 1. ��ü ����
		 * 2. �� �Ҵ� | �޼ҵ� ȣ��
		 */
		NoteBook nb = new NoteBook();
		
		// �ʵ� �ʱ�ȭ (���ο� ���� �Ҵ�(assign)��)
		// variable(����) = value(��)
		nb.brand = "HP";
		nb.price = 1200000;
		nb.serialNumber = 1234;
		
		// �Լ� Calling Method
		// void -> return type ����
		nb.printNoteBookInfo();
		System.out.println("Brand : "+nb.getBrand());
	}

}
