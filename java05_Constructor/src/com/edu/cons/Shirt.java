package com.edu.cons;

public class Shirt {
	public String brand;
	public boolean longSleeved;
	public char size;

	public Shirt() {	} // �⺻������

	// ����� ������ ... �ʵ� �ʱ�ȭ
	public Shirt(String brand, boolean longSleeved, char size) {
		this.brand = brand;
		this.longSleeved = longSleeved;
		this.size = size;
	}
	public String getBrand() {
		return brand;
	}
	public boolean isLongSleeved() {
		return longSleeved;
	}
	public char getSize() {
		return size;
	}
}