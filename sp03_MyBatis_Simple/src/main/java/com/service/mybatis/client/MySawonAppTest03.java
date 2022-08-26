package com.service.mybatis.client;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

import util.FactoryService;

public class MySawonAppTest03 {

	public static void main(String[] args) throws Exception {
		SqlSessionFactory factory = FactoryService.getFactory();
		
		// 3. SqlSession
		SqlSession session = factory.openSession();
		
		// 5. session 안에 쿼리문 실행하는 기능이 들어있다. (executeUpdate(), executeQuery())
		// 이제는 insert(), delete(), update(), selectOne(), selectList()
		List<MySawon> list = session.selectList("sawonMapper.sawonList");
		for(MySawon vo : list)
			System.out.println(vo);
	}
}