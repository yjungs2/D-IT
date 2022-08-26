package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Member;
import com.service.spring.service.MemberService;



@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("findMember.do")
	public String findMember(Model model, String id) {
		Member vo = memberService.findByIdMember(id);
		model.addAttribute("vo", vo);
		if(vo!=null) return "find_ok";
		else return "find_fail";
	}
	
	@RequestMapping("login.do")
	public ModelAndView login(HttpServletRequest request, String id, String password) {
		Member vo = memberService.login(new Member(id, password));
		HttpSession session = request.getSession();
		if(vo!=null) {
			session.setAttribute("vo", vo);
			return new ModelAndView("login_result");
		}
		return new ModelAndView("redirect:/index.jsp");
	}
	
	@RequestMapping("register.do")
	public ModelAndView register(String id, String password, String name, String address) {
		memberService.registerMember(new Member(id, password, name, address));
		return new ModelAndView("redirect:/index.jsp");
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
			return "logout";
		}
		return null;
	}
	
	@RequestMapping("allMember.do")
	public String allMember(Model model) {
		List<Member> list = memberService.showAllMember();
		model.addAttribute("list", list);
		return "allView";
	}
	
	@RequestMapping("update.do")
	public String update(HttpServletRequest request, String id, String password, String name, String address) {
		Member vo = new Member(id, password, name, address);
		memberService.updateMember(vo);
		HttpSession session = request.getSession();
		
		if(session.getAttribute("vo")!=null) {
			session.setAttribute("vo", vo); 
		}
		return "update_result";
	}
	
	@RequestMapping("idExist.do")
	public String idExist(Model model, String id) {
		String idExist = memberService.idExist(id);
		boolean check = false;
		if(idExist!=null) check = true;
		model.addAttribute("check", check);
		return "JsonView"; // servlet-context.xml의 JsonView와 연결
	}
}