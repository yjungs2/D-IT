package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	
	// 폼에 입력된 값이 Controller로 넘어올 때 자동으로 바인딩 됨
	@RequestMapping("form.do")
	public ModelAndView form(HttpServletRequest request, String name, String addr) {
		/*
		 * 1. 폼 값 받아서
		 * 2. VO 생성
		 * 3. Service 받아와서
		 * 4. service.register(); --> dao.register(); sqlSession.insert("mapper.addRegister")
		 * 5. ModelAndView 생성
		 */
		//String name = request.getParameter("name");
		//String addr = request.getParameter("addr");
		
		return new ModelAndView("WEB-INF/views/form_result.jsp", "info", name+"님이 사는 곳은 "+addr);
		// "form_result" :: 결과 페이지 이름 -> 1.form_result.jsp 2.WEB-INF>views>
		// -> WEB-INF/views/form_result.jsp
		// -> WEB-INF/views : prefix(저장되는 물리적 위치), .jsp : suffix(결과페이지의 확장자)(InternalResourceViewResolver에서 이런 내용 다룸)
		// "info" : Request 객체에 바인딩된 이름
		// name+"님이 사는 곳은 "+addr : info라는 이름으로 바인딩된 객체. ${info}
	}	
}