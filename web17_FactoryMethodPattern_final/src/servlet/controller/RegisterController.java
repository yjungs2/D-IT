package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class RegisterController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 요청을 서비스하는 로직을 작성...
		// 이전의 RegisterMemberServlet 서블릿 서비스 안의 내용이 여기에...
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address  = request.getParameter("address");
		
		MemberVO pvo = new MemberVO(id, password, name, address);

		String path = "index.jsp";
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			request.setAttribute("vo", pvo); // 바인딩
			path = "register_result.jsp";
		} catch (Exception e) {
			
		}
		return new ModelAndView(path, true);
	} // register
}