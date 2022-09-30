package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Product;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.ProductDAO;

@Repository
public class ProductDAOImpl implements ProductDAO{
	private final String NS = "sql.product.mapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(Product product) {
		return sqlSession.insert(NS+"insert", product);
	}

	@Override
	public int delete(List<String> list) {
		return sqlSession.delete(NS+"delete", list);
	}

	@Override
	public Product select(Product product) {
		return sqlSession.selectOne(NS+"select", product);
	}

	@Override
	public List<Product> select() {
		System.out.println("dao select()...");
		return sqlSession.selectList(NS+"select",null);
	}

	/*@Override
	public void update(Product product) {
		sqlSession.update(NS+"update", car);
	}*/

	@Override
	public UserInfo select(UserInfo user) {
		System.out.println("dao..."+user);
		return sqlSession.selectOne(NS+"selectUser",user);
	}

	@Override
	public void logout() {
		//
	}

	/*@Override
	public void registerMember(UserInfo user) {
		sqlSession.insert(NS+"registerMember", user);
	}*/
}
