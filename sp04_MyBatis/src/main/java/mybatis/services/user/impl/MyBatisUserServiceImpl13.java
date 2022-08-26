package mybatis.services.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;
import mybatis.services.user.UserService;

@Service
public class MyBatisUserServiceImpl13 implements UserService{
	@Autowired
	private UserDAO userDAO; // 필드 선언
	
	// setter 주입 생략
	
	@Override
	public void addUser(User user) throws Exception {
		userDAO.addUser(user); // Impl10의 addUser 호출
	}
	@Override
	public void updateUser(User user) throws Exception {
		userDAO.updateUser(user);
	}
	@Override
	public User getUser(String userId) throws Exception {
		return userDAO.getUser(userId);
	}
	@Override
	public List<User> getUserList(User user) throws Exception {
		return userDAO.getUserList(user);
	}
}