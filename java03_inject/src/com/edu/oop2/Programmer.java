package com.edu.oop2;
/*
 * NoteBook�� ������ �ִ� ������ Ŭ������ ����
 * 
 * �̸�, �ֿ���, �޿�, �ּ� + NoteBook
 * 
 */
public class Programmer {
	public String name;
	public String mainSkill;
	public int salary;
	public String address;
	
	// Has a Relation
	public NoteBook noteBook;

	// �޼ҵ�... �� ���� / �� ��ȯ
	public void setProgrammerInfo(String name, String mainSkill, int salary, String address) {
		this.name = name;
		this.mainSkill = mainSkill;
		this.salary = salary;
		this.address = address;
	}
	
	public void buyNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook; // �� ����
	}
	
	public String getProgrammerInfo() {
		return name+","+mainSkill+","+salary+","+address;
	}
	
	public NoteBook getNoteBook() {
		return noteBook;
	}
	
	// ����� �߰�
	// 1. �������� ������ ����
	public int getAnnualSalary() {
		return salary*12;
	}
	// 2. �������� �޿��� �������� 50���� �� �߰��� �޿��� ����
	public int changeSalary(int amount) { // �Ű����� amount ���
		salary += amount; //salary = salary + amount;
	}
}
