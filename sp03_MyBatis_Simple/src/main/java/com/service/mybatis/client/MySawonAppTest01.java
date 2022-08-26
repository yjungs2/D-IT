package com.service.mybatis.client;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonAppTest01 {

	public static void main(String[] args) throws Exception {
		// 1. 폼으로부터 받은 값을 가지고 vo 생성...
		MySawon vo = new MySawon();
		vo.setId("aaa"); // "bnk"
		vo.setPwd("777"); // "1234"
		vo.setName("아이유"); // "염미정"
		vo.setAge(28);
		
		// 2. 지금부터...핵심이 되는 설정문서를 읽어들인다.
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		// 3. new SqlSessionFactoryBuilder()
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		// 4. SqlSession
		SqlSession session = factory.openSession();
		
		// 5. session 안에 쿼리문 실행하는 기능이 들어있다. (executeUpdate(), executeQuery())
		// 이제는 insert(), delete(), update(), selectOne(), selectList()
		session.insert("sawonMapper.sawonAdd", vo);
		session.commit();
		session.close();
		
		System.out.println(vo.getName()+"님이 등록되셨습니다.");
	}
}