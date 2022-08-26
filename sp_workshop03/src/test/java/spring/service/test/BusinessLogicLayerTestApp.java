package spring.service.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;

public class BusinessLogicLayerTestApp {
	///Main method
	public static void main(String[] args) throws Exception{
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"/bean/memberservice.xml"} );
		
		MemberService memberService = (MemberService)context.getBean("memberServiceImpl");
		
//		// MemberDAOImpl
//		MemberDAOImpl dao = new MemberDAOImpl();
//		dao.setSqlSession(session);
//		// MemberServiceImpl
//		MemberServiceImpl memberService = new MemberServiceImpl();
//		memberService.setMemberDAO(dao);
		
		//==> Test용 Member instance 생성  
		MemberVO member = new MemberVO("ididid","pwpwpw","이름01","주소01");
		
		//1. MemberMapper.registerMember Test  :: member table password/name/address 입력값 확인할것 : OK 
		System.out.println(":: 1. registerMember(INSERT)  ? ");
		memberService.registerMember(member);
		
		//2. MemberMapper.getMember Test :: 이름01 insert 확인 
		member = memberService.getMember("ididid");
		System.out.println(":: 2. getMember(SELECT)  ? " + member);
	
		//3. MemberMapper.updateMember Test  :: members table password/name/address 입력값 확인할것 : OK
		member.setName("이름02");
		System.out.println(":: 3. update(UPDATE)  ? ");
		memberService.updateMember(member);
		
		//4. MemberMapper.showAllMember Test  :: id=ididid/name=이름01 검색
		System.out.println(":: 4. showAllMember(SELECT)  ? ");
		TestUtil.printList( memberService.showAllMember(member) );
		
		/*//5. MemberMapper.deleteMember Test
		MemberDAO memberDAO = (MemberDAO)context.getBean("memberDAOImpl");
		System.out.println(":: 5. Use10.deleteMember (DELETE)  ? "
								+memberDAO.deleteMember("ididid") );//1*/
		
		//6. MemberMapper.showAllMember Test  :: id=ididid/name=이름01 검색
		System.out.println(":: 6. showAllMember(SELECT)  ? ");
		TestUtil.printList( memberService.showAllMember(member) ); //이때 위의 기능 리턴타입이 0인걸 확인하자
	
		/*//7. MemberMapper.showAllMember Test  :: id=null/name=null 인경우
		member.setId(null);
		member.setName(null);
		System.out.println(":: 7. showAllMember(SELECT)  ? ");
		TestUtil.printList( memberService.showAllMember(member) );*/
		
		//8. MemberMapper.idExist Test
		System.out.println(":: 8.idExist(SELECT) ? " + memberService.idExist(member.getId()));
		
		//9. MemberMapper.login Test
		System.out.println(":: 9.login(SELECT) ? " + memberService.login(member));
	}//end of main
}//end of class