package com.edu.loop.test;

public class BasicLoopTest2 {
	public static void main(String[] args) {
		int total = 0;
		
//		for(int member = 1; member<=10; member++) {
//			if(total>=30) break;
//			total += member;
//		}		
//		System.out.println("Total : "+total); //Total : 36
		
		for(int num=1; num<=10; num++) {
			if(num % 2==0) continue; //짝수일 때 건너뛰지만 반복 계속
			total += num;
		} // 1~10까지의 홀수의 합 25
		System.out.println("Total : "+total); // Total : 25
	}
}
