package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.Product;
import com.service.spring.domain.UserInfo;

public interface ProductDAO {
	int insert(Product product); // 등록
	int delete(List<String> list); // 삭제
	Product select(Product product); // 하나 조회
	List<Product> select(); // 전체 조회
	//void update(Product product); // 수정
	//void registerMember(UserInfo user); // 회원가입
	UserInfo select(UserInfo user); // 로그인
	void logout(); // 로그아웃
}