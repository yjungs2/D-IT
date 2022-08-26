package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


@WebServlet("/Find")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성
		/*
		 * 1. 폼 값
		 * 2. DAO
		 * 3. findByIdMember()
		 * 4. vo
		 * 5. -> find_ok.jsp에서는 vo 불러옴
		 */
		
		String id = request.getParameter("id");
		
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		// 네비게이션이 달라짐
		String path = "find_fail.jsp"; // else는 디폴트 path이므로 따로 설정할 필요 없음
		try {
			MemberVO vo = dao.findByIdMember(id);
			// request.getRequestDispatcher("find_result.jsp?name="+vo.getName()).forward(request, response);
			if(vo!=null) {
				request.setAttribute("vo", vo); // 데이터 바인딩(저장)
				path = "find_ok.jsp";
			}
		} catch (SQLException e) {
			
		}
		// 네비게이션
		request.getRequestDispatcher(path).forward(request, response);
	}
}