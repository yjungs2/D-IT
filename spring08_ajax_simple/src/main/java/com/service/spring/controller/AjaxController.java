package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Person;

@Controller
public class AjaxController {
	@RequestMapping("/") // http://127.0.0.1:8888/spring
	public String index() {
		System.out.println("context path request.../...");
		return "redirect:index.jsp"; // redirect : 정적인 문서로 바로 갈 때 사용.
		// 결과 페이지 아니므로 InternalResourceViewResolver와 아무 상관 없음.
		// prefix, suffix와 관련 없음 -> 확장자까지 정확하게 쓰기
	}
	
	@RequestMapping("synchro")
	public String synchro(Model model) {
		System.out.println("context path request.../...");
		model.addAttribute("info", "와~~동기통신이다~~");
		return "synchro_result";
	}
	
	@RequestMapping("asynch")
	public String asynch(Model model) {
		System.out.println("asynch 비동기...request...");
		model.addAttribute("person", new Person("구자경", "산포시"));
		return "JsonView";
	}
}