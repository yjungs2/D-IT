package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.Member;

public interface MemberService {
	int insert(Member member);
	int delete(List<String> list);
	Member select(Member member);
	List<Member> select();
	void update(Member member);
}
