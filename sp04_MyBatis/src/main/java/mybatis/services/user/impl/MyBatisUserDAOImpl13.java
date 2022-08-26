/*
 * 					 Layer
 * Presentation					Business Logic
 * 		|							   |
 * 	Controller				 Service			Persistence
 * 		|				  	    |					|
 * 	~~Controller			UserService			 UserDAO
 * 				  				|					|
 * 				MyBatisUserServiceImpl12	  MyBatisUserDAOImpl13
 * 
 * @Component : ~~Controller / MyBatisUserServiceImpl12 / MyBatisUserDAOImpl13
 * Presentation Layer에 있는 Component : @Controller
 * Service Layer에 있는 Component : @Service
 * Persistence Layer에 있는 Component : @Repository
 */
package mybatis.services.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;

@Repository
public class MyBatisUserDAOImpl13 implements UserDAO{
	
	@Autowired
	private SqlSession sqlSession; // 필드 선언
	public static final String MAPPER_NAME = "UserMapper10.";

	// setter 주입 생략
	
	@Override
	public int addUser(User user) throws Exception {
		int result = sqlSession.insert(MAPPER_NAME+"addUser",user);
		//sqlSession.commit();
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result = sqlSession.update(MAPPER_NAME+"updateUser",user);
		//sqlSession.commit();
		return result;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int result = sqlSession.delete(MAPPER_NAME+"removeUser",userId);
		//sqlSession.commit();
		return result;
	}

	@Override
	public User getUser(String userId) throws Exception {
		return sqlSession.selectOne(MAPPER_NAME+"getUser", userId);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		return sqlSession.selectList(MAPPER_NAME+"getUserList", user);
	}
}