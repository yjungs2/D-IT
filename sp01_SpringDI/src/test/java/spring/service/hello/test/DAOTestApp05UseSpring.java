package spring.service.hello.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.hello.Greet;
import spring.service.hello.Hello;

/*
 * FileName : HelloTestApp03UseSpring.java
 * ㅇ Hello.class 을 사용하는 Application
 * ㅇ Spring Framework 에서 제공하는 API를 사용하여 instance 생성
 * 		[[[ HelloTestApp02와 비교 ]]]
 * 		- hello.properties  ==> hello.xml
 * 		- HelloFactory ==> org.springframework.beans.factory.BeanFactory     
 
	==>	Spring Framework 은 다양한 메타데이터 중  xml 을 일반적으로 사용하며,
	  		instance 생성, 초기화, 객체의 상호 관계를  xml 에 선언적으로 기술. 
	 		( 사용자는Meta-Data 만 변경,수정 만으로 code 의  수정없이 instance 를 가능)
		
			<bean id="hello" class="spring.services.hello.Hello"/>
			
	==> 	HelloFactory :  Hello Data type 만 관리 하는 Factory 
	==> Spring Framework :모든 Data Type(Bean/POJO) 생성관리하는 Factory
 */
public class DAOTestApp05UseSpring {
	/// main method
	public static void main(String[] args) {
		//1. BeanFactory(Spring Container(?))을 이용 xml 에 선언적으로 기술된 instance 정보 획득
		BeanFactory factory =
				new XmlBeanFactory( new FileSystemResource
				("./src/main/resources/config/dao.xml") );

		//2. 빈을 얻어와서
		//MemberDAO greet = (Greet)factory.getBean("dao");
		
		//3. 비즈니스 로직을 호출...값은 여기서 주입...
		
		//마지막으로 그림 그려서...mm으로 제출
		
	}
}//end of class