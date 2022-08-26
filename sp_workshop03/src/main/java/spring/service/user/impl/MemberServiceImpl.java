package spring.service.user.impl;

import java.util.List;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;

public class MemberServiceImpl implements MemberService{
	private MemberDAO memberDAO; // 필드 선언

	public void setMemberDAO(MemberDAO memberDAO) { // setter 주입
		this.memberDAO = memberDAO;
	}

	@Override
	public void registerMember(MemberVO member) throws Exception {
		memberDAO.registerMember(member); // MemberDAOImpl의 registerMember 호출
	}

	@Override
	public void updateMember(MemberVO member) throws Exception {
		memberDAO.updateMember(member);
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		return memberDAO.getMember(id);
	}

	@Override
	public List<MemberVO> showAllMember(MemberVO member) throws Exception {
		return memberDAO.showAllMember(member);
	}

	@Override
	public boolean idExist(String id) throws Exception {
		return memberDAO.idExist(id);
	}

	@Override
	public MemberVO login(MemberVO member) throws Exception {
		return memberDAO.login(member);
	}
}