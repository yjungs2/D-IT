package web.servlet.config;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/GreetingServletConfig")
public class GreetingServletConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 필드 선언
	private String greet = "";
	private String name = ""; 

    public GreetingServletConfig() {
    	System.out.println("1. 서블릿 객체 생성...");
    }

    public void init() throws ServletException {
		// 요청이 들어오기 전에 서블릿을 초기화해놓고 요청을 받는 용도
		// getInitParameter() <- 물려받아 가지고 있기 때문에 그냥 쓰면 됨
		System.out.println("2. ServletConfig 객체 생성...init 호출...");
		
		greet = getInitParameter("GREET");
		System.out.println("Greeting Message :: "+greet);
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성
		// 클라이언트가 요청할 때, 폼 값을 받아오는 request.getParameter()
		System.out.println("3. doPost 호출. 요청 시마다 계속 호출...");
		
		name = request.getParameter("userName");
		
		// 페이지 이동
		RequestDispatcher rdp = request.getRequestDispatcher("result.jsp?message="+greet);
		rdp.forward(request, response); // 실질적으로 페이지가 이동한다.
	}
}