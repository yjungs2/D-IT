package servlet.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormAjax")
public class FormAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		// 디비 연결...비즈니스 로직 호출했다 치고...
		// 바인딩 했다 치고...
		request.getRequestDispatcher("ajax02_result.jsp").forward(request, response);
	}
}