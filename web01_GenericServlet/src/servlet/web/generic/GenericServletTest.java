package servlet.web.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// Servlet의 성질을 가지려면 상속 받기
public class GenericServletTest extends GenericServlet{

	// 클라이언트의 요청이 웹 서버를 거쳐서 컨테이너 아래로 내려오면
	// 이때 클라이언트의 요청을 받아서 처리하는 기능은 service() 메소드이다.
	// = 클라이언트의 요청이 컨테이너에 전해지면 내부적으로 service() 가 호출된다.
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// 인자 두 개 req, res
		// 클라이언트의 요청을 처리하는 로직이 여기서 작성...요청을 처리했다치고...
		PrintWriter out = res.getWriter();
		// println : 콘솔이 아닌 브라우저로 출력하는 기능... 그래서 html 태그를 안에다 넣어야 한다.
		out.println("<html><body bgcolor=cyan>");
		out.println("<h2>Hello GenericServlet~!</h2>");
		out.println("<h3>Deployment Discriptor</h3>");
		out.println("</body></html>");
		out.close(); // 닫아줘야 함
	}

}

// http://127.0.0.1:8888/web02_GenericServlet/GenericServletTest
// 저장하는 순간 컴파일 -> 서버 배포 -> 서버 가동 -> 요청 -> 요청 결과 웹 브라우저에 띄어줌
// http://localhost:8888/web01_GenericServlet/servlet/servlet.web.generic.GenericServletTest
// servlet -> 가상
// 에러 : 서버가 자바(GenericServlet)를 못 찾음
// container는 xml 밖에 인식을 못 함
