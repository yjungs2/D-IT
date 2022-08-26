package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.ProductDAOImpl;
import servlet.model.ProductVO;

@WebServlet("/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String expl = request.getParameter("expl");
		
		ProductVO vo = new ProductVO(name, price, expl);
		
		ProductDAOImpl dao = ProductDAOImpl.getInstance();
		try {
			dao.registerProduct(vo);
			request.getRequestDispatcher("register_result.jsp").forward(request, response);
		} catch (SQLException e) {
			
		}
	}
}