package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegisterServlet() {
        // super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 양방향 한글 처리
		 * 2. 폼 값 받는다
		 * 3. (받은 값을 바탕으로 vo 생성)
		 * 4. DAO 리턴 받는다.
		 * 5. 비즈니스 로직 호출...(반환값 나온다) <- 가장 중요
		 * 6. 페이지 이동 (네비게이션)
		 */
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		
		Member vo = new Member(name, age, address);
		
		// 비즈니스 로직 호출했다 치고...
		
		request.getRequestDispatcher("register_result.jsp").forward(request, response);
	}
}