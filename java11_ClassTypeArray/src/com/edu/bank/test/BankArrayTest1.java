package com.edu.bank.test;

import com.edu.bank.Account;

// Class Type Array의 생성과 선언

public class BankArrayTest1 {
	public static void main(String[] args) {
		Account[] accounts = new Account[3];
		
		System.out.println(accounts);
		for(Account acc : accounts) System.out.println(acc); // null null null
		
		System.out.println("============================");
		accounts[0] = new Account(10000, "부산은행");
		accounts[1] = new Account(20000, "국민은행");
		accounts[2] = new Account(30000, "신한은행");
		// 객체의 주소값이 들어감. 재참조
		
		System.out.println(accounts);
		for(Account acc : accounts) System.out.println(acc);
		
		System.out.println("=============배열 안의 정보를 출력===============");
		for(int i=0; i<accounts.length; i++) {
			System.out.println(accounts[i].getBankName()+", "+accounts[i].getBalance());
		}
	}
}
