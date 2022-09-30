package com.service.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.Member;
import com.service.spring.model.MemberDAO;
import com.service.spring.model.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public int insert(Member member) {
		return memberDAO.insert(member);
	}

	@Override
	public int delete(List<String> list) {
		return memberDAO.delete(list);
	}

	@Override
	public Member select(Member member) {
		return memberDAO.select(member);
	}

	@Override
	public List<Member> select() {
		System.out.println("service select()...");
		return memberDAO.select();
	}

	@Override
	public void update(Member member) {
		memberDAO.update(member);
	}
}
