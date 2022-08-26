package com.edu.collection.test;

import java.util.Set;
import java.util.HashSet;
/* 		Set
 * 		 |
 * 	  HashSet
 * 
 *  Unique한 것들만 저장
 *  순서는 없다
 */
public class HashSetTest2 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("구자경");
		set.add("염미정");
		set.add("강호동");
		set.add("염창희");
		set.add("염미정");

		System.out.println(set.size()); // 3 -> 중복 허용하지 않음
		// Collection은 자체적으로 toString()을 오버라이딩 해놓았다...멤버 출력
		System.out.println(set.toString()); // [강호동, 염미정, 구자경, 염창희] -> 순서 없음
		System.out.println("이수근이 포함되었는지의 여부? "+set.contains("이수근")); // false
		// 삭제되면 true, 삭제 안 되면 false 반환
		System.out.println("삭제 진행 : "+set.remove("강호동")+"!!"); // 삭제 진행 : true!!
		System.out.println(set); // [염미정, 구자경, 염창희] -> 순서 없음
		
		set.clear();
		System.out.println("Set 안이 다 비워졌나요? "+set.isEmpty()); // Set 안이 다 비워졌나요? true
	}
}