package com.edu.bank.test;

import com.edu.bank.Account;
import com.edu.bank.Customer;

// Class Type Array의 생성과 선언

public class BankArrayTest2 {
	public static void main(String[] args) {
		Account[] accounts = {
				new Account(10000, "부산은행"),
				new Account(20000, "국민은행"),
				new Account(30000, "신한은행")
		};

		Customer james = new Customer(111, "James");
		
		// 1. James가 3개의 통장을 개설... 부산, 국민, 신한은행
		james.setAccounts(accounts);
		
		// 2. James가 개설한 통장 중에서 부산은행 통장을 받아온다.
		Account[] returnAcc = james.getAccounts();
		Account busanBK = null;
		for(Account acc:returnAcc)
			if(acc.getBankName().equals("부산은행")) busanBK = acc;
		
		System.out.println("=============부산은행 통장에 입금을 합니다.==============");
		busanBK.deposit(900.0); //return 됨
		busanBK.deposit(30000.0);
		System.out.println("=============부산은행 통장에 출금을 합니다.==============");
		busanBK.withdraw(50000.0); //return 됨
		busanBK.withdraw(30000.0);
		System.out.println("=============부산은행 잔액을 확인합니다.==============");
		System.out.println("잔액확인 : "+busanBK.getBalance());
	}
}
