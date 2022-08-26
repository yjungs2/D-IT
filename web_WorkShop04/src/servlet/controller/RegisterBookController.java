package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Book;
import servlet.model.BookDAOImpl;

public class RegisterBookController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String[] bookNoList = request.getParameterValues("bookNo");
		String isbn = "";
		for(int i=0; i<bookNoList.length; i++) {
			if(i==bookNoList.length-1) {
				isbn += bookNoList[i];
			} else {
				isbn += bookNoList[i] + "-";
			}
		}
		String title = request.getParameter("bookTitle");
		String catalogue = request.getParameter("bookCategory");
		String nation = request.getParameter("bookCountry");
		String publish_date = request.getParameter("bookDate");
		String publisher = request.getParameter("bookPublisher");
		String author = request.getParameter("bookAuthor");
		int price = Integer.parseInt(request.getParameter("bookPrice"));
		String description = request.getParameter("bookSummary");
		String path = "book/Book.html";
		
		Book vo2 = new Book(isbn, title, catalogue, nation, publish_date, publisher, author, price, description);
		HttpSession session = request.getSession();
		
		try {
			BookDAOImpl.getInstance().registerBook(vo2);
			session.setAttribute("vo2", vo2);
			path = "book/bookSuccess.jsp";
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return new ModelAndView(path, true);
	}
}