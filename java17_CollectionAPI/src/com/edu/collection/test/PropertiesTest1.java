package com.edu.collection.test;

import java.util.Enumeration;
import java.util.Properties;

// VM 관련 환경변수들을 다 출력하는 로직을 작성
public class PropertiesTest1 {
	public static void main(String[] args) {
		// 다 출력하려면 조건이 없어야 하므로 인자값이 없는 걸 사용
		Properties p = System.getProperties();
		
		Enumeration e = p.propertyNames();
		while(e.hasMoreElements()) {
			String name = (String)e.nextElement();
			String value = p.getProperty(name);
			System.out.println(name+"=============="+value);
		}
	}
}
