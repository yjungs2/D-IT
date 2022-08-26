package com.edu.collection.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* 		Map
 * 		 |
 * 	  HashMap (Key-Value)
 * 		 |
 * 	 Properties (String Key - String Value)
 *  이후에 메타데이터로서 활용한다.
 *  
 *  Collection 계보를 잇는 객체가 아니기 때문에
 *  
 * 1. key들을 다 set에 모음 (key는 unique하므로)
 * 2. key에 연결된 value를 뽑음
 */
public class HashMapTest4 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>(); // int는 기본형, Integer 사용
		map.put("강호동", 90);
		map.put("이수근", 80);
		map.put("김영철", 85);
		map.put("서장훈", 95);
		map.put("김희철", 80);
		
		// 1. map에 담겨져 있는 모든 키값을 받아온다...KeySet()...Set
		Set<String> set = map.keySet();
		// 2. Set에 담겨진 Key들을 출력...
		for(String s : set) System.out.println(s); // 서장훈\n강호동\n김영철\n이수근\n김희철
		// 3. Key에 연결된 사람들의 성적을 받아와서 총점을 출력
		int total = 0;
		for(String name : set) {
			int score = map.get(name);
			total += score;
		}
		System.out.println(total+"점"); // 430점
		// 4. map에 저장된 사람들의 평균 점수를 출력
		System.out.println("평균 : "+total/set.size()); // 평균 : 86
	}
}