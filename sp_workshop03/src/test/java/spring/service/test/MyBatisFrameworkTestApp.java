package spring.service.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import spring.service.domain.MemberVO;

/*
 * FileName : MyBatisMemberTestApp.java
  * ㅇ SqlMapConfig.xml / mybatis-memberservice-mapping.xml
  * ㅇ TestUtil.java 을 이용 Test . 
  * ㅇ 이거 돌아가면 MyBatis Framework 단위테스트는 잘 된거다...mybatis-userservice-mapping10.xml은 문제 없다.
  */
public class MyBatisFrameworkTestApp {
	///Main method
	public static void main(String[] args) throws Exception{
		
		SqlSession session = null;
		//==> TestUtil 의 getSqlSessionFactory()을 이용 SqlSessionFactory instance GET
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		session=factory.openSession();
		
		//==> Test용 Member instance 생성  
		MemberVO member = new MemberVO("ididid","pwpwpw","이름01","주소01");
		
		//1. MemberMapper.registerMember Test  :: member table password/name/address 입력값 확인할것 : OK 
		System.out.println(":: 1. registerMember(INSERT)  ? "
													+ session.insert("MemberMapper.registerMember",member)); //1
													  session.commit();
		//2. MemberMapper.getMember Test :: 이름01 insert 확인 
		System.out.println(":: 2. getMember(SELECT)  ? ");
		System.out.println(" :: "+session.selectOne("MemberMapper.getMember",member.getId()) );
		
		
		//3. MemberMapper.updateMember Test  :: members table password/name/address 입력값 확인할것 : OK
		member.setName("이름02");
		System.out.println(":: 3. update(UPDATE)  ? "
													+ session.update("MemberMapper.updateMember",member));//1
											  		  session.commit();
		
		//4. MemberMapper.showAllMember Test  :: id=ididid/name=이름01 검색
		System.out.println(":: 4. showAllMember(SELECT)  ? ");
		TestUtil.printList( (List)session.selectList("MemberMapper.showAllMember",member) );
		
		//5. MemberMapper.deleteMember Test
		/*System.out.println(":: 5. Use10.deleteMember (DELETE)  ? "
								+session.delete("MemberMapper.deleteMember",member.getId()) );//1
								 session.commit();*/
		
		//6. MemberMapper.showAllMember Test  :: id=ididid/name=이름01 검색
		System.out.println(":: 6. showAllMember(SELECT)  ? ");
		TestUtil.printList((List) session.selectList("MemberMapper.showAllMember",member) ); //이때 위의 기능 리턴타입이 0인걸 확인하자
	
		//7. MemberMapper.showAllMember Test  :: id=null/name=null 인경우
		/*member.setId(null);
		member.setName(null);
		System.out.println(":: 7. showAllMember(SELECT)  ? ");
		TestUtil.printList( (List) session.selectList("MemberMapper.showAllMember",member) );
		*/
		//8. MemberMapper.idExist Test
		System.out.println(":: 8.idExist(SELECT) ? " + session.selectOne("MemberMapper.idExist", member.getId()) );
		
		//9. MemberMapper.login Test
		System.out.println(":: 9.login(SELECT) ? " + session.selectOne("MemberMapper.login", member) );
	}//end of main
}//end of class