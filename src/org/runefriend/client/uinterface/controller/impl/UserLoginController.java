package org.runefriend.client.uinterface.controller.impl;

import java.awt.Frame;
import org.runefriend.client.core.Session;
import org.runefriend.client.uinterface.view.LoginUserView;
import org.runefriend.client.uinterface.controller.BaseController;
import org.runefriend.client.uinterface.controller.ControllerManager;

/**
 * 
 * @author MalikDz
 *
 */

public class UserLoginController extends BaseController<LoginUserView, Session> {

	/**
	 * 
	 * creates a controller that will control
	 * 
	 */

	public UserLoginController(Session session) {
		super(session);
	}

	/**
	 * 
	 * @return the user login view for further control on it
	 * 
	 */

	@Override
	public LoginUserView view() {
		return view == null ? (view = new LoginUserView(this)) : view;
	}

	/**
	 * 
	 * this function is responsible to show
	 * 
	 */

	@Override
	public void show() {
		ClientController clientController = ControllerManager.get(ClientController.class);
		view().component().setLocationRelativeTo(clientController.view().component());
		view().component().setVisible(true);
	}

	/**
	 * 
	 * minimize the client by putting in our toolbar
	 * 
	 */

	public void minimize() {
		view().component().setState(Frame.ICONIFIED);
	}

	/**
	 * 
	 * handle the x button by ending the program
	 * 
	 */

	public void end() {
		System.exit(0);
	}

	/**
	 * 
	 * handle what happens when the user click the login button
	 * 
	 */

	public void login() {
		ControllerManager.get(MenuToolbarController.class).show();
		ControllerManager.get(ClientController.class).show();
		view().component().dispose();
		((MenuToolbarController) ControllerManager.get(MenuToolbarController.class)).init();
	}
}
