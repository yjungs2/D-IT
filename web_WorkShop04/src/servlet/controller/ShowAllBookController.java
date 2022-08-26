package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;
import servlet.model.BookDAOImpl;

public class ShowAllBookController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "error.jsp";
		// response.sendRedirect("../error.jsp");  // 리다이렉트로 error 페이지로 이동
		
		try {
			ArrayList<Book> list = BookDAOImpl.getInstance().showAllBook();
			request.setAttribute("list", list);
			path = "book/booklist.jsp";
		} catch (SQLException e) {
			System.out.println("Search-All Failed.");
		}
		return new ModelAndView(path);
	}
}