package web.factory;

import web.controller.AddController;
import web.controller.Controller;
import web.controller.LoginController;
import web.controller.RemoveController;
import web.controller.UpdateController;

/*
 * ControllerFactory
 * :: Controller를 만드는 공장
 * 이곳에서
 * AddController, UpdateController, RemoveController, LoginController...생성...
 * ::
 * Singleton Pattern
 */
public class ControllerFactory {
	// 싱글톤
	private static ControllerFactory factory = new ControllerFactory();
	private ControllerFactory() {
		System.out.println("Creating ControllerFactory...");
	}
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		// if 조건 외에 Scanner 입력 받으면 null
		if(command.equals("INSERT")) {
			controller = new AddController();
			System.out.println("AddController Creating...ok");
		} else if(command.equals("DELETE")) {
			controller = new RemoveController();
			System.out.println("RemoveController Creating...ok");
		} else if(command.equals("UPDATE")) {
			controller = new UpdateController();
			System.out.println("UpdateController Creating...ok");
		} else if(command.equals("LOGIN")) {
			controller = new LoginController();
			System.out.println("LoginController Creating...ok");
		}
		return controller;
	}
}