package com.service.spring;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.service.spring.domain.Product;
import com.service.spring.model.ProductDAO;

@SpringBootTest
class Spring14Prac2ApplicationTests {
	
	//@Autowired
	//private MemberDAO dao;

	@Test
	void contextLoads() {
		//Member member = new Member("222222", "김부산2", "개발팀");
		//int result = dao.update(member);
		
		//System.out.println(result);
	}

}
