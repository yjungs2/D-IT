package com.bank.busan.test;

import com.bank.busan.Account;
import com.bank.busan.Customer;

public class BankAppTest {

	public static void main(String[] args) {
		System.out.println("계좌 정보 입력 (계좌번호, 고객명, 잔액, 은행 이름) >>");
		Account ac1 = new Account();
		Customer cs1 = new Customer();
		cs1.setCustomerInfo("미정", ac1, "산포시");
		
		System.out.println("계좌 정보 입력 (계좌번호, 고객명, 잔액, 은행 이름) >>");
		Account ac2 = new Account();
		Customer cs2 = new Customer();
		cs2.setCustomerInfo("자경", ac2, "서울시");

		Account cs1AC = cs1.getAccount();
		System.out.println(cs1AC.getAccountInfo());
		System.out.println(cs1AC.getBankName()+"\n");
		
		Account cs2AC = cs2.getAccount();
		System.out.println(cs2AC.getAccountInfo());
		System.out.println(cs1AC.getBankName()+"\n");
		
		cs1AC.deposit(500);
		System.out.println(cs1AC.getBalance());
		cs1AC.deposit(100000);
		System.out.println(cs1AC.getBalance());
		cs1AC.withdraw(50000);
		System.out.println(cs1AC.getBalance());
		cs1AC.withdraw(60000);
		System.out.println(cs1AC.getBalance()+"\n");
		
		cs2AC.withdraw(6000);
		System.out.println(cs2AC.getBalance());
		cs2AC.deposit(800);
		System.out.println(cs2AC.getBalance());
		cs2AC.withdraw(2000);
		System.out.println(cs2AC.getBalance()+"\n");
	}
}
