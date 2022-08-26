package com.service.spring.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.MyProduct;

public class MyBatisFrameworkJUnitTest2 {
	
	@Test
	public void unit() throws Exception{
		// 1. 설정 문서를 DIContainer가 읽어들여야 한다.
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		// 2. r을 SqlSessionFactory에서
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
	
		// 3. SqlSession
		SqlSession session = factory.openSession();
		
		System.out.println("===== 1. addProduct =====");
		
		//MyProduct vo = new MyProduct("통돌이 세탁기", "대우", 500000);
		//MyProduct vo = new MyProduct("드럼 세탁기", "대우", 530000);
		MyProduct vo = new MyProduct("공기방울 세탁기", "삼성", 380000);
		int result = session.insert("ns.sql.MyProductMapper.addProduct", vo);
		
		// 단위테스트에서는 commit 해줘야 함
		session.commit(); // 반드시 잊지 말자!
		System.out.println(result+" 개 상품 추가 성공^^");
	}
}