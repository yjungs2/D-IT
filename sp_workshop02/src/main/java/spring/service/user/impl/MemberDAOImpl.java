package spring.service.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;

public class MemberDAOImpl implements MemberDAO{
	private SqlSession sqlSession; // 필드 선언
	public static final String MAPPER_NAME = "MemberMapper.";
	
	public void setSqlSession(SqlSession sqlSession) {  // 주입 - setter
		System.out.println("::"+getClass().getName()+".setSqlSession() Call...");
		this.sqlSession = sqlSession;
	}

	@Override
	public int registerMember(MemberVO member) throws Exception {
		int result = sqlSession.insert(MAPPER_NAME+"registerMember",member);
		sqlSession.commit();
		return result;
	}

	@Override
	public int deleteMember(String id) throws Exception {
		int result = sqlSession.delete(MAPPER_NAME+"deleteMember",id);
		sqlSession.commit();
		return result;
	}

	@Override
	public int updateMember(MemberVO member) throws Exception {
		int result = sqlSession.update(MAPPER_NAME+"updateMember",member);
		sqlSession.commit();
		return result;
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		return sqlSession.selectOne(MAPPER_NAME+"getMember", id);
	}

	@Override
	public List<MemberVO> showAllMember(MemberVO member) throws Exception {
		return sqlSession.selectList(MAPPER_NAME+"showAllMember", member);
	}

	@Override
	public boolean idExist(String id) throws Exception {
		if(sqlSession.selectOne(MAPPER_NAME+"idExist", id) != null)
			return true;
		else
			return false;
	}

	@Override
	public MemberVO login(MemberVO member) throws Exception {
		return sqlSession.selectOne(MAPPER_NAME+"login", member);
	}	
}