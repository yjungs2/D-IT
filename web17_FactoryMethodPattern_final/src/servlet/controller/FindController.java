package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		// 네비게이션이 달라짐
		String path = "find_fail.jsp"; // else는 디폴트 path이므로 따로 설정할 필요 없음
		try {
			MemberVO vo = MemberDAOImpl.getInstance().findByIdMember(id);
			if(vo!=null) {
				request.setAttribute("vo", vo); // 데이터 바인딩(저장)
				path = "find_ok.jsp";
			}
		} catch (Exception e) {
			
		}
		return new ModelAndView(path); // path만 넣는다는 건 isRedirect가 false이므로 forward
	} // find
}