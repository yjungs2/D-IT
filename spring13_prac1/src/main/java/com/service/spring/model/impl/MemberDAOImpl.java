package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Member;
import com.service.spring.model.MemberDAO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	private final String NS = "sql.emp.mapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(Member member) {
		return sqlSession.insert(NS+"insert", member);
	}

	@Override
	public int delete(List<String> list) {
		return sqlSession.delete(NS+"delete", list);
	}

	@Override
	public Member select(Member member) {
		return sqlSession.selectOne(NS+"select", member);
	}

	@Override
	public List<Member> select() {
		System.out.println("dao select()...");
		return sqlSession.selectList(NS+"select",null);
	}

	@Override
	public void update(Member member) {
		sqlSession.update(NS+"update", member);
	}
}
