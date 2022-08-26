package servlet.controller;

// 결과 페이지와 페이지 이동방법에 대한 정보를 담고 있는 클래스...
public class ModelAndView {
	
	private String path; // 결과 페이지 이름...
	private boolean isRedirect; // 페이지 이동 방법
	// boolean 기본값이 false라서 isForward가 아니라 isRedirect
	// false --> forward, true --> redirect
	
	public ModelAndView(String path, boolean isRedirect) { // redirect 일때만 생성자 2개
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public ModelAndView(String path) {
		super();
		this.path = path;
	}
	public ModelAndView() { }
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() { // is일 때는 get이 아니라 is
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}