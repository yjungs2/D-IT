package servlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


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
		// command로 넘어온 값에 따라서 요청을 알 수 있고 요청에 해당하는 메소드를 하나씩 이곳에서 연결시킨다.
		
		String command = request.getParameter("command");
		String path = "index.html";
		
		if(command.equals("register")) {
			path = register(request, response);
		} else if(command.equals("find")) {
			path = find(request, response);
		} else if(command.equals("login")) {
			path = login(request, response);
		} else if(command.equals("showAll")) {
			path = showAll(request, response);
		}
		// 네비게이션
		request.getRequestDispatcher(path).forward(request, response);
	} // doProcess

	public String register(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 요청을 서비스하는 로직을 작성...
		// 이전의 RegisterMemberServlet 서블릿 서비스 안의 내용이 여기에...
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address  = request.getParameter("address");
		
		MemberVO pvo = new MemberVO(id, password, name, address);

		String path = "index.html";
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			request.setAttribute("vo", pvo); // 바인딩
			path = "register_result.jsp";
		} catch (Exception e) {
			
		}
		return path;
	} // register
	
	public String find(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		// 네비게이션이 달라짐
		String path = "find_fail.jsp"; // else는 디폴트 path이므로 따로 설정할 필요 없음
		try {
			MemberVO vo = MemberDAOImpl.getInstance().findByIdMember(id);
			if(vo!=null) {
				request.setAttribute("vo", vo); // 데이터 바인딩(저장)
				path = "find_ok.jsp";
			}
		} catch (Exception e) {
			
		}
		return path;
	} // find
	
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path = "index.html"; // 로그인 실패 시 path를 default로
				
		try {
			// 화면으로부터 값을 받아서 만든 vo : pvo (parameter vo)
			// DB에서 받아서 만든 vo : rvo
			MemberVO rvo = MemberDAOImpl.getInstance().login(id, password);
			
			// 클라이언트가 요청하면 세션은 서버에 자동적으로 만들어지고...개발자는 그걸 받아서 사용
			HttpSession session = request.getSession();
			if(rvo!=null) { // 로그인 성공 시에만 바인딩 진행
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID :: "+session.getId());
				path = "login_result.jsp";
			}
		}catch(Exception e) {
			
		}
		return path;
	} // login
	
	public String showAll(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.html";
		try {
			ArrayList<MemberVO> list = MemberDAOImpl.getInstance().showAllMember();
			
			request.setAttribute("list", list);
			path = "allView.jsp";
		} catch (Exception e) {
			
		}
		return path;
	}// showAll
}