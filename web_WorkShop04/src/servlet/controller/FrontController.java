package servlet.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.UserDAOImpl;
import servlet.model.UserDAO;
import servlet.model.BookDAOImpl;
import servlet.model.BookDAO;

@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		Controller controller = ControllerFactory.getInstance().createController(command);
		ModelAndView mv = controller.handleRequest(request, response);
		
		if(mv!=null) {
			if(mv.isRedirect()) {
				response.sendRedirect(mv.getPath()); // true --> redirect
				System.out.println(mv.isRedirect());
			}
			else {
				request.getRequestDispatcher(mv.getPath()).forward(request, response); // false --> forward
				System.out.println(mv.isRedirect());
			}
		}
	}
}