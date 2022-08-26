package spring.service.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import spring.service.domain.MemberVO;
import spring.service.user.impl.MemberDAOImpl;

/*
 * FileName : MyBatisMemberTestApp102.java
  * ㅇ SqlMapConfig.xml / mybatis-memberservice-mapping.xml
  * ㅇ MemberDAOImpl
  * ㅇ TestUtil.java 을 이용 Test . 
  * ㅇ Persistance Logic Layer 단위 Test..여기서 에러난다고해도 mybatis-memberservice-mapping.xml는 볼 필요없다.
  *   ::Persistence Layer의 단위테스트 마무리
  */
public class MyBatisMemberTestApp102 {
	///Main method
	public static void main(String[] args) throws Exception{

		SqlSession session = null;
		//==> TestUtil 의 getSqlSessionFactory()을 이용 SqlSessionFactory instance GET
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		session=factory.openSession();
		
		//==> MyBatisUserDAOImpl10 생성 및 sqlMapClient 객체 setter injection
		MemberDAOImpl dao = new MemberDAOImpl();
		dao.setSqlSession(session);
		
		//==> Test 용 User instance 생성  
		MemberVO member = new MemberVO("ididid","pwpwpw","이름01","주소01");
			
		//1. MemberDAOImpl.registerMember Test  
		System.out.println(":: 1. MemberMapper.registerMember(INSERT)  ? "	+ dao.registerMember(member) );
		
		//2. MemberDAOImpl.getMember Test :: 주몽 inert 확인 
		System.out.println(":: 2. MemberMapper.getUser(SELECT)  ? \n " + dao.getMember(member.getId()) );

		//3. MemberDAOImpl.updateMemberTest  
		//                                                    :: 주몽 ==> 온달 수정
		member.setName("이름02");
		System.out.println(":: 3. MemberMapper.update(UPDATE)  ? "+dao.updateMember(member) );
		
		//4. MemberDAOImpl.showAllMember Test
		System.out.println(":: 4. MemberMapper.showAllMember(SELECT)  ? ");
		TestUtil.printList( dao.showAllMember(member) );
		
		//5. MemberDAOImpl.deleteMember Test
		//System.out.println(":: 5. MemberMapper.Use10.deleteMember (DELETE)  ? "
		//													+dao.deleteMember(member.getId()) );
		
		//6. MemberDAOImpl.showAllMember Test 
		System.out.println(":: 6. MemberMapper.showAllMember(SELECT)  ? ");
		TestUtil.printList( dao.showAllMember(member) );
		
		//7. MemberDAOImpl.showAllMember Test 
		//member.setId(null);
		//member.setName(null);
		System.out.println(":: 7. MemberMapper.showAllMember(SELECT)  ? ");
		TestUtil.printList( dao.showAllMember(member) );
		
		//8. MemberDAOImpl.idExist Test
		System.out.println(":: 8.MemberMapper.idExist(SELECT) ? " + dao.idExist(member.getId()));
		
		//9. MemberDAOImpl.login Test
		System.out.println(":: 9.MemberMapper.login(SELECT) ? " + dao.login(member));
		
	}//end of main
}//end of class