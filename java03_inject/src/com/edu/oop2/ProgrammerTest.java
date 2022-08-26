package com.edu.oop2;

public class ProgrammerTest {

	public static void main(String[] args) {
		/*
		 * 1. ��ü ����
		 * 2. �޼ҵ� ȣ��
		 * -----------------------------------
		 * �������̶�� �����ڸ� ����
		 * ������ �Է� ... �̸�, �ֿ���, �ּ�, �޿�
		 * �������� ��Ʈ���� ���� (setter)
		 * �������� ������ ��Ʈ���� �޾Ƽ� ��Ʈ���� ������ ���
		 * ���������� �������� ��Ʈ���� �귣�带 ���
		 */
		Programmer pro1 = new Programmer();
		pro1.setProgrammerInfo("������", "�ڹ�", 4000000, "������");
		
		NoteBook nb1 = new NoteBook();
		nb1.setNoteBookInfo("samsung", 1200000, 1234);
		pro1.buyNoteBook(nb1); // has a relation ����. �����̰� �Ｚ��Ʈ���� �����ߴ�.
		
		NoteBook pro1NB = pro1.getNoteBook();
		System.out.println("==========NoteBook Information==========");
		System.out.println(pro1NB.getNoteBookInfo());
		
		System.out.println("==========NoteBook Brand==========");
		System.out.println(pro1NB.getBrand());
	}
}
