package com.service.spring.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.spring.domain.Car;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.CarService;


@Controller
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:index.jsp"; // index
	}
	
	@GetMapping("regCar.do")
	public String getRegCar(Model model) {
		model.addAttribute("title", "자동차 관리 - 자동차 등록");
		return "CarReg";
	}
	
	@PostMapping("saveCar.do")
	public String doRegCar(@ModelAttribute Car car, Model model) {
		try {// 성공 페이지
			System.out.println(car);
			carService.insert(car);
			model.addAttribute("message", " : 자동차 등록 성공");
			return "Result";
		}catch(Exception e) {
			// 에러 페이지
			model.addAttribute("title", "자동차 입력 중 문제 발생");
			return "Error";
		}
	}
	
	@GetMapping("searchCar.do")
	public String doList(Model model) {
		try {
			List<Car> list = carService.select();
			model.addAttribute("title", "자동차 관리 - 리스트");
			model.addAttribute("car", list);
			return "CarList";
		} catch(Exception e) {
			model.addAttribute("title", "자동차 목록 조회 중 에러 발생");
			return "Error";
		}
	}
	
	@GetMapping("detail.do")
	public String doDetail(Car car, Model model) {
		try {
			Car selected = carService.select(car);
			model.addAttribute("title", "자동차 관리 - 자동차 조회");
			model.addAttribute("car", selected);
			return "CarView";
		} catch(Exception e) {
			model.addAttribute("title", "자동차 상세 조회 중 에러 발생");
			return "Error";
		}
	}
	
	@PostMapping("deleteAjax.do")
	@ResponseBody // 반환값 없음
	public String doAjaxDelete(@RequestParam List<String> num, Model model) {
		List<String> temp = new ArrayList<String>();
		try {
			for(String n : num) temp.add(n);
			carService.delete(temp);
			return ""; // 리다이렉트
		}catch(Exception e){
			model.addAttribute("title", "자동차 정보 삭제  중 에러 발생");
			return "Error";
		}
	}
	
	@GetMapping("update.do")
	public String update(Car car, Model model) {
		try {
			carService.update(car);
			System.out.println(car);
			model.addAttribute("title", "자동차 관리 - 자동차 조회");
			model.addAttribute("car", car);
			String encodedNum = URLEncoder.encode(car.getNum(), "UTF-8");
			return "redirect:/detail.do?num="+encodedNum;
		}catch(Exception e){
			model.addAttribute("title", "자동차 정보 수정  중 에러 발생");
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
			UserInfo selected = carService.select(user);
			if(selected!=null) { // 아이디 비번 일치하는 게 있는 경우
				session.setAttribute("loginUser", selected);
				return "redirect:/"; // redirect:searchCar.do
			}else {
				return "Login";
			}
		}catch(Exception e){
			model.addAttribute("title", "회원 로그인 중 에러 발생");
			return "Error";
		}
	}
	
	// 로그아웃
	@GetMapping("logout.do")
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		return "redirect:index.jsp";
	}
	
	// 회원가입
	@GetMapping("register.do")
	public String getRegisterForm() {
		return "Register";
	}
	
	@PostMapping("register.do")
	public String register(Model model, String id, String pw) {
		carService.registerMember(new UserInfo(id, pw));
		return "redirect:/index.jsp";
	}
}