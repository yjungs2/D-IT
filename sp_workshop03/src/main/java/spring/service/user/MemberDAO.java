package spring.service.user;

import java.util.List;

import spring.service.domain.MemberVO;

public interface MemberDAO {
	int registerMember(MemberVO member) throws Exception;
	int deleteMember(String id) throws Exception;
	int updateMember(MemberVO member) throws Exception;
	
	MemberVO getMember(String id) throws Exception;
	List<MemberVO> showAllMember(MemberVO member) throws Exception;
	
	boolean idExist(String id) throws Exception;
	MemberVO login(MemberVO member) throws Exception;
}