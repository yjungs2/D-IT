package com.edu.capsul.test;
// month, day 값을 Scanner로 받는다.
// 오늘은 0월 22일입니다. (X)
// 오늘은 7월 0일입니다. (X)
// 이렇게 출력되지 않도록 합니다.
import com.edu.capsul.MyDate;
import java.util.Scanner;

public class MyDateTest {

	public static void main(String[] args) {
		MyDate md = new MyDate();
		System.out.println(md);
		// com.edu.capsul.MyDate@7852e922 -> FQCN
		
		// 필드 public
		//md.month = 30;
		//md.day = 100;
		
		// 필드 private
		//md.setMonth(30);
		//md.setDay(100);
		
		// scanner
		System.out.println("월 입력 >>");
		Scanner sc = new Scanner(System.in);
		md.setMonth(sc.nextInt());
		System.out.println("일 입력>>");
		md.setDay(sc.nextInt());
		
		System.out.println("오늘은 "+md.getMonth()+"월 "+md.getDay()+"일 입니다.");
	}
}
