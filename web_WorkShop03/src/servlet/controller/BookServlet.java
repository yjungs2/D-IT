package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Book;
import servlet.model.BookDAOImpl;


@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성
		String[] isbns = request.getParameterValues("bookNo");
		String title = request.getParameter("bookTitle");
		String catalogue = request.getParameter("bookCategory");
		String nation = request.getParameter("bookCountry");
		String publish_date = request.getParameter("bookDate");
		String publisher = request.getParameter("bookPublisher");
		String author = request.getParameter("bookAuthor");
		int price = Integer.parseInt(request.getParameter("bookPrice"));
		String description = request.getParameter("bookSummary");
		
		String isbn = isbns[0]+"-"+isbns[1]+"-"+isbns[2];
		Book vo = new Book(isbn, title, catalogue, nation, publish_date, publisher, author, price, description);
		
		BookDAOImpl dao = BookDAOImpl.getInstance();
		HttpSession session = request.getSession();
		try {
			dao.registerBook(vo);
			session.setAttribute("vo", vo);
		} catch(SQLException e) {
			
		}
		request.getRequestDispatcher("book/bookSuccess.jsp").forward(request, response);
	}
}
