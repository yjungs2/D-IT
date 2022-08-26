package web.servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Annotation---> XML
// @WebServlet("/Life2")
public class ServletLifeCycleTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int count=0;
	
    public ServletLifeCycleTest2() { // 서블릿 생성할 때 호출...req, res 사용 못 함
    	System.out.println("1. 서블릿 객체가 생성...컨테이너에 의해서...");
    }

	public void init() throws ServletException {
		System.out.println("2. init 메소드(init())가 호출...컨테이너에 의해서...");
	}

	public void destroy() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성
		System.out.println("3. service() 호출 -> doGet()/doPost() 재호출... 컨테이너에 의해서");
		
		PrintWriter out = response.getWriter();
		
		// 클라이언트의 서비스를 수행...수행 결과 데이터를 jsp페이지로 연결...
		count = 1004;
		// out.println("<a href=life2.jsp?cnt="+count+">life2.jsp로 이동</a>"); // 이름=value get 방식
		
		// 브라우저로 일단 응답을 하지 않고...서버 안에서 바로 jsp로 연결...응답을 jsp가 한다.
		request.getRequestDispatcher("life2.jsp?cnt="+count).forward(request, response);
		out.close();
	}
}