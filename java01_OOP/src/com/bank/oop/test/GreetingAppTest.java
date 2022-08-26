package com.bank.oop.test;
/*
 *                  OOP
 *                  
 *		Object Oriented Class	|	~~ Test
 *		��ü�� �ǹ��ϴ� Ŭ����			��ü�� �ƴ�
 *									���� object Ŭ������ ���� ��ü�� ������ִ� ���� Ŭ����
 */

import com.bank.oop.Greeting;

public class GreetingAppTest {

	public static void main(String[] args) { // main method. ���� �޼ҵ�
		// ��ü ���� == �޸𸮿� Ŭ������ ������� �� �ø���. (�ʵ� 2��(who, greet), �޼ҵ� 1��(sayHello))
		// == ����� �����Ϸ���.
		Greeting hello = new Greeting();
		/*
		 * ����
		 * 1. �ʵ� -> �� �Ҵ�
		 * 2. �޼ҵ� -> �޼ҵ带 ȣ��
		 */
		hello.who = "�����ο�~~";
		hello.greet = "������ �ð��Դϴ�~~~ �������̾��";
		
		hello.sayHello();
	}
}
