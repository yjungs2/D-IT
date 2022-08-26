package com.service.spring.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.MyProduct;

@Repository
public class MyProductDAOImpl implements MyProductDAO{
	
	public final static String NS = "ns.sql.MyProductMapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int addProduct(MyProduct vo) throws Exception {
		int result = sqlSession.insert(NS+"addProduct",vo);
		return result;
	}

	@Override
	public List<MyProduct> findProductByName(String name) throws Exception {
		return sqlSession.selectList(NS+"findProductByName", name);
	}

	@Override
	public List<MyProduct> findProductByMaker(String maker) throws Exception {
		return sqlSession.selectList(NS+"findProductByMaker", maker);
	}

	@Override
	public List<MyProduct> findProducts() throws Exception {
		return sqlSession.selectList(NS+"findProducts");
	}
}