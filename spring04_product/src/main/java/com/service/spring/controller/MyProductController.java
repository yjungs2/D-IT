package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.MyProduct;
import com.service.spring.model.MyProductService;

@Controller
public class MyProductController {
	@Autowired
	private MyProductService myProductService;
	
	@RequestMapping("myProduct.do")
	public ModelAndView insert(MyProduct vo) throws Exception{
		/* MyProduct vo가 자동 바인딩
		 * String name = request.getParameter("name");
		 * String maker = request.getParameter("maker");
		 * int price = Integer.parseInt(request.getParameter("price"));
		 * 
		 * MyProduct vo = new MyProduct(name, maker, price);
		 */
		
		// service.addProduct 호출 전 vo : 화면으로부터 받은 값을 가지고 만듦 -> id 비어있음
		System.out.println("디비 입력 전 :: "+vo.getId());
		
		myProductService.addProduct(vo); // --> dao.addProduct() --> session.insert()
		
		// service.addProduct 호출 후 vo : db 들러서 동기화 -> id 값까지 알고 있음
		System.out.println("디비 입력 후 :: "+vo.getId());
		
		// Request에 값이 바인딩되고 지정한 결과페이지로 forward 되어진다.
		return new ModelAndView("insert_result", "info", vo);
	}
	
	@RequestMapping("myProductSearch.do")
	public ModelAndView search(String command, String word) throws Exception{
		List<MyProduct> list = null;
		String viewName = "";
		if(command.equals("findProductByName")) {
			list = myProductService.findProductByName(word);
			viewName = "find_result";
		} else if(command.equals("findProductByMaker")) {
			list = myProductService.findProductByMaker(word);
			viewName = "find_result";
		} else if(command.equals("findProducts")) {
			list = myProductService.findProducts();
			viewName = "find_result";
		}
		return new ModelAndView(viewName, "list", list);
	}
}