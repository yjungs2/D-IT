package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.Car;
import com.service.spring.domain.UserInfo;

public interface CarDAO {
	int insert(Car car); // 등록
	int delete(List<String> list); // 삭제
	Car select(Car car); // 하나 조회
	List<Car> select(); // 전체 조회
	void update(Car car); // 수정
	void registerMember(UserInfo user); // 회원가입
	UserInfo select(UserInfo user); // 로그인
	void logout(); // 로그아웃
}