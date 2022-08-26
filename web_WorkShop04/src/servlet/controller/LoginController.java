package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.User;
import servlet.model.UserDAOImpl;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("userId");
		String password = request.getParameter("password");
		String path = "error.jsp";
		
		try {
			User rvo = UserDAOImpl.getInstance().login(id, password);

			HttpSession session = request.getSession();

			if (rvo != null) {
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID: " + session.getId());
				path = "loginSuccess.jsp";
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return new ModelAndView(path, true);
	} // login
}