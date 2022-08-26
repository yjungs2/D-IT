package com.edu.datatype;
/*
 * 필드 선언
 * madeCompany 제조회사 --- "동신사"
 * color 색상 --- W
 * price 가격 --- 300.23
 * scratch 하자 --- 있음 / 없음
 * material 재질 --- 합판과 알루미늄
 * buyDate 구매 날짜 --- 2022-07-19 (class MyDate)
 * 
 * set() / get()
 */
class MyDate { // 같은 파일 안에서는 자유롭게 접근 가능해서 public 생략
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
	// 필드는 기본값을 가진다
	// 로컬변수는 기본값이 없다. 그래서 사용하기 전 반드시 초기화해야 한다.
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
		// 1. 객체 생성 2. 함수 호출
		WhiteBoard wb = new WhiteBoard();
		//wb.setWhiteBoard(madeCompany, color, price, scratch, material, buyDate);
		
		// MyDate md = new MyDate -> md 사용
		wb.setWhiteBoard("동신사", 'W', 34.99f, true, "합판", new MyDate());
		
		System.out.println(wb.getWhiteBoard());
	}
}
