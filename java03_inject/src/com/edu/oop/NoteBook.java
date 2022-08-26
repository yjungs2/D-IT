package com.edu.oop;
/*
 * Object Class
 * 
 * �ʵ� ����;
 * 
 * void setXxx(o, o, o) {
 * // �ʵ� �ʱ�ȭ
 * }
 * ���� Ÿ�� getXxx(x) {
 * // ??(��ħ)	 
 * }
 * 
 */

public class NoteBook {
	// 1. �ʵ� ���� == ���� ���� : ����Ÿ�� �����̸�;
	public String brand;
	public int price;
	public int serialNumber;
	
	// 2. �޼ҵ� ����
	// �Լ� working Method
	// step1
//	public void printNoteBookInfo() { // �޼ҵ� ����� .. return type (������ �־�� ��) + �޼ҵ� �̸� (�Ű�����)
//		System.out.println("NoteBookInfo :: "+brand+","+price+","+serialNumber); // �޼ҵ� ������
//	}
	
	// step2
	public String getNoteBookInfo() {
		// String Data + Non-String ==> ??(��ħ)
		return "NoteBookInfo :: "+brand+","+price+","+serialNumber;
	}
	
	// 3. �޼ҵ� �߰�
	// ��Ʈ���� �귣�带 �����ϴ� ����� �߰�
	public String getBrand() {
		return brand; // �޼ҵ带 ȣ���� �������� ���� ���ϵȴ�. (back �ȴ�)
	}
	
	// �ʵ� �ʱ�ȭ �ϴ� ����� �߰� ex) setField(), setInfo(), setNoteBookInfo()
	// �ʵ忡 ���� �Ҵ� -> �� ���� -> ��ȯ���� �ʿ����.(void) but, �Ű������� �ʿ��ϴ�.
	public void setNoteBookInfo(String brand, int price, int serialNumber) { // ���� ���� (temporary ����)
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
		// �ʵ� ���� = ���� ���� (�ʵ� �ʱ�ȭ �̷����)
		// �ʵ� �̸��� ���� ������ �̸��� ���� �� �ʵ� �տ� this�� ���δ�.
	}
	
}
