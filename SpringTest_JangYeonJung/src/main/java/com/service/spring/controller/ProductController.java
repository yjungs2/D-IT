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

import com.service.spring.domain.Product;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.ProductService;


@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:index.jsp"; // index
	}
	
	@GetMapping("regProduct.do")
	public String getRegProduct(Model model) {
		model.addAttribute("title", "상품 등록 화면");
		return "ProductReg";
	}
	
	@PostMapping("saveProduct.do")
	public String doRegProduct(@ModelAttribute Product product, Model model) {
		try {// 성공 페이지
			System.out.println(product);
			productService.insert(product);
			model.addAttribute("title", "결과 페이지");
			model.addAttribute("message", "저장");
			return "Result";
		}catch(Exception e) {
			// 에러 페이지
			model.addAttribute("title", "상품 저장 중 문제 발생");
			return "Error";
		}
	}
	
	@GetMapping("searchProduct.do")
	public String doList(Model model) {
		try {
			List<Product> list = productService.select();
			model.addAttribute("title", "상품 목록 화면");
			model.addAttribute("product", list);
			return "ProductList";
		} catch(Exception e) {
			model.addAttribute("title", "상품 목록 조회 중 에러 발생");
			return "Error";
		}
	}
	
	@GetMapping("detail.do")
	public String doDetail(Product product, Model model) {
		try {
			Product selected = productService.select(product);
			model.addAttribute("title", "입력된 상품 정보");
			model.addAttribute("product", selected);
			return "ProductView";
		} catch(Exception e) {
			model.addAttribute("title", "상품 상세 조회 중 에러 발생");
			return "Error";
		}
	}
	
	@GetMapping("deleteAjax.do")
	public String doAjaxDelete(String num, Model model) {
		List<String> temp = new ArrayList<String>();
		try {
			temp.add(num); // 하나 삭제
			productService.delete(temp);
			model.addAttribute("title", "결과 페이지");
			model.addAttribute("message", "삭제");
			return "Result";
		}catch(Exception e){
			model.addAttribute("title", "상품 삭제  중 에러 발생");
			return "Error";
		}
	}
	
	/*@GetMapping("update.do")
	public String update(Product car, Model model) {
		try {
			productService.update(car);
			System.out.println(car);
			model.addAttribute("title", "자동차 관리 - 자동차 조회");
			model.addAttribute("car", car);
			String encodedNum = URLEncoder.encode(car.getCode(), "UTF-8");
			return "redirect:/detail.do?num="+encodedNum;
		}catch(Exception e){
			model.addAttribute("title", "자동차 정보 수정  중 에러 발생");
			return "Error";
		}
	}*/
	
	// 로그인
	/*@GetMapping("login.do")
	public String getLoginForm() {
		return "Login";
	}*/	
	@PostMapping("login.do")
	public String doLogin(UserInfo user, Model model, HttpSession session) { 
		// 로그인, 업데이트는 세션에 바인딩하기 or request.getSession
		try {
			UserInfo selected = productService.select(user);
			System.out.println(user);
			if(selected!=null) { // 아이디 비번 일치하는 게 있는 경우
				session.setAttribute("loginUser", selected);
				return "redirect:/"; // redirect:searchCar.do
			}else {
				model.addAttribute("error", "아이디 또는 비밀번호가 맞지 않습니다.");
				return "/";
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
	
	/*// 회원가입
	@GetMapping("register.do")
	public String getRegisterForm() {
		return "Register";
	}
	@PostMapping("register.do")
	public String register(Model model, String id, String pw, String name) {
		productService.registerMember(new UserInfo(id, pw, name));
		return "redirect:/index.jsp";
	}*/
}