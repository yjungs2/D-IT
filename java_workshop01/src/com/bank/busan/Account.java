package com.bank.busan;

import java.util.Scanner;

public class Account {
	Scanner sc = new Scanner(System.in);
	int accNumber = sc.nextInt(); // 계좌번호
	String custName = sc.next(); // 고객명
	double balance = sc.nextDouble(); // 잔액
	String bankName = sc.next(); // 은행 이름
	
	public double getBalance() {
		return balance;
	}
	
	public void withdraw(double amt) { // 출금 -> 잔액 이하의 금액만 출금 가능하도록
		if(amt <= balance) {
			balance -= amt;
			//System.out.println(amt+"원이 출금되었습니다. 현재 잔액은 "+balance+"입니다.");
		}
//		else {
//			System.out.println("잔액이 부족하여 출금할 수 없습니다.");
//		}
	}
	
	public void deposit(double amt) { //입금 -> 1천원 이상의 금액만 입금하도록
		if (amt >= 1000) {
			balance += amt;
			//System.out.println(amt+"원이 입금되었습니다. 현재 잔액은 "+balance+"입니다.");
		}
//		else {
//			System.out.println("1천원 이상의 금액부터 입금 가능합니다.");
//		}
	}
	
	public String getAccountInfo() {
		return "계좌번호 : "+accNumber+"\n고객명 : "+custName+"\n잔액 : "+balance;
	}
	
	public String getBankName() {
		return "은행 이름 : "+bankName;
	}
}

