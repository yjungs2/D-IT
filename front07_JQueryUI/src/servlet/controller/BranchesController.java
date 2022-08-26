package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BranchesController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BranchesController...");
		
		// 디비 갔다왔다 치고...데이터 리턴...
		
		String result = "<ul><li>부산은행 본점</li>"
				+ "<li>기장 일광 지점</li>"
				+ "<li>사하구 지점</li>"
				+ "<li>동래 대신동 지점</li>"
				+ "<li>남구 남천동 지점</li>"
				+ "<li>장전 지구 지점</li></ul>";
		
		request.setAttribute("result", result);
		return new ModelAndView("Result.jsp");
	}
}