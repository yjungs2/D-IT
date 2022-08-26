package com.service.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.PhoneService;

@Controller
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;
	
	@GetMapping("regPhone.do")
	public String getRegPhone(Model model) {
		model.addAttribute("title", "핸드폰 관리 - 핸드폰 등록 폼");
		return "PhoneReg";
	}
	
	@PostMapping("savePhone.do")
	public String doRegPhone(Phone phone, Model model) {
		try {
			// 성공 페이지
			phoneService.insert(phone);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 저장 성공");
			return "Result";
		}catch(Exception e) {
			// 에러 페이지
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 저장 에러");
			return "Error";
		}
	}
	
	@GetMapping("searchPhone.do")
	public String doList(Model model) {
		try {
			List<Phone> list = phoneService.select();
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 리스트");
			model.addAttribute("phone", list);
			return "PhoneList";
		} catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 에러");
			model.addAttribute("message", "문제 내용 - 폰 목록 조회 중 에러 발생");
			return "Error";
		}
	}
	
	@GetMapping("detail.do")
	public String doDetail(Phone phone, Model model) {
		try {
			Phone selected = phoneService.select(phone);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 상세 조회");
			model.addAttribute("phone", selected);
			return "PhoneView";
		} catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 상세 조회 중 에러 발생");
			return "Error";
		}
	}
	
	@PostMapping("deleteAjax.do")
	public String doAjaxDelete(@RequestParam List<String> num, Model model) {
		List<String> temp = new ArrayList<String>();
		try {
			for(String n : num) temp.add(n);
			
			phoneService.delete(temp);
			return "JsonView";
		}catch(Exception e){
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "문제 내용 - 폰 삭제  중 에러 발생");
			return "Error";
		}
	}
	
	// 로그인
	@GetMapping("login.do")
	public String getLoginForm() {
		return "Login";
	}
	
	@PostMapping("login.do")
	public String doLogin(UserInfo user, Model model, HttpSession session) { 
		// 로그인, 업데이트는 세션에 바인딩하기 or request.getSession
		try {
			UserInfo selected = phoneService.select(user);
			if(selected!=null) { // 아이디 비번 일치하는 게 있는 경우
				session.setAttribute("loginUser", selected);
				return "redirect:searchPhone.do";
			}else {
				return "Login";
			}
		}catch(Exception e){
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "문제 내용 - 회원 로그인  중 에러 발생");
			return "Error";
		}
	}
}