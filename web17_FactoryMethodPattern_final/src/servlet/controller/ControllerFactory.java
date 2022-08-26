package servlet.controller;
/*
 * 	Component를 생성하는 공장
 *  싱글톤으로 작성
 *  서버클라이언트가 보내는 Command 값에 따라서 생성되는 Component가 달라진다.
 */
public class ControllerFactory {
	private static ControllerFactory factory = new ControllerFactory();
	private ControllerFactory() {
		System.out.println("ControllerFactory...싱글톤...");
	}
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	// Component를 생성하는 기능...정의
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("find")) {
			controller = new FindController();
		} else if(command.equals("register")) {
			controller = new RegisterController();
		} else if(command.equals("login")) {
			controller = new LoginController();
		} else if(command.equals("showAll")) {
			controller = new ShowAllController();
		} else if(command.equals("logout")) {
			controller = new LogoutController();
		} else if(command.equals("update")) {
			controller = new UpdateController();
		}
		return controller;
	}
}