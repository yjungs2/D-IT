package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Car;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.CarDAO;

@Repository
public class CarDAOImpl implements CarDAO{
	private final String NS = "sql.car.mapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(Car car) {
		return sqlSession.insert(NS+"insert", car);
	}

	@Override
	public int delete(List<String> list) {
		return sqlSession.delete(NS+"delete", list);
	}

	@Override
	public Car select(Car car) {
		return sqlSession.selectOne(NS+"select", car);
	}

	@Override
	public List<Car> select() {
		System.out.println("dao select()...");
		return sqlSession.selectList(NS+"select",null);
	}

	@Override
	public void update(Car car) {
		sqlSession.update(NS+"update", car);
	}

	@Override
	public UserInfo select(UserInfo user) {
		System.out.println("dao..."+user);
		return sqlSession.selectOne(NS+"selectUser",user);
	}

	@Override
	public void logout() {
		//
	}

	@Override
	public void registerMember(UserInfo user) {
		sqlSession.insert(NS+"registerMember", user);
	}
}
