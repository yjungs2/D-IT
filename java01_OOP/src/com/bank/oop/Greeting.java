package com.bank.oop;
/*
 Greeting
  Ư���� ��󿡰� �λ��� ����ϴ� ����� �ϴ� Ŭ����
��Ŭ������ ������ �޼ҵ�� �����Ǿ��� �ִ�.��

 ���� ����� -> ����Ÿ�� �����̸� ;
 string who;
 string greet;
 
 ���(�޼ҵ�) ����
 sayHello()
 */
public class Greeting {
	// 1. �ʵ� ����
	public String who;
	public String greet;

	// 2. �޼ҵ� ����
	public void sayHello() {
		// �ش� �޼ҵ尡 �ϴ� ����� ���� �ۼ�.. �ֿܼ� ����ϴ� ���.
		//sysout �Է��ϰ� Ctrl + Spacebar -> System.out.println() �ڵ��ϼ�
		System.out.println(who+", "+greet);
	}
}
