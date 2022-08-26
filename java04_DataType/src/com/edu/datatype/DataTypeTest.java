package com.edu.datatype;
/*
 * �ʵ� ����
 * madeCompany ����ȸ�� --- "���Ż�"
 * color ���� --- W
 * price ���� --- 300.23
 * scratch ���� --- ���� / ����
 * material ���� --- ���ǰ� �˷�̴�
 * buyDate ���� ��¥ --- 2022-07-19 (class MyDate)
 * 
 * set() / get()
 */
class MyDate { // ���� ���� �ȿ����� �����Ӱ� ���� �����ؼ� public ����
	int year;
	int month;
	int day;
	public void setDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public String getDate() {
		return year+"-"+month+"-"+day;
	}
}

class WhiteBoard {
	// �ʵ�� �⺻���� ������
	// ���ú����� �⺻���� ����. �׷��� ����ϱ� �� �ݵ�� �ʱ�ȭ�ؾ� �Ѵ�.
	String madeCompany;
	char color;
	float price;
	boolean scratch;
	String material;
	MyDate buyDate;

	public void setWhiteBoard(String madeCompany, char color, float price, boolean scratch, String material, MyDate buyDate) {
		this.madeCompany = madeCompany;
		this.color = color;
		this.price = price;
		this.scratch = scratch;
		this.material = material;
		this.buyDate = buyDate;
	}
	public String getWhiteBoard() {
		return madeCompany+"\t"
				+ color+"\t"
				+ price+"\t"
				+ scratch+"\t"
				+ material+"\t"
				+ buyDate;
	}
}
public class DataTypeTest {
	public static void main(String[] args) {
		// 1. ��ü ���� 2. �Լ� ȣ��
		WhiteBoard wb = new WhiteBoard();
		//wb.setWhiteBoard(madeCompany, color, price, scratch, material, buyDate);
		
		// MyDate md = new MyDate -> md ���
		wb.setWhiteBoard("���Ż�", 'W', 34.99f, true, "����", new MyDate());
		
		System.out.println(wb.getWhiteBoard());
	}
}
