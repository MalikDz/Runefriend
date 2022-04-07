package org.runefriend.client.uinterface.controller;

import java.util.Map;
import java.util.HashMap;
import org.runefriend.client.core.Session;
import org.runefriend.client.uinterface.controller.impl.ClientController;
import org.runefriend.client.uinterface.controller.impl.ExplorerController;
import org.runefriend.client.uinterface.controller.impl.UserLoginController;
import org.runefriend.client.uinterface.controller.impl.MenuToolbarController;

/**
 *  
 * @author MalikDz
 * 
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ControllerManager {

	/**
	 * 
	 * this map contains all of our controllers used to control our UI
	 * 
	 */

	private static Map<Class, BaseController> controllerMap = new HashMap<Class, BaseController>();

	/**
	 * 
	 * creates an instance of each controller and add it to our map
	 * 
	 */

	public static void init(Session session) {
		controllerMap.put(MenuToolbarController.class, new MenuToolbarController(session));
		controllerMap.put(UserLoginController.class, new UserLoginController(session));
		controllerMap.put(ExplorerController.class, new ExplorerController(session));
		controllerMap.put(ClientController.class, new ClientController());
	}

	/**
	 * 
	 * @return the controller that match the class key
	 * 
	 */

	public static <E extends BaseController> E get(Class classKey) {
		return org.runefriend.security.Security.isLocalMethodCall() ? (E) controllerMap.get(classKey) : null;
	}
}
