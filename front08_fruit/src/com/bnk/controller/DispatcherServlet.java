package com.bnk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// hidden 값으로 요청을 받지 않고...들어온 요청의 전체주소를 그냥 받는다.
		String requestURI = request.getRequestURI(); // ContextPath/subject.do
		System.out.println("RequestURI : "+requestURI);
		
		String contextPath = request.getContextPath(); // ContextPath
		System.out.println("ContextPath : "+contextPath);
		
		String command = requestURI.substring(contextPath.length()+1);
		System.out.println("Command : "+command);
		
		String path = "index.jsp";
		ModelAndView mv = null;
		
		Controller controller = ControllerFactory.getInstance().createController(command);
		try {
			mv = controller.handleRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(mv!=null) {
			if(mv.isRedirect()) response.sendRedirect(mv.getPath());
			else request.getRequestDispatcher(mv.getPath()).forward(request, response);
		}
	}
}