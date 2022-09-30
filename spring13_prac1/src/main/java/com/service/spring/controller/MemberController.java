package com.service.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Member;
import com.service.spring.model.MemberService;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:index.jsp";
	}
	
	@GetMapping("regMember.do")
	public String getRegMember(Model model) {
		model.addAttribute("title", "사원 관리 - 사원 등록");
		return "MemberReg";
	}
	
	@PostMapping("saveMember.do")
	public String doRegPhone(Member member, Model model) {
		try {
			// 성공 페이지
			memberService.insert(member);
			model.addAttribute("message", " : 입사 축하!!");
			return "Result";
		}catch(Exception e) {
			// 에러 페이지
			model.addAttribute("title", "사원 입력 중 문제 발생");
			return "Error";
		}
	}
	
	@GetMapping("searchMember.do")
	public String doList(Model model) {
		try {
			List<Member> list = memberService.select();
			model.addAttribute("title", "사원 관리 - 리스트");
			model.addAttribute("member", list);
			return "MemberList";
		} catch(Exception e) {
			model.addAttribute("title", "사원 목록 조회 중 에러 발생");
			return "Error";
		}
	}
	
	@GetMapping("detail.do")
	public String doDetail(Member member, Model model) {
		try {
			Member selected = memberService.select(member);
			model.addAttribute("title", "사원 관리 - 사원 상세 정보");
			model.addAttribute("member", selected);
			return "MemberView";
		} catch(Exception e) {
			model.addAttribute("title", "사원 상세 조회 중 에러 발생");
			return "Error";
		}
	}
	
	@GetMapping("deleteAjax.do")
	public String doAjaxDelete(String num, Model model) {
		List<String> temp = new ArrayList<String>();
		try {
			temp.add(num); // 하나 삭제
			//for(String n : num) temp.add(n);
			memberService.delete(temp);
			model.addAttribute("message", num + " : 삭제 성공");
			return "Result";
		}catch(Exception e){
			model.addAttribute("title", "사원 정보 삭제  중 에러 발생");
			return "Error";
		}
	}
	
	@GetMapping("update.do")
	public String update(Member member, Model model) {
		System.out.println(member);
		try {
			memberService.update(member);
			System.out.println(member);
			model.addAttribute("title", "사원 관리 - 사원 상세 정보");
			model.addAttribute("member", member);
			return "redirect:/detail.do?num="+member.getNum();
		}catch(Exception e){
			model.addAttribute("title", "사원 정보 수정  중 에러 발생");
			return "Error";
		}
	}
}