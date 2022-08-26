package web.servlet.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 필드 선언
	private String ms = "";
	private String id = "";
	private String pw = "";

    public MainServlet() {
        System.out.println("1. 서블릿 객체 생성...");
    }

	public void init() throws ServletException {
		System.out.println("2. ServletConfig 객체 생성...init 호출...");
		
		ms = getInitParameter("MESSAGE");
		System.out.println("Login Message :: "+ms);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성
		// 요청 시 한글 처리
		request.setCharacterEncoding("utf-8");
		// 응답 시 한글 처리
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("3. doPost 호출. 요청 시마다 계속 호출...");
		
		id = request.getParameter("id");
		pw = request.getParameter("password");
		
		if(id.equals("bnk") && pw.equals("1234")) {
			RequestDispatcher rdp1 = request.getRequestDispatcher("LoginSuccess.jsp?message="+ms);
			rdp1.forward(request, response);
		}
		else {
			RequestDispatcher rdp2 = request.getRequestDispatcher("LoginError.jsp?message="+ms);
			rdp2.forward(request, response);
		}
	}
}