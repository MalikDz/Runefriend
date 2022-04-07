package org.runefriend.client.uinterface.controller.impl;

import org.runefriend.client.uinterface.view.ClientView;
import org.runefriend.client.uinterface.controller.BaseController;

/**
 * 
 * @author MalikDz
 *
 */

public class ClientController extends BaseController<ClientView, ClientController.Movement> {

	/**
	 * 
	 * this controller will handle the client frame movement
	 * 
	 */

	public ClientController() {
		super(new Movement());
	}

	/**
	 * 
	 * @return the current view for this controller or create one if needed
	 * 
	 */

	@Override
	public ClientView view() {
		return view == null ? (view = new ClientView(this)) : view;
	}

	/**
	 * 
	 * this function is responsible to show the client view
	 * 
	 */

	@Override
	public void show() {
		view().component().setLocationRelativeTo(null);
		view().component().setVisible(true);
	}

	/**
	 * 
	 * @author MalikDz
	 *
	 */

	static class Movement {

	}
}
