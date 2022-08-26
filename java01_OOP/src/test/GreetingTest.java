package test;

// 한줄 주석 처리
/*
 GreetingTest는 문법은 자바 문법을 지켜서 작성한 코드이지만
 객체지향의 원리가 전혀 반영되지 않은 코드이다.
 
 해당 코드를 oop로 바꿔야 하는 이유는 과연 무엇인가?
 코드에 실제 값이 하드코딩 되어져서는 안 된다.
 
 1.대신에 값을 저장할 수 있는 공간을 만들어보겠다.
 그리고 공간에서 원하는 값을 실행할 때마다 넣어보자.
 
 2. 공간에 어떤 값이 저장될지는 알 수 없지만
 저장된 값을 콘솔창으로 출력할 수 있도록 해보겠다.
 
 => 1, 2번을 통해서 하나 만들어진 클래스는 여기저기서(다른 클래스들에서)
     사용할 수 있을 것. 재사용성이 높아진다.

 */
public class GreetingTest {

	public static void main(String[] args) {
		System.out.println("여러분 반갑습니다.");

	}

}
