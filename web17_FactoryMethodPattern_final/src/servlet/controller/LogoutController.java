package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		// session을 죽이는 로직...세션이 있을 때만(로그인 되어 있을 때만)
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("vo")!=null) { // 로그인이 되어져 있다면
				session.invalidate(); // 세션을 죽인다 = 세션을 unbind 시킴
				path = "logout.jsp";
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(path);
	} // logout
}
