package com.edu.capsul;
// Encapsulation
// month는 1~12까지의 값만 받아들이도록 로직을 작성
// day는 month에 따라서 받아들이는 값이 달라진다.
// 1, 3, 5, 7, 8, 10, 12월 1~31일
// 4, 6, 9, 11월 1~30일
// 2월 1~28일까지의 값이 받아들여지도록 로직을 작성
public class MyDate {
	private int month;
	private int day;
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		// 필드 초기화 직전에 valid한 값이 할당되도록 제어문을 달아준다.
		if(month>=1 && month<=12) {
			this.month = month;
		} else {
			System.out.println("Invalid Month");
			System.exit(0); // 0 : 정상 종료, 음수 : 문제가 발생해서 여기서 종료한다는 의미
		}	
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) { // month는 필드, day는 로컬
		switch(month) { // 1~12
			case 2: // 2월달이면
				if(day>=1 && day<=28) {
					this.day = day;
				} else {
					System.out.println("Invalid Day");
					System.exit(0); // 0 : 정상 종료
				}
			break; // 해당 case를 빠져나오고, switch문을 빠져나옴.
			
			case 4:
			case 6:
			case 9:
			case 11:
				if(day>=1 && day<=30) {
					this.day = day;
				} else {
					System.out.println("Invalid Day");
					System.exit(0); // 0 : 정상 종료
				}
			break; // 해당 case를 빠져나오고, switch문을 빠져나옴.
			
			default:
				if(day>=1 && day<=31) {
					this.day = day;
				} else {
					System.out.println("Invalid Day");
					System.exit(0); // 0 : 정상 종료
				}
		} // switch
	}
}
