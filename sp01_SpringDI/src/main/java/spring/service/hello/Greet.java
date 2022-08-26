package spring.service.hello;
/*
 * POJO, Bean 클래스 작성 규칙
 * 1. package
 * 2. 기본 생성자
 * 3. private field
 * 4. public setter/getter
 * 5. 메소드
 */
public class Greet {
	private String message;
	
	public Greet(){}

	public Greet(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	// message를 콘솔창으로 출력하는 기능
	public void sayMessage() {
		System.out.println("\n"+getClass().getName()+"==>"+message);
	}
}