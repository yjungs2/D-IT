package web.controller;
/*
 * RemoveController...실체클래스...구상객체
 * 
 * Component
 * :: 인터페이스 기반으로 만들어진 재사용성 강한 자바 클래스
 * 
 * 
 */
public class RemoveController implements Controller{

	@Override
	public String handle() {
		/*
		 * 1. 폼 값 받아서
		 * 2. vo 생성
		 * 3. biz 로직 호출
		 * 4. 바인딩
		 * 5. 네비게이션
		 */
		System.out.println("RemoveController...Register...logic");
		return "remove_result.jsp";
	}
}