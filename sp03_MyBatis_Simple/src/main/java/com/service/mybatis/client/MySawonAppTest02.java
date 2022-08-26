package com.service.mybatis.client;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonAppTest02 {

	public static void main(String[] args) throws Exception {
		// 1. 생략
		// 2. 핵심이 되는 설정문서를 읽어들인다.
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		// 3. SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		// 4. SqlSession
		SqlSession session = factory.openSession();
		
		// 5. session 안에 쿼리문 실행하는 기능이 들어있다. (executeUpdate(), executeQuery())
		// 이제는 insert(), delete(), update(), selectOne(), selectList()
		List<MySawon> list = session.selectList("sawonMapper.sawonList");
		for(MySawon vo : list)
			System.out.println(vo);
	}
}