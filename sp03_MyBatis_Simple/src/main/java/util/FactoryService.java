package util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//SqlSessionFactory 까지 받아오는 로직을 여기서 작성...
public class FactoryService {
	
	private static SqlSessionFactory factory;
	static {
		try {
			// 1. 핵심이 되는 설정문서를 읽어들인다.
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			// 2. SqlSessionFactory
			factory = new SqlSessionFactoryBuilder().build(r);
		} catch (IOException e) {
			System.out.println(e);
		}
	} // static
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
