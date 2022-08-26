package com.edu.oop;
/*
 * ���� �ٽ� �̽�
 * 
 * Object Class					|	~ Test (Test Ŭ����, ���� Ŭ����)
 * main() �� ����. -> �������� ���	|	main() �� �ִ�. -> ������ ���
 * -----------------------------------------------------------------------
 * ���� ���							1. ��ü ���� == Ŭ������ ����� �޸𸮿� �ø���.
 * �ʵ� (��� ����) : ���� ����Ǵ� ���� 		2. ���� 
 * �޼ҵ� (�Լ�) : ���						�ʵ� -> �� �Ҵ�
 * 										�޼ҵ� -> ȣ��
 * -----------------------------------------------------------------------
 *
 */
public class NoteBook {
	// 1. �ʵ� ����
	public String brand;
	public int price;
	public int serialNumber;
	
	// 2. �޼ҵ� ����
	// �Լ� working Method
	public void printNoteBookInfo() { // �޼ҵ� ����� .. return type (������ �־�� ��) + �޼ҵ� �̸� (�Ű�����)
		System.out.println("NoteBookInfo :: "+brand+","+price+","+serialNumber); // �޼ҵ� ������
	}
	
	// 3. �޼ҵ� �߰�
	// ��Ʈ���� �귣�带 �����ϴ� ����� �߰�
	public String getBrand() {
		return brand; // �޼ҵ带 ȣ���� �������� ���� ���ϵȴ�. (back �ȴ�)
	}
	
}
